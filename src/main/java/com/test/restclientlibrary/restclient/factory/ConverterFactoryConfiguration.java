package com.test.restclientlibrary.restclient.factory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.restclientlibrary.restclient.test.webuntis.entity.deserializer.WebUntisDayDeserializer;
import com.test.restclientlibrary.restclient.test.webuntis.entity.deserializer.WebUntisHolidayResultDeserializer;
import com.test.restclientlibrary.restclient.test.webuntis.entity.result.WebUntisDay;
import com.test.restclientlibrary.restclient.test.webuntis.entity.result.WebUntisHolidayResult;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConverterFactoryConfiguration implements IConverterFactoryConfiguration {
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Gson getGsonConvertConfiguration(){
        return new GsonBuilder()
                .registerTypeAdapter(WebUntisHolidayResult.class, new WebUntisHolidayResultDeserializer())
                .registerTypeAdapter(WebUntisDay.class, new WebUntisDayDeserializer())
                .create();
    }
}
