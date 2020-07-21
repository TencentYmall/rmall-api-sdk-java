package com.tencent.sr.rmall.openapi.http;

import com.tencent.sr.rmall.openapi.constant.TsrApiConstant;
import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.http.interfaces.HeaderHandler;
import com.tencent.sr.rmall.openapi.utils.HttpJsonUtils;
import com.tencent.sr.rmall.openapi.utils.TsrExceptionUtil;
import com.tencent.sr.rmall.openapi.utils.TsrHttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author effortjiang
 * @date 2020-07-15
 */

public class HttpUrlUtils {

    private static final Logger log = LoggerFactory.getLogger(HttpUrlUtils.class);

    private static boolean closeRetry = false;

    /**
     * HostnameVerifier allowing wildcard certificates to work without adding them to the truststore.
     */
    private static final HostnameVerifier NAIVE_VERIFIER = new HostnameVerifier() {
        @Override
        public boolean verify(String hostname, SSLSession sslSession) {
            return true;
        }
    };

    public static HttpResponseResult doRequest(RequestBuilder reqBuilder) throws TsrSdkException {
        OutputStream outputStream = null;
        InputStream inputStream = null;
        HttpURLConnection con = getConnection(reqBuilder);
        try {
            con.connect();
            outputStream = con.getOutputStream();
            String data = HttpJsonUtils.toJson(reqBuilder.getBaseApiRequest());
            outputStream.write(data.getBytes());
            outputStream.flush();
            int responseCode = con.getResponseCode();
            boolean success = responseCode == TsrApiConstant.HTTP_OK;
            inputStream = success ? con.getInputStream() : con.getErrorStream();
            String result = TsrHttpUtil.getStringByInputStream(inputStream);
            Map<String, List<String>> headerFields = con.getHeaderFields();
            Map<String, String> headers = new HashMap<>(16);
            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                headers.put(entry.getKey(), getHeadValue(entry.getValue()));
            }
            return TsrHttpUtil.getResponseResult(responseCode, result, headers);
        } catch (IOException e) {
            throw TsrExceptionUtil.throwDefaultException(e);
        } finally {
            TsrHttpUtil.closeOutputStream(outputStream);
            TsrHttpUtil.closeInputStream(inputStream);
            con.disconnect();
        }

    }

    private static String getHeadValue(List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(list.get(0));
        if (list.size() > 1) {
            for (int i = 1; i < list.size(); i++) {
                sb.append(";");
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }


    private static HttpURLConnection getConnection(RequestBuilder reqBuilder) throws TsrSdkException {
        try {
            closeRetry();
            final HttpURLConnection connection;
            String reqUrl = reqBuilder.getUrl();
            URL url = new URL(reqUrl);
            connection = (HttpURLConnection) url.openConnection();
            if (reqBuilder.isBypassSecurity() && connection instanceof HttpsURLConnection) {
                ((HttpsURLConnection) connection).setHostnameVerifier(NAIVE_VERIFIER);
            }
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setConnectTimeout(reqBuilder.getConnectionTimeout());
            connection.setReadTimeout(reqBuilder.getReadTimeout());
            connection.setRequestMethod(reqBuilder.getMethod());
            TsrHttpUtil.addSecretHeaders(reqBuilder, new HeaderHandler() {
                @Override
                public void headHandler(String key, String value) {
                    connection.setRequestProperty(key, value);
                }
            });
            return connection;
        } catch (IOException e) {
            throw TsrExceptionUtil.throwDefaultException(e);
        }
    }

    private static void closeRetry() {
        if (!closeRetry) {
            System.setProperty("sun.net.http.retryPost", "false");
            closeRetry = true;
        }
    }

}
