package com.tencent.sr.rmall.openapi.http.impl;

import com.tencent.sr.rmall.openapi.constant.TsrApiConstant;
import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.http.HttpResponseResult;
import com.tencent.sr.rmall.openapi.http.RequestBuilder;
import com.tencent.sr.rmall.openapi.http.interfaces.HeaderHandler;
import com.tencent.sr.rmall.openapi.http.interfaces.HttpClientService;
import com.tencent.sr.rmall.openapi.utils.HttpJsonUtils;
import com.tencent.sr.rmall.openapi.utils.TsrExceptionUtil;
import com.tencent.sr.rmall.openapi.utils.TsrHttpUtil;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author effortjiang
 * @date 2020-07-17
 */

public class HttpClientServiceImpl implements HttpClientService {

    private static final Logger log = LoggerFactory.getLogger(HttpClientServiceImpl.class);

    private static final int MAX_CONNECTION = 200;

    private CloseableHttpClient httpClient;

    public HttpClientServiceImpl() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(MAX_CONNECTION);
        connectionManager.setDefaultMaxPerRoute(MAX_CONNECTION);
        connectionManager.setValidateAfterInactivity(TsrApiConstant.VALIDATE_AFTER_INACTIVITY);
        httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy() {
                    @Override
                    public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
                        long keepAlive = super.getKeepAliveDuration(response, context);
                        if (keepAlive == -1) {
                            keepAlive = TsrApiConstant.DEFAULT_KEEP_ALIVE_TIME;
                        }
                        return keepAlive;
                    }
                })
                .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))
                .build();
    }


    @Override
    public HttpResponseResult doRequest(RequestBuilder reqBuilder) throws TsrSdkException {
        CloseableHttpResponse response = null;
        try {
            final HttpPost httpPost = new HttpPost(reqBuilder.getUrl());
            HttpEntity reqEntity = new StringEntity(HttpJsonUtils.toJson(reqBuilder.getBaseApiRequest()), ContentType.APPLICATION_JSON);
            httpPost.setEntity(reqEntity);
            TsrHttpUtil.addSecretHeaders(reqBuilder, new HeaderHandler() {
                @Override
                public void headHandler(String key, String value) {
                    httpPost.addHeader(key, value);
                }
            });
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            int statusCode = response.getStatusLine().getStatusCode();
            if (entity == null) {
                throw TsrExceptionUtil.throwDefaultException("response entity is null,code=" + statusCode);
            }
            //按指定编码转换结果实体为String类型
            String result = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            EntityUtils.consume(entity);
            Map<String, String> rspHeaders = new HashMap<>(16);
            for (Header header : response.getAllHeaders()) {
                rspHeaders.put(header.getName(), header.getValue());
            }
            return TsrHttpUtil.getResponseResult(statusCode, result, rspHeaders);
        } catch (IOException e) {
            throw TsrExceptionUtil.throwDefaultException(e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    log.error("response.close() error", e);
                }
            }
        }
    }


}
