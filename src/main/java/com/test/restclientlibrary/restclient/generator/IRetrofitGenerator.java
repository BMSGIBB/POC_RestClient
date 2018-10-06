package com.test.restclientlibrary.restclient.generator;

import retrofit2.Retrofit;

public interface IRetrofitGenerator {
    Retrofit generate(IRetrofitConfiguration generator);
}
