package com.tencent.sr.rmall.openapi.http;

import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.utils.HttpJsonUtils;
import com.tencent.sr.rmall.openapi.utils.TsrExceptionUtil;

import java.io.Serializable;
import java.util.Map;

/**
 * @author effortjiang
 */

public class HttpResponseResult implements Serializable {

    private static final long serialVersionUID = 8056837663737531875L;

    private int httpCode;

    private String rspData;

    private Map<String, String> rspHeaders;

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public void setRspData(String rspData) {
        this.rspData = rspData;
    }

    public String getRspData() {
        return rspData;
    }

    public <T> T getRspData(Class<T> tClass) throws TsrSdkException {
        checkData();
        return HttpJsonUtils.parse(tClass, rspData);
    }


    public <T> HttpResult<T> getHttpResult(Class<T> tClass) throws TsrSdkException {
        checkData();
        return HttpJsonUtils.parseHttpResult(tClass, rspData);
    }

    public boolean isSuccessful() {
        return httpCode >= 200 && httpCode < 300;

    }

    public Map<String, String> getRspHeaders() {
        return rspHeaders;
    }

    public void setRspHeaders(Map<String, String> rspHeaders) {
        this.rspHeaders = rspHeaders;
    }


    private void checkData() throws TsrSdkException {
        if (rspData == null) {
            throw TsrExceptionUtil.throwDefaultException("httpResponse rspData is null");
        }
    }


}