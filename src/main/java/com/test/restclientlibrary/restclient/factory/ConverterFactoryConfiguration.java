package com.test.restclientlibrary.restclient.factory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.restclientlibrary.restclient.test.webuntis.entity.supply.*;
import com.test.restclientlibrary.restclient.test.webuntis.entity.converter.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Date;

@Configuration
public class ConverterFactoryConfiguration implements IConverterFactoryConfiguration {
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Gson getGsonConvertConfiguration(){
        return new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateDeserializerGson())
                .registerTypeAdapter(Date.class, new DateSerializerGson())
                .registerTypeAdapter(WebUntisDay.class, new WebUntisDayDeserializer())
                .registerTypeAdapter(WebUntisTimetableLessonType.class, new WebUntisTimetableLessonTypeDesirializer())
                .registerTypeAdapter(WebUntisTimetableCode.class, new WebUntisTimetableCodeDesirializer())
                .registerTypeAdapter(WebUntisTimetableType.class, new WebUntisTimetableTypeSerializer())
                .registerTypeAdapter(WebUntisTimeTableKeyType.class, new WebUntisKeyTypeSerializer())
                .create();
    }
}
