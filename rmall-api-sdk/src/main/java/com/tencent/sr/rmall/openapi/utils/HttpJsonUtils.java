package com.tencent.sr.rmall.openapi.utils;

import com.google.gson.Gson;
import com.tencent.sr.rmall.openapi.http.HttpResult;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author effortjiang
 */

public class HttpJsonUtils {

    private static final Gson gson = new Gson();


    public static String toJson(Object object) {
        return gson.toJson(object);
    }


    public static <T> T parse(Class<T> tClass, String json) {
        return gson.fromJson(json, tClass);
    }

    public static <T> HttpResult<T> parseHttpResult(final Class<T> tClass, String json) {
        return gson.fromJson(json, new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return new Class[]{tClass};
            }

            @Override
            public Type getRawType() {
                return HttpResult.class;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }
        });
    }


}
