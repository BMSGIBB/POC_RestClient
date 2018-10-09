package com.test.restclientlibrary.restclient.test.webuntis.entity.converter;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSerializerGson implements JsonSerializer<Date> {
    @Override
    public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
        JsonElement jsonElement = new JsonPrimitive(Integer.parseInt(originalFormat.format(date)));
        return jsonElement;
    }
}

