package com.test.restclientlibrary.restclient.supply;

import com.test.restclientlibrary.restclient.token.TokenStore;
import okhttp3.CookieJar;
import okhttp3.Interceptor;

public interface IRetrofitInterceptorTemplate {
    Interceptor withBearerToken(TokenStore tokenStore);
    CookieJar withJsessonId(TokenStore tokenStore);
}
