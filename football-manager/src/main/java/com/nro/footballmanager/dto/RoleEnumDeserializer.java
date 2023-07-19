package com.nro.footballmanager.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.nro.footballmanager.entity.enums.RoleEnum;

import java.io.IOException;

public class RoleEnumDeserializer extends JsonDeserializer<RoleEnum> {

    @Override
    public RoleEnum deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String value = jsonParser.getText();
        if (value == null || value.isEmpty()) {
            return null; // Handle empty or null values accordingly
        }
        return RoleEnum.valueOf(value.toUpperCase());
    }
}
