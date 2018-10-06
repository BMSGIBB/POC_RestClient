package com.test.restclientlibrary.restclient.supply;

import com.test.restclientlibrary.restclient.generator.RetrofitConfiguration;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
public class RetrofitCofigurations {

    public RetrofitConfiguration notAuthentication(String baseUrl) {
        return (httpClientFactory, converterFactory) -> {
            OkHttpClient.Builder baseClient = httpClientFactory
                    .getBaseClient()
                    .newBuilder()
                    .followRedirects(false);

            Retrofit.Builder retrofit1 = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(converterFactory.getFactory(GsonConverterFactory.class))
                    .client(baseClient.build());

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
