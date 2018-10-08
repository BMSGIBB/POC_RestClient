package com.test.restclientlibrary.restclient.factory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;


@Service
public class ConverterFactory implements IConverterFactory{

    private IConverterFactoryConfiguration converterFactoryConfiguration;

    public ConverterFactory(IConverterFactoryConfiguration converterFactoryConfiguration) {
        this.converterFactoryConfiguration = converterFactoryConfiguration;
    }

    public Converter.Factory getFactory(Class<? extends Converter.Factory> factoryClass) {
        if (factoryClass.isAssignableFrom(GsonConverterFactory.class)) {
            return getGsonConverter();
        }
        return null;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    private Converter.Factory getGsonConverter() {
        return GsonConverterFactory.create(converterFactoryConfiguration.getGsonConvertConfiguration());
    }
}
