package com.test.restclientlibrary.restclient.supply;

import com.test.restclientlibrary.restclient.generator.IRetrofitConfiguration;
import okhttp3.Interceptor;

public interface IRetrofitConfigurationTemplate {
    IRetrofitConfiguration noAuthentication(String baseUrl);
    IRetrofitConfiguration withAuthenticaton(String baseUrl, Interceptor securityInterceptor);
}
