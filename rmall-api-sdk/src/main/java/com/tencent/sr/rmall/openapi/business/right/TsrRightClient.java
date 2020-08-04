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
import com.tencent.sr.rmall.openapi.business.right.request.*;
import com.tencent.sr.rmall.openapi.business.right.response.RightsDetailOpenApiResponse;
import com.tencent.sr.rmall.openapi.business.right.response.RightsListOpenApiResponse;
import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.http.HttpResult;
import com.tencent.sr.rmall.openapi.http.annotation.ApiMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author chenxiaodong
 */
@ApiMapping(url = "/api/v1/openapi/rights")
public class TsrRightClient extends BaseApiClient {

    private static final Logger log = LoggerFactory.getLogger(TsrRightClient.class);

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


    /**
     * openapi查看退款单详情
     *
     * @return
     * @throws TsrSdkException
     */
    @ApiMapping(url = "/getCancelDetail")
    public HttpResult<RightsDetailOpenApiResponse> getCancelDetail(GetRightsDetailOpenApiRequest request) throws TsrSdkException {
        return doRequest(request, RightsDetailOpenApiResponse.class);
    }


    /**
     * openapi同意退款申请
     *
     * @return
     * @throws TsrSdkException
     */
    @ApiMapping(url = "/refund/agree")
    public HttpResult<Boolean> refundAgree(RightsCheckOpenApiRequest request) throws TsrSdkException {
        return doRequest(request, Boolean.class);
    }


    /**
     * openapi拒绝退款申请
     *
     * @return
     * @throws TsrSdkException
     */
    @ApiMapping(url = "/refund/reject")
    public HttpResult<Boolean> refundReject(RightsRejectOpenApiRequest request) throws TsrSdkException {
        return doRequest(request, Boolean.class);
    }



    /**
     * openapi查看售后列表
     *
     * @return
     * @throws TsrSdkException
     */
    @ApiMapping(url = "/getRightsList")
    public HttpResult<RightsListOpenApiResponse> getRightsList(GetRightsListOpenApiRequest request) throws TsrSdkException {
        return doRequest(request, RightsListOpenApiResponse.class);
    }


    /**
     * openapi查看售后详情
     *
     * @return
     * @throws TsrSdkException
     */
    @ApiMapping(url = "/getRightsDetail")
    public HttpResult<RightsDetailOpenApiResponse> getRightsDetail(GetRightsDetailOpenApiRequest request) throws TsrSdkException {
        return doRequest(request, RightsDetailOpenApiResponse.class);
    }


    /**
     * openapi同意退货申请
     *
     * @return
     * @throws TsrSdkException
     */
    @ApiMapping(url = "/return/agree")
    public HttpResult<Boolean> returnAgree(RightsReturnOpenApiRequest request) throws TsrSdkException {
        return doRequest(request, Boolean.class);
    }

    /**
     * openapi拒绝退货申请
     *
     * @return
     * @throws TsrSdkException
     */
    @ApiMapping(url = "/return/reject")
    public HttpResult<Boolean> returnReject(RightsRejectOpenApiRequest request) throws TsrSdkException {
        return doRequest(request, Boolean.class);
    }

    /**
     * openapi确认收货并退款
     *
     * @return
     * @throws TsrSdkException
     */
    @ApiMapping(url = "/confirmReceiptRefund")
    public HttpResult<Boolean> confirmReceiptRefund(RightsCheckOpenApiRequest request) throws TsrSdkException {
        return doRequest(request, Boolean.class);
    }

    /**
     * openapi拒绝取消订单退款申请
     *
     * @return
     * @throws TsrSdkException
     */
    @ApiMapping(url = "/cancel/reject")
    public HttpResult<Boolean> cancelReject(RightsRejectOpenApiRequest request) throws TsrSdkException {
        return doRequest(request, Boolean.class);
    }

    /**
     * openapi同意取消订单退款申请
     *
     * @return
     * @throws TsrSdkException
     */
    @ApiMapping(url = "/cancel/agree")
    public HttpResult<Boolean> cancelAgree(RightsCheckOpenApiRequest request) throws TsrSdkException {
        return doRequest(request, Boolean.class);
    }






}
