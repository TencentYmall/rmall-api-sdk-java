package com.tencent.sr.rmall.openapi.utils;

import com.tencent.sr.rmall.openapi.constant.TsrApiConstant;
import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.secure.Credential;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author effortjiang
 * @date 2020-07-14
 */

public class SignUtils {

    public static void validCredential(Credential cred) throws TsrSdkException {
        if (cred == null || StringUtils.isBlank(cred.getSecretId()) || StringUtils.isBlank(cred.getSecretId())) {
            throw TsrExceptionUtil.throwDefaultException("cred is invalid");
        }
    }


    public static String sign(String secretKey, String source, String timeStr) throws TsrSdkException {
        String signStr = "date: " + timeStr + "\n" + "source: " + source;
        String sig;
        Mac mac1;
        try {
            mac1 = Mac.getInstance(TsrApiConstant.HMAC_SHA1);
        } catch (NoSuchAlgorithmException e) {
            throw TsrExceptionUtil.throwDefaultException("HmacSHA1 is not supported.", e);
        }
        byte[] hash;
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), mac1.getAlgorithm());
        try {
            mac1.init(secretKeySpec);
        } catch (InvalidKeyException e) {
            throw TsrExceptionUtil.throwDefaultException(e);
        }
        hash = mac1.doFinal(signStr.getBytes(StandardCharsets.UTF_8));
        sig = Base64.encode(hash);
        return sig;
    }


    public static String getTime() {
        Calendar cd = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        return sdf.format(cd.getTime());
    }

    public static void main(String[] args) {
        String time = getTime();
        System.out.println(time);
    }


}
