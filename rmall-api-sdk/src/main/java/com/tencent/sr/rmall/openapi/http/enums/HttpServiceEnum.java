package com.tencent.sr.rmall.openapi.http.enums;

/**
 * @author effortjiang
 * @date 2020-07-18
 */

public enum HttpServiceEnum {

    /**
     * HttpURLConnection发起请求
     */
    HTTP_URL_CONNECTION(1, "HTTP_URL_CONNECTION"),
    /**
     * HttpClient发起请求
     */
    HTTP_CLIENT(2, "HTTP_CLIENT");

    private int code;
    private String httpServiceName;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getHttpServiceName() {
        return httpServiceName;
    }

    public void setHttpServiceName(String httpServiceName) {
        this.httpServiceName = httpServiceName;
    }


    HttpServiceEnum(int code, String httpServiceName) {
        this.code = code;
        this.httpServiceName = httpServiceName;
    }


}
