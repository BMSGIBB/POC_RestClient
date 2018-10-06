package com.test.restclientlibrary.restclient.supply;

import okhttp3.Interceptor;

public interface IRetrofitInterceptorTemplate {
    Interceptor withBearerToken(String bearerToken);
}
