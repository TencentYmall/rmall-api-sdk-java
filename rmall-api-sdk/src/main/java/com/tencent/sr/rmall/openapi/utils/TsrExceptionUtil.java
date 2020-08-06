package com.tencent.sr.rmall.openapi.utils;

import com.tencent.sr.rmall.openapi.exception.TsrSdkException;

/**
 * @author effortjiang
 */

public class TsrExceptionUtil {


    public static TsrSdkException throwDefaultException(String code, String msg, String requestId) {
        return new TsrSdkException(code, msg, requestId);
    }

    public static TsrSdkException throwDefaultException(String msg) {
        return new TsrSdkException(msg);
    }

    public static TsrSdkException throwDefaultException(String msg, Exception e) {
        return new TsrSdkException(msg + e.getMessage());
    }


    public static TsrSdkException throwDefaultException(Exception e) {
        return new TsrSdkException(e.getClass().getName() + "-" + e.getMessage());
    }


}
