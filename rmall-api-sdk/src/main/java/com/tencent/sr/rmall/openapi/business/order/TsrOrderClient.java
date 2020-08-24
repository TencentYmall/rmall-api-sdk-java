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
package com.tencent.sr.rmall.openapi.business.order;

import com.tencent.sr.rmall.openapi.base.BaseApiClient;
import com.tencent.sr.rmall.openapi.business.order.request.OpenApiFinishDeliveryRequest;
import com.tencent.sr.rmall.openapi.business.order.request.OpenApiSearchOrderListRequest;
import com.tencent.sr.rmall.openapi.business.order.request.TsrOrderRequest;
import com.tencent.sr.rmall.openapi.business.order.response.DeliveryResponse;
import com.tencent.sr.rmall.openapi.business.order.response.OpenApiHistoryOrderListResponse;
import com.tencent.sr.rmall.openapi.business.order.response.OpenApiOrderListResponse;
import com.tencent.sr.rmall.openapi.business.order.response.TsrOrderResponse;
import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.http.HttpResult;
import com.tencent.sr.rmall.openapi.http.annotation.ApiMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author effortjiang
 * @date 2020-07-15
 */
@ApiMapping(url = "/api/v1/openapi/order")
public class TsrOrderClient extends BaseApiClient {

    private static final Logger log = LoggerFactory.getLogger(TsrOrderClient.class);

    /**
     * 查询单个订单明细数据
     *
     * @param orderRequest
     * @return
     * @throws TsrSdkException
     */
    @ApiMapping(url = "/api/v1/openapi/order/getOrderDetail")
    public HttpResult<TsrOrderResponse> queryOrder(TsrOrderRequest orderRequest) throws TsrSdkException {
        return doRequest(orderRequest, TsrOrderResponse.class);
    }

    /**
     * 获取历史订单数据
     *
     * @param orderRequest
     * @return
     * @throws TsrSdkException
     */
    @ApiMapping(url = "/api/v1/openapi/order/searchOrderAll")
    public HttpResult<OpenApiHistoryOrderListResponse> searchOrderAll(OpenApiSearchOrderListRequest orderRequest) throws TsrSdkException {
        return doRequest(orderRequest, OpenApiHistoryOrderListResponse.class);
    }

    /**
     * 查询增量订单
     *
     * @param orderRequest
     * @return
     * @throws TsrSdkException
     */
    @ApiMapping(url = "/api/v1/openapi/order/searchOrderList")
    public HttpResult<OpenApiOrderListResponse> searchOrderList(OpenApiSearchOrderListRequest orderRequest) throws TsrSdkException {
        return doRequest(orderRequest, OpenApiOrderListResponse.class);
    }


    /**
     * 查询增量订单
     *
     * @param orderRequest
     * @return
     * @throws TsrSdkException
     */
    @ApiMapping(url = "/api/v2/openapi/order/searchOrderList")
    public HttpResult<OpenApiOrderListResponse> searchOrderV2List(OpenApiSearchOrderListRequest orderRequest) throws TsrSdkException {
        return doRequest(orderRequest, OpenApiOrderListResponse.class);
    }

    /**
     * 发货
     *
     * @param deliveryRequest
     * @return
     * @throws TsrSdkException
     */
    @ApiMapping(url = "/api/v1/openapi/order/finish/delivery")
    public HttpResult<Boolean> finishDelivery(OpenApiFinishDeliveryRequest deliveryRequest) throws TsrSdkException {
        return doRequest(deliveryRequest, Boolean.class);
    }


}
