/*
 * Copyright (c) 2017-2018 THL A29 Limited, a Tencent company. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tencent.sr.rmall.openapi.business.right;

import com.tencent.sr.rmall.openapi.base.BaseApiClient;
import com.tencent.sr.rmall.openapi.business.right.request.GetcancelListOpenApiRequest;
import com.tencent.sr.rmall.openapi.business.right.response.RightsListOpenApiResponse;
import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.http.HttpResult;
import com.tencent.sr.rmall.openapi.http.annotation.ApiMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author zhuangruiting
 */
@ApiMapping(url = "/api/v2/openapi/rights")
public class TsrRightV2Client extends BaseApiClient {

    private static final Logger log = LoggerFactory.getLogger(TsrRightV2Client.class);

    /**
     * openapi查看未发货退款单列表
     *
     * @return
     * @throws TsrSdkException
     */
    @ApiMapping(url = "/getCancelList")
    public HttpResult<RightsListOpenApiResponse> getCancelList(GetcancelListOpenApiRequest request) throws TsrSdkException {
        return doRequest(request, RightsListOpenApiResponse.class);
    }




}
