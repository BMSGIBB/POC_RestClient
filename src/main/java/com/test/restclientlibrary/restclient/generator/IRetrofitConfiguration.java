package com.test.restclientlibrary.restclient.generator;

import com.test.restclientlibrary.restclient.factory.IConverterFactory;
import com.test.restclientlibrary.restclient.factory.IHttpClientFactory;
import retrofit2.Retrofit;

public interface IRetrofitConfiguration extends Function2<IHttpClientFactory, IConverterFactory, Retrofit> {
    @Override
    Retrofit apply(IHttpClientFactory httpClientFactory, IConverterFactory converterFactory);
}
