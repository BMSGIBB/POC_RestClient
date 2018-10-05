package com.test.restclientlibrary.restclient.supply;

import com.test.restclientlibrary.restclient.generator.RetrofitConfiguration;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCofigurations {

    public static RetrofitConfiguration notAuthentication(String baseUrl) {
        return (httpClientFactory, converterFactory) -> {
            OkHttpClient baseClient = httpClientFactory
                    .getBaseClient()
                    .newBuilder()
                    .followRedirects(false)
                    .build();

            Retrofit.Builder retrofit1 = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(converterFactory.getFactory(GsonConverterFactory.class))
                    .client(baseClient);

            return retrofit1.build();
        };
    }

//    (httpClientFactory, converterFactory) -> {
//        OkHttpClient baseClient = httpClientFactory
//                .getBaseClient()
//                .newBuilder()
//                .followRedirects(false)
//                .addInterceptor(chain -> {
//                    Request original = chain.request();
//                    Request request = original.newBuilder()
//                            .header("Authorization", String.format("Bearer %s", "<token>"))
//                            .build();
//                    return chain.proceed(request);
//                })
//                .build();
//
//        Retrofit.Builder retrofit1 = new Retrofit.Builder()
//                .baseUrl("https://frithjofhoppe.auth0.com/")
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .addConverterFactory(converterFactory.getFactory(GsonConverterFactory.class))
//                .client(baseClient);
//
//        return retrofit1.build();
//    };
}
