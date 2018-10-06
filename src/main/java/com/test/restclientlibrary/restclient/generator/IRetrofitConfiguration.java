package com.test.restclientlibrary.restclient.generator;

import com.test.restclientlibrary.restclient.factory.IConverterFactory;
import com.test.restclientlibrary.restclient.factory.IHttpClientFactory;
import retrofit2.Retrofit;

/**
 * @author Frithjof Hoppe
 */
public interface IRetrofitConfiguration extends Function2<IHttpClientFactory, IConverterFactory, Retrofit> {
    /**
     * Applies the configuration to the custom OkHttpClient 
     * @param httpClientFactory
     * @param converterFactory
     * @return
     */
    @Override
    Retrofit apply(IHttpClientFactory httpClientFactory, IConverterFactory converterFactory);
}
