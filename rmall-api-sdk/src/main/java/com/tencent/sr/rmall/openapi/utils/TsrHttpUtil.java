package com.tencent.sr.rmall.openapi.utils;

import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.http.HttpResponseResult;
import com.tencent.sr.rmall.openapi.http.RequestBuilder;
import com.tencent.sr.rmall.openapi.http.interfaces.HeaderHandler;
import com.tencent.sr.rmall.openapi.secure.Credential;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.tencent.sr.rmall.openapi.constant.TsrApiConstant.BLANK;
import static com.tencent.sr.rmall.openapi.constant.TsrApiConstant.DOT_SPLIT;

/**
 * @author effortjiang
 * @date 2020-07-15
 */

public class TsrHttpUtil {

    private static final Logger log = LoggerFactory.getLogger(TsrHttpUtil.class);

    public static String getStringByInputStream(InputStream inputStream) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        StringBuilder response = new StringBuilder();
        String responseLine;
        while ((responseLine = br.readLine()) != null) {
            response.append(responseLine.trim());
        }
        return response.toString();
    }


    public static void addSecretHeaders(RequestBuilder reqBuilder, HeaderHandler headerHandler) throws TsrSdkException {
        if (reqBuilder == null || headerHandler == null) {
            throw TsrExceptionUtil.throwDefaultException("addSecretHeaders params is null");
        }
        Credential credential = reqBuilder.getCredential();
        SignUtils.validCredential(credential);
        String timeStr = SignUtils.getTime();
        String source = credential.getSource();
        String sign = SignUtils.sign(credential.getSecretKey(), source, timeStr);
        log.debug("secretId " + credential.getSecretId() + " sign=" + sign);
        String auth = "hmac id=\"" + credential.getSecretId() +
                "\", algorithm=\"hmac-sha1\", headers=\"date source\", signature=\"" + sign + "\"";
        Map<String, String> headerMap = new HashMap<>(8);
        headerMap.put("Authorization", auth);
        headerMap.put("Source", source);
        headerMap.put("Date", timeStr);
        if (reqBuilder.getContentType() != null) {
            headerMap.put("Content-Type", reqBuilder.getContentType());
            headerMap.put("Accept", reqBuilder.getContentType());
        }
        Map<String, String> reqHeaders = reqBuilder.getHeaders();
        if (reqHeaders != null && reqHeaders.size() > 0) {
            headerMap.putAll(reqHeaders);
        }
        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            headerHandler.headHandler(entry.getKey(), entry.getValue());
        }
        printCurlLog(reqBuilder, headerMap);
    }


    public static void printCurlLog(RequestBuilder reqBuilder, Map<String, String> headerMap) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("curl ");
            sb.append(reqBuilder.getUrl()).append(BLANK);
            sb.append("-X ").append(reqBuilder.getMethod()).append(BLANK);
            if (headerMap != null) {
                for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                    sb.append("-H ")
                            .append(DOT_SPLIT)
                            .append(entry.getKey())
                            .append(":")
                            .append(BLANK)
                            .append(entry.getValue())
                            .append(DOT_SPLIT)
                            .append(BLANK);
                }
            }
            sb.append("-d '").append(HttpJsonUtils.toJson(reqBuilder.getBaseApiRequest())).append(DOT_SPLIT);
            log.debug(sb.toString());
        } catch (Throwable throwable) {
            log.error("printCurlLog error", throwable);
        }
    }

    public static HttpResponseResult getResponseResult(int httpCode, String result, Map<String, String> rspHeaders) {
        HttpResponseResult responseResult = new HttpResponseResult();
        responseResult.setHttpCode(httpCode);
        responseResult.setRspData(result);
        responseResult.setRspHeaders(rspHeaders);
        return responseResult;
    }


    public static void closeOutputStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                log.error("outputStream close error", e);
            }
        }
    }

    public static void closeInputStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                log.error("inputStream close error", e);
            }
        }
    }


}
