package com.test.restclientlibrary.restclient.supply;

import com.test.restclientlibrary.restclient.token.TokenStore;
import okhttp3.Interceptor;
import okhttp3.Request;
import org.springframework.stereotype.Component;

@Component
public class RetrofitInterceptorTemplate implements IRetrofitInterceptorTemplate {
    public Interceptor withBearerToken(TokenStore tokenStore){
        return chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                    .header("Authorization", String.format("Bearer %s", tokenStore.getToken()))
                    .build();
            return chain.proceed(request);
        };
    }
}
