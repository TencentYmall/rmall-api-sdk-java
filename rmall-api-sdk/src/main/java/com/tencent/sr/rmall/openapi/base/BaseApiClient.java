package com.tencent.sr.rmall.openapi.base;

import com.tencent.sr.rmall.openapi.business.TsrClient;
import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.http.HttpResponseResult;
import com.tencent.sr.rmall.openapi.http.HttpResult;
import com.tencent.sr.rmall.openapi.http.RequestBuilder;
import com.tencent.sr.rmall.openapi.http.annotation.ApiMapping;
import com.tencent.sr.rmall.openapi.http.enums.HttpServiceEnum;
import com.tencent.sr.rmall.openapi.http.factory.HttpClientFactory;
import com.tencent.sr.rmall.openapi.secure.Credential;
import com.tencent.sr.rmall.openapi.utils.*;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author effortjiang
 * @date 2020-07-15
 */

public class BaseApiClient {

    private static Map<String, Map<String, String>> apiUrlMap = new ConcurrentHashMap<>(256);

    private Credential cred;

    private String endPoint;

    private HttpServiceEnum httpServiceEnum = HttpServiceEnum.HTTP_CLIENT;

    private Map<String, String> headers = new HashMap<>(16);


    /**
     * (单位毫秒)读取超时时间 默认5秒
     */
    private int readTimeout = 5000;
    /**
     * (单位毫秒)连接超时时间 默认3秒
     */
    private int connectionTimeout = 3000;


    public String getEndPoint() {
        return StringUtils.isBlank(endPoint) ? TsrClient.getEndPoint() : endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public Credential getCred() {
        return cred == null ? TsrClient.getCred() : cred;
    }

    public void setCred(Credential cred) {
        this.cred = cred;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }


    protected RequestBuilder getPostBuilder(String url, BaseApiRequest request) throws TsrSdkException {
        validParams(url);
        url = getEndPoint() + url;
        RequestBuilder requestBuilder = new RequestBuilder()
                .url(url)
                .connectionTimeout(getConnectionTimeout())
                .readTimeout(getReadTimeout())
                .credential(getCred())
                .baseApiRequest(request)
                .postJson();
        if (getHeaders() != null) {
            requestBuilder.getHeaders().putAll(getHeaders());
        }
        return requestBuilder;
    }

    protected void validParams(String url) throws TsrSdkException {
        AssertUtil.notBlank(getEndPoint(), "endpoint");
        AssertUtil.notBlank(url, "url");
        SignUtils.validCredential(getCred());

    }


    protected String getUrl() throws TsrSdkException {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        Class<? extends BaseApiClient> apiClass = getClass();
        String className = apiClass.getName();
        for (StackTraceElement element : stackTrace) {
            if (!className.equals(element.getClassName())) {
                continue;
            }
            Map<String, String> urlMap = apiUrlMap.get(className);
            if (urlMap == null) {
                synchronized (apiClass.getName().intern()) {
                    if (apiUrlMap.get(className) == null) {
                        Map<String, String> resultMap = new ConcurrentHashMap<>(16);
                        String prefix = "";
                        ApiMapping prefixAnnotation = apiClass.getAnnotation(ApiMapping.class);
                        if (prefixAnnotation != null) {
                            prefix = prefixAnnotation.url();
                        }
                        Method[] declaredMethods = AnnotationUtil.getDeclaredMethods(getClass());
                        for (Method method : declaredMethods) {
                            ApiMapping annotation = AnnotationUtil.findAnnotation(method, ApiMapping.class);
                            if (annotation != null) {
                                resultMap.put(method.getName(), prefix + annotation.url());
                            }
                        }
                        apiUrlMap.put(className, resultMap);
                    }
                }
                urlMap = apiUrlMap.get(className);
            }
            String url = urlMap.get(element.getMethodName());
            if (StringUtils.isNotBlank(url)) {
                return url;
            }
        }
        return null;
    }


    protected final <T> HttpResult<T> doRequest(BaseApiRequest request, Class<T> tClass) throws TsrSdkException {
        try {
            HttpResponseResult result = HttpClientFactory.getHttpService(httpServiceEnum)
                    .doRequest(getPostBuilder(getUrl(), request));
            if (!result.isSuccessful()) {
                throw TsrExceptionUtil.throwDefaultException(result.getRspData());
            }
            return result.getHttpResult(tClass);
        } catch (TsrSdkException e) {
            throw e;
        } catch (Exception e) {
            throw TsrExceptionUtil.throwDefaultException(e);
        }
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void addHeader(String key, String value) {
        headers.put(key, value);
    }

    public HttpServiceEnum getHttpServiceEnum() {
        return httpServiceEnum;
    }

    public void setHttpServiceEnum(HttpServiceEnum httpServiceEnum) {
        this.httpServiceEnum = httpServiceEnum;
    }
}
