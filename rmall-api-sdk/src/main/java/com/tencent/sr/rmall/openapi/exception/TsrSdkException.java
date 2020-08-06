package com.tencent.sr.rmall.openapi.exception;

import com.tencent.sr.rmall.openapi.constant.TsrApiConstant;

/**
 * @author effortjiang
 */

public class TsrSdkException extends Exception {

    private static final long serialVersionUID = 1L;

    private String requestId;
    private String code = TsrApiConstant.API_ERROR;

    public TsrSdkException(String message) {
        this(message, "");
    }

    public TsrSdkException(String message, String requestId) {
        super(message);
        this.requestId = requestId;
    }

    public TsrSdkException(String code, String message, String requestId) {
        super(message);
        this.code = code;
        this.requestId = requestId;
    }

    public TsrSdkException(String code, String message, String requestId, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.requestId = requestId;
    }


    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
