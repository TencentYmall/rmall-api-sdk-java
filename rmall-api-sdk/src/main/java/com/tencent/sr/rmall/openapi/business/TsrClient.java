package com.tencent.sr.rmall.openapi.business;

import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.secure.Credential;
import com.tencent.sr.rmall.openapi.utils.SignUtils;

/**
 * @author effortjiang
 * @date 2020-07-15
 */

public class TsrClient {

    private static Credential cred = null;
    private static String endPoint = "https://oapi.vshop.qq.com";


    public static void init(Credential cred) throws TsrSdkException {
        SignUtils.validCredential(cred);
        TsrClient.cred = cred;
    }

    public static void init(Credential cred, String endPoint) throws TsrSdkException {
        SignUtils.validCredential(cred);
        TsrClient.cred = cred;
        TsrClient.endPoint = endPoint;
    }


    public static Credential getCred() {
        return cred;
    }


    public static String getEndPoint() {
        return endPoint;
    }

}
