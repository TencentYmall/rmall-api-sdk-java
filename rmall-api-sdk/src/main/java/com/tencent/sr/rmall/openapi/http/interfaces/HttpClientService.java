package com.tencent.sr.rmall.openapi.http.interfaces;

import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.http.HttpResponseResult;
import com.tencent.sr.rmall.openapi.http.RequestBuilder;

/**
 * @author effortjiang
 * @date 2020-07-15
 */

public interface HttpClientService {


    /**
     * 发起http请求
     *
     * @param reqBuilder 请求参数对象
     * @return 响应体
     * @throws TsrSdkException
     */
    HttpResponseResult doRequest(RequestBuilder reqBuilder) throws TsrSdkException;


}
