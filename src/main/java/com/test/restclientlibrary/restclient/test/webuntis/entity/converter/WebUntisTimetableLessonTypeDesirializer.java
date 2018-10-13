package com.test.restclientlibrary.restclient.test.webuntis.entity.converter;


import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.test.restclientlibrary.restclient.test.webuntis.entity.supply.WebUntisTimetableLessonType;

import java.lang.reflect.Type;

public class WebUntisTimetableLessonTypeDesirializer implements JsonDeserializer<WebUntisTimetableLessonType> {
    @Override
    public WebUntisTimetableLessonType deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return WebUntisTimetableLessonType.getByIdentifier(jsonElement.getAsString());
    }
}
