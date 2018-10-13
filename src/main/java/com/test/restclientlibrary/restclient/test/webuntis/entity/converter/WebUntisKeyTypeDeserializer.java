package com.test.restclientlibrary.restclient.test.webuntis.entity.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.test.restclientlibrary.restclient.test.webuntis.entity.result.WebUntisTimetableResult;
import com.test.restclientlibrary.restclient.test.webuntis.entity.supply.WebUntisTimeTableKeyType;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class WebUntisKeyTypeDeserializer extends JsonDeserializer<WebUntisTimeTableKeyType> {
    @Override
    public WebUntisTimeTableKeyType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return WebUntisTimeTableKeyType.getByCode(jsonParser.getValueAsString());
    }
}
