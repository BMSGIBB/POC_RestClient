package com.test.restclientlibrary.restclient.test.webuntis.entity.converter;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.test.restclientlibrary.restclient.test.webuntis.entity.supply.WebUntisTimeTableKeyType;

import java.lang.reflect.Type;

public class WebUntisKeyTypeSerializer implements JsonSerializer<WebUntisTimeTableKeyType> {
    @Override
    public JsonElement serialize(WebUntisTimeTableKeyType webUntisTimeTableKeyType, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonElement jsonElement = new JsonPrimitive(webUntisTimeTableKeyType.getKeyType());
        return jsonElement;
    }
}
