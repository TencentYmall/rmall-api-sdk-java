package com.tencent.sr.rmall.openapi.demo.order;

import com.google.gson.Gson;
import com.tencent.sr.rmall.openapi.business.TsrClient;
import com.tencent.sr.rmall.openapi.business.order.TsrOrderClient;
import com.tencent.sr.rmall.openapi.business.order.request.OpenApiSearchOrderListRequest;
import com.tencent.sr.rmall.openapi.business.order.response.OpenApiHistoryOrderListResponse;
import com.tencent.sr.rmall.openapi.business.order.response.OpenApiOrderListResponse;
import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.http.HttpResult;
import com.tencent.sr.rmall.openapi.secure.Credential;

public class OrderDetailList {

    public static void main(String[] args) throws TsrSdkException {
        initSecret();
        //订单sdk客户端  可以对客户端再做个性化处理
        //例如 设置超时时间, 个性化密钥
        TsrOrderClient orderClient = new TsrOrderClient();
        //联调环境需要加上这个,路由到泳道
        orderClient.addHeader("tversion","trade");

        //查询全量
        OpenApiSearchOrderListRequest request =  getOrderAll();

        HttpResult<OpenApiOrderListResponse> openApiHistoryOrderListResponse = orderClient.searchOrderList(request);
        System.out.println(new Gson().toJson(openApiHistoryOrderListResponse));
        System.out.println(openApiHistoryOrderListResponse.getRequestId());
    }

    private static OpenApiSearchOrderListRequest getOrderAll() {
        OpenApiSearchOrderListRequest request = new OpenApiSearchOrderListRequest();
        OpenApiSearchOrderListRequest.Parameter parameter = new OpenApiSearchOrderListRequest.Parameter();
        parameter.setCreateTimeInterval(new Long[]{1591943220000L,1591943220001L});
        parameter.setPageNum(1);
        parameter.setPageSize(10);
        request.setSaasId(70000001);
        request.setUid("700000011054154");


        request.setParameter(parameter);
        return request;
    }


    private static void initSecret() throws TsrSdkException {
        //全局初始化密钥  如果应用密钥唯一 初始化一次即可
        //q享qa环境密钥demo
        String secretId = "AKIDNxcOd6uuqlce25ajKLlb73k0582nfWPlSok5";
        String secretKey = "E80EWIYrJogWkjK6az0bKGk1YXS1x4hNulMrt3rn";
        Credential credential = new Credential(secretId, secretKey);
        TsrClient.init(credential);
    }
}