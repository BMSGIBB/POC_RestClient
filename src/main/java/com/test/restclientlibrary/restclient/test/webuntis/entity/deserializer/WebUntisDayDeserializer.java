package com.test.restclientlibrary.restclient.test.webuntis.entity.deserializer;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.google.gson.*;
import com.test.restclientlibrary.restclient.test.webuntis.entity.result.WebUntisDay;

import java.io.IOException;
import java.lang.reflect.Type;

public class WebUntisDayDeserializer implements JsonDeserializer<WebUntisDay> {
    @Override
    public WebUntisDay deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        int day = jsonElement.getAsInt();
        return WebUntisDay.getById(day);
    }
}
