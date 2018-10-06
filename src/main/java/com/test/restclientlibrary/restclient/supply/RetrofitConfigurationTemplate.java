package com.test.restclientlibrary.restclient.supply;

import com.test.restclientlibrary.restclient.generator.IRetrofitConfiguration;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Component;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
public class RetrofitConfigurationTemplate implements IRetrofitConfigurationTemplate{


    public IRetrofitConfiguration noAuthentication(String baseUrl) {
        return (httpClientFactory, converterFactory) -> {
            OkHttpClient.Builder baseClient = httpClientFactory
                    .getBaseClient()
                    .newBuilder()
                    .followRedirects(false);
            return
                    getDefaultRetroFitBuilderWithConverter(baseUrl, baseClient, converterFactory.getFactory(GsonConverterFactory.class))
                            .build();
        };
    }

    public IRetrofitConfiguration withAuthenticaton(String baseUrl, Interceptor securityInterceptor) {
        return (httpClientFactory, converterFactory) -> {
            OkHttpClient.Builder baseClient = httpClientFactory
                    .getBaseClient()
                    .newBuilder()
                    .addInterceptor(securityInterceptor);
            return
                    getDefaultRetroFitBuilderWithConverter(baseUrl, baseClient, converterFactory.getFactory(GsonConverterFactory.class))
                            .build();
        };
    }

    private Retrofit.Builder getDefaultRetroFitBuilderWithConverter(String baseUrl, OkHttpClient.Builder baseClient, Converter.Factory factory) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(factory)
                .client(baseClient.build());
    }
}
