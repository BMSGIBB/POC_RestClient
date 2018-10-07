package com.test.restclientlibrary.restclient.supply;

import com.test.restclientlibrary.restclient.token.TokenStore;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class RetrofitInterceptorTemplate implements IRetrofitInterceptorTemplate {
    @Override
    public Interceptor withBearerToken(TokenStore tokenStore) {
        return chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                    .header("Authorization", String.format("Bearer %s", tokenStore.getToken()))
                    .build();
            return chain.proceed(request);
        };
    }

    @Override
    public CookieJar withJsessonId(TokenStore tokenStore) {
        return new CookieJar() {

            private final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

            @Override
            public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
                cookieStore.put(httpUrl.host(), list);
            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl httpUrl) {
                List<Cookie> urlCookie = cookieStore.get(httpUrl.host());
                List<Cookie> cookies = urlCookie == null? new ArrayList<Cookie>() : urlCookie;
                Cookie cookie = new Cookie
                        .Builder()
                        .domain("tipo.webuntis.com")
                        .expiresAt(86400l)
                        .path("/WebUntis")
                        .httpOnly()
                        .name("JSESSIONID")
                        .value(tokenStore.getToken())
                        .build();
                cookies.add(cookie);
                return cookies;
            }
        };
    }
}
