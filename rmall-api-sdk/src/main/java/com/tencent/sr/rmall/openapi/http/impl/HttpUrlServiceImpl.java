package com.tencent.sr.rmall.openapi.http.impl;

import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.http.interfaces.HttpClientService;
import com.tencent.sr.rmall.openapi.http.HttpResponseResult;
import com.tencent.sr.rmall.openapi.http.HttpUrlUtils;
import com.tencent.sr.rmall.openapi.http.RequestBuilder;

/**
 * @author effortjiang
 * @date 2020-07-15
 */

public class HttpUrlServiceImpl implements HttpClientService {



    @Override
    public HttpResponseResult doRequest(RequestBuilder reqBuilder) throws TsrSdkException {
        return HttpUrlUtils.doRequest(reqBuilder);
    }


}
