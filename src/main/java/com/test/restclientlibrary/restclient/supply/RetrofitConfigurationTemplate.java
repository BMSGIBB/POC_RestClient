package com.test.restclientlibrary.restclient.supply;

import com.test.restclientlibrary.restclient.generator.IRetrofitConfiguration;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import org.springframework.stereotype.Component;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Component
public class RetrofitConfigurationTemplate implements IRetrofitConfigurationTemplate {


    @Override
    public IRetrofitConfiguration noAuthentication(String baseUrl) {
        return (httpClientFactory, converterFactory) -> {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder baseClient = httpClientFactory
                    .getBaseClient()
                    .newBuilder()
                    .
                            addInterceptor(chain -> {
                                Request original = chain.request();
                                Request copy = original.newBuilder().build();
                                Buffer buffer = new Buffer();
                                copy.body().writeTo(buffer);
                                System.out.println(buffer.readUtf8());
                                return chain.proceed(original);
                            })
                    .addInterceptor(logging);
            return
                    getDefaultRetroFitBuilderWithConverter(baseUrl, baseClient, converterFactory.getFactory(GsonConverterFactory.class))
                            .build();
        };
    }

    @Override
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

    @Override
    public IRetrofitConfiguration withCookieAuhentication(String baseUrl, CookieJar cookieJar) {
        return (httpClientFactory, converterFactory) -> {

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder baseClient = httpClientFactory
                    .getBaseClient()
                    .newBuilder()
                    .addInterceptor(logging)
                    .cookieJar(cookieJar);
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
