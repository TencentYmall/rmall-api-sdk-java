package com.tencent.sr.rmall.openapi.demo.order;

import com.tencent.sr.rmall.openapi.business.order.TsrOrderClient;
import com.tencent.sr.rmall.openapi.business.order.request.OpenApiSearchOrderListRequest;
import com.tencent.sr.rmall.openapi.business.order.response.OpenApiHistoryOrderListResponse;
import com.tencent.sr.rmall.openapi.demo.InitUtil;
import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.http.HttpResult;

public class OrderAllDemo {

    public static void main(String[] args) throws TsrSdkException {


        InitUtil.initSecret();
        //订单sdk客户端  可以对客户端再做个性化处理
        //例如 设置超时时间, 个性化密钥
        TsrOrderClient orderClient = new TsrOrderClient();
        //联调环境需要加上这个,路由到泳道
        orderClient.addHeader("tversion","trade");

        //查询全量
        OpenApiSearchOrderListRequest request1 = getOrderAll();

        HttpResult<OpenApiHistoryOrderListResponse> openApiHistoryOrderListResponse = orderClient.searchOrderAll(request1);
        System.out.println(openApiHistoryOrderListResponse);
        System.out.println(openApiHistoryOrderListResponse.getRequestId());
    }

    private static OpenApiSearchOrderListRequest getOrderAll() {
        OpenApiSearchOrderListRequest request = new OpenApiSearchOrderListRequest();
        OpenApiSearchOrderListRequest.Parameter parameter = new OpenApiSearchOrderListRequest.Parameter();
        parameter.setCreateTimeInterval(new Long[]{1594874712000L, 1594979147975L});
        parameter.setPageNum(1);
        parameter.setPageSize(10);
        request.setSaasId(70000001);
        request.setUid("700000011070026");


        request.setParameter(parameter);
        return request;
    }

}
