package com.tencent.sr.rmall.openapi.http.factory;

import com.tencent.sr.rmall.openapi.http.enums.HttpServiceEnum;
import com.tencent.sr.rmall.openapi.http.impl.HttpClientServiceImpl;
import com.tencent.sr.rmall.openapi.http.impl.HttpUrlServiceImpl;
import com.tencent.sr.rmall.openapi.http.interfaces.HttpClientService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.tencent.sr.rmall.openapi.http.enums.HttpServiceEnum.HTTP_CLIENT;

/**
 * @author effortjiang
 * @date 2020-07-15
 */

public class HttpClientFactory {

    private static Map<Integer, HttpClientService> httpClientServiceMap = new ConcurrentHashMap<>(8);


    public static HttpClientService getHttpService(HttpServiceEnum serviceEnum) {
        if (serviceEnum == null) {
            serviceEnum = HTTP_CLIENT;
        }
        int code = serviceEnum.getCode();
        HttpClientService httpClientService = httpClientServiceMap.get(code);
        if (httpClientService == null) {
            synchronized (serviceEnum.getHttpServiceName().intern()) {
                if (httpClientServiceMap.get(code) == null) {
                    switch (serviceEnum) {
                        case HTTP_URL_CONNECTION:
                            httpClientService = new HttpUrlServiceImpl();
                            break;
                        case HTTP_CLIENT:
                        default:
                            httpClientService = new HttpClientServiceImpl();
                    }
                    httpClientServiceMap.put(code, httpClientService);
                }
                httpClientService = httpClientServiceMap.get(code);
            }
        }
        return httpClientService;

    }


}
