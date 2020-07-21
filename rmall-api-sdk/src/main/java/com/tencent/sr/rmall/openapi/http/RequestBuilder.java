package com.tencent.sr.rmall.openapi.http;

import com.tencent.sr.rmall.openapi.base.BaseApiRequest;
import com.tencent.sr.rmall.openapi.constant.TsrApiConstant;
import com.tencent.sr.rmall.openapi.secure.Credential;

import java.util.HashMap;
import java.util.Map;

/**
 * @author effortjiang
 * @date 2020-07-15
 */
public class RequestBuilder {

    /**
     * 请求地址 必填
     */
    private String url;
    private String method;
    private String contentType;
    private BaseApiRequest baseApiRequest;
    private Credential credential;

    private Map<String, String> headers = new HashMap<>(16);


    /**
     * Setting allowing to bypass the security system which requires wildcard certificates
     * to be added to the truststore.
     */
    private boolean bypassSecurity = true;

    /**
     * 默认开启监控上报
     */
    private boolean monitor = true;

    /**
     * 默认打印debug日志
     */
    private boolean printLog = true;

    /**
     * (单位毫秒)读取超时时间 默认6秒
     */
    private int readTimeout = 6000;
    /**
     * (单位毫秒)连接超时时间 默认3秒
     */
    private int connectionTimeout = 3000;

    public RequestBuilder() {
        this.method = TsrApiConstant.GET;
    }


    public RequestBuilder(BaseApiRequest baseApiRequest, Credential credential) {
        this.method = TsrApiConstant.POST;
    }


    public boolean isPrintLog() {
        return printLog;
    }


    public Map<String, String> getHeaders() {
        if (headers == null) {
            headers = new HashMap<>(16);
        }
        return headers;
    }


    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }


    public int getReadTimeout() {
        return readTimeout;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public boolean isMonitor() {
        return monitor;
    }

    public RequestBuilder url(String url) {
        this.url = url;
        return this;
    }


    public RequestBuilder method(String method) {
        this.method = method;
        return this;
    }

    public RequestBuilder monitor(boolean monitor) {
        this.monitor = monitor;
        return this;
    }

    public RequestBuilder printLog(boolean printLog) {
        this.printLog = printLog;
        return this;
    }

    public RequestBuilder header(String key, String value) {
        headers.put(key, value);
        return this;
    }

    public RequestBuilder readTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    public RequestBuilder connectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
        return this;
    }

    public String getContentType() {
        return contentType;
    }

    public RequestBuilder contentType(String contentType) {
        this.contentType = contentType;
        return this;
    }


    public RequestBuilder get() {
        return method(TsrApiConstant.GET);
    }

    public RequestBuilder postJson() {
        method(TsrApiConstant.POST);
        contentType(TsrApiConstant.JSON_TYPE);
        return this;
    }


    public BaseApiRequest getBaseApiRequest() {
        return baseApiRequest;
    }

    public RequestBuilder baseApiRequest(BaseApiRequest baseApiRequest) {
        this.baseApiRequest = baseApiRequest;
        return this;
    }

    public Credential getCredential() {
        return credential;
    }

    public RequestBuilder credential(Credential credential) {
        this.credential = credential;
        return this;
    }

    public boolean isBypassSecurity() {
        return bypassSecurity;
    }

    public RequestBuilder bypassSecurity(boolean bypassSecurity) {
        this.bypassSecurity = bypassSecurity;
        return this;
    }
}
