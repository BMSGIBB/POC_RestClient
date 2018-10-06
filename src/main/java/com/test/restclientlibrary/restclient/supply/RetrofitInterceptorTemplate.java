package com.test.restclientlibrary.restclient.supply;

import okhttp3.Interceptor;
import okhttp3.Request;
import org.springframework.stereotype.Component;

@Component
public class RetrofitInterceptorTemplate implements IRetrofitInterceptorTemplate {
    public Interceptor withBearerToken(String bearerToken){
        return chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                    .header("Authorization", String.format("Bearer %s", bearerToken))
                    .build();
            return chain.proceed(request);
        };
    }
}
