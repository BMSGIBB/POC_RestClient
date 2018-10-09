package com.test.restclientlibrary.restclient.test.webuntis.entity.converter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.test.restclientlibrary.restclient.test.webuntis.entity.result.WebUntisTimetableCode;

import java.lang.reflect.Type;

public class WebUntisTimetableCodeDesirializer implements JsonDeserializer<WebUntisTimetableCode> {
    @Override
    public WebUntisTimetableCode deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return WebUntisTimetableCode.getByCode(jsonElement.getAsString());
    }
}
