package com.test.restclientlibrary.restclient.generator;

import com.test.restclientlibrary.restclient.factory.IConverterFactory;
import com.test.restclientlibrary.restclient.factory.IHttpClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RetrofitGenerator implements IRetrofitGenerator {

    IHttpClientFactory clientFactory;
    IConverterFactory converterFactory;

    @Autowired
    public RetrofitGenerator(IHttpClientFactory clientFactory, IConverterFactory converterFactory) {
        this.clientFactory = clientFactory;
        this.converterFactory = converterFactory;
    }

    @Override
    public Retrofit generate(RetrofitConfiguration generator) {
        return generator.apply(clientFactory,converterFactory);
    }
}
