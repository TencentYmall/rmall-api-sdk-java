package com.tencent.sr.rmall.openapi.demo;

import com.tencent.sr.rmall.openapi.business.TsrClient;
import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.secure.Credential;

/**
 * @author effortjiang
 * @date 2020-07-17
 */

public class InitUtil {


    public static void initSecret(String url) throws TsrSdkException {
        Credential credential = init();
        TsrClient.init(credential, url);
    }

    public static void initSecret() throws TsrSdkException {
        Credential credential = init();
        TsrClient.init(credential);
    }

    public static Credential init() {
        //全局初始化密钥  如果应用密钥唯一 初始化一次即可
        //q享qa环境密钥demo
        String secretId = "AKIDNxcOd6uuqlce25ajKLlb73k0582nfWPlSok5";
        String secretKey = "E80EWIYrJogWkjK6az0bKGk1YXS1x4hNulMrt3rn";
        Credential credential = new Credential(secretId, secretKey);
        return credential;
    }


}
