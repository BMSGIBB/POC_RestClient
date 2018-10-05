package com.test.restclientlibrary.restclient.factory;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class ConverterFactory implements IConverterFactory{

    public ConverterFactory() {
    }

    public Converter.Factory getFactory(Class<? extends Converter.Factory> factoryClass) {
        if (factoryClass.isInstance(GsonConverterFactory.class)) {
            return getGsonConverter();
        }
        return null;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    private GsonConverterFactory getGsonConverter() {
        return GsonConverterFactory.create();
    }
}
