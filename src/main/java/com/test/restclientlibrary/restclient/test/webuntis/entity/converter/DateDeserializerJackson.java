package com.test.restclientlibrary.restclient.test.webuntis.entity.converter;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@JsonComponent
public class DateDeserializerJackson extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
        try {
            return originalFormat.parse(jsonParser.getValueAsString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }
}
