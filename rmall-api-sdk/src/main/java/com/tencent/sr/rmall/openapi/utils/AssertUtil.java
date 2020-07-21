package com.tencent.sr.rmall.openapi.utils;

import com.tencent.sr.rmall.openapi.exception.TsrSdkException;

/**
 * @author effortjiang
 * @date 2020-07-16
 */

public class AssertUtil {

    public static void notBlank(String cs, String msg) throws TsrSdkException {
        if (StringUtils.isBlank(cs)) {
            throw TsrExceptionUtil.throwDefaultException(msg + " is blank");
        }
    }

    public static void notNull(Object object, String msg) throws TsrSdkException {
        if (object == null) {
            throw TsrExceptionUtil.throwDefaultException(msg);
        }
    }

}
