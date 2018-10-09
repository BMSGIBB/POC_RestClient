package com.test.restclientlibrary.restclient.test.webuntis.entity.converter;


import com.google.gson.*;
import com.test.restclientlibrary.restclient.test.webuntis.entity.result.WebUntisDay;

import java.lang.reflect.Type;

public class WebUntisDayDeserializer implements JsonDeserializer<WebUntisDay> {
    @Override
    public WebUntisDay deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return WebUntisDay.getById(jsonElement.getAsInt());
    }
}
