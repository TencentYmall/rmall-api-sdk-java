package com.tencent.sr.rmall.openapi.utils;

import com.tencent.sr.rmall.openapi.exception.TsrSdkException;

/**
 * @author effortjiang
 * @date 2020-07-15
 */

public class StringUtils {

    public static boolean equalsIgnoreCase(String source, String des) {
        if (source == null || des == null) {
            return false;
        }
        return source.toLowerCase().equals(des.toLowerCase());
    }

    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }


    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }


    public static void checkBlank(String cs, String msg) throws TsrSdkException {
        if (StringUtils.isBlank(cs)) {
            throw TsrExceptionUtil.throwDefaultException(msg + " is blank");
        }
    }


}
