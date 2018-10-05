package com.test.restclientlibrary.restclient.factory;

import okhttp3.OkHttpClient;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class HttpClientFactory implements IHttpClientFactory {
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public OkHttpClient getBaseClient(){
        return new OkHttpClient();
    }
}
