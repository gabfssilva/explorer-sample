package br.com.explorer.sample.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
public class JsonUtils {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private JsonUtils(){}

    public static <T> T asObject(String content, Class<T> clazz){
        try {
            return OBJECT_MAPPER.readValue(content, clazz);
        } catch (IOException e) {
            throw new JsonParseException("Could not parse value to " + clazz.getSimpleName() + " type", e);
        }
    }

    public static String asJson(Object o){
        try {
            return OBJECT_MAPPER.writeValueAsString(o);
        } catch (IOException e) {
            throw new JsonParseException("Could not parse value from " + o.getClass().getSimpleName() + " type", e);
        }
    }

    public static class JsonParseException extends RuntimeException {
        public JsonParseException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
