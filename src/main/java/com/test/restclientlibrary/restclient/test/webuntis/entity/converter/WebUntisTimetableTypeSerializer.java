package com.test.restclientlibrary.restclient.test.webuntis.entity.converter;



import com.google.gson.*;
import com.test.restclientlibrary.restclient.test.webuntis.entity.WebUntisTimetableType;

import java.io.IOException;
import java.lang.reflect.Type;

public class WebUntisTimetableTypeSerializer implements JsonSerializer<WebUntisTimetableType> {
    @Override
    public JsonElement serialize(WebUntisTimetableType webUntisTimetableType, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonElement jsonElement = new JsonPrimitive(webUntisTimetableType.id);
        return jsonElement;
    }
}
