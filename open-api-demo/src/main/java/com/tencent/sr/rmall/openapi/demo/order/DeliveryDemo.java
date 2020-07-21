package com.tencent.sr.rmall.openapi.demo.order;

import com.tencent.sr.rmall.openapi.business.order.TsrOrderClient;
import com.tencent.sr.rmall.openapi.business.order.domain.OpenApiLogisticsInfoVO;
import com.tencent.sr.rmall.openapi.business.order.request.OpenApiFinishDeliveryRequest;
import com.tencent.sr.rmall.openapi.demo.InitUtil;
import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.http.HttpResult;

import java.util.Arrays;

/**
 * @author effortjiang
 * @date 2020-07-14
 */

public class DeliveryDemo {


    public static void main(String[] args) throws TsrSdkException {

        InitUtil.initSecret();
        //订单sdk客户端  可以对客户端再做个性化处理
        //例如 设置超时时间, 个性化密钥
        TsrOrderClient orderClient = new TsrOrderClient();
        //联调环境需要加上这个,路由到泳道
        orderClient.addHeader("tversion","trade");


        // 发货
        finishDeliveryDemo(orderClient);
    }

    public static void finishDeliveryDemo(TsrOrderClient orderClient) throws TsrSdkException {
        OpenApiFinishDeliveryRequest deliveryRequest = new OpenApiFinishDeliveryRequest();
        OpenApiFinishDeliveryRequest.DeliveryParameter parameter = new OpenApiFinishDeliveryRequest.DeliveryParameter();
        deliveryRequest.setParameter(parameter);
        deliveryRequest.setSaasId(70000001);
        parameter.setIsBreak(false);
        parameter.setOrderNo("264115470218702393");
        OpenApiLogisticsInfoVO logisticsInfoVO = new OpenApiLogisticsInfoVO();
        parameter.setLogisticsInfos(Arrays.asList(logisticsInfoVO));
        logisticsInfoVO.setLogisticsCompanyCode("zhongtong");
        logisticsInfoVO.setLogisticsCompanyName("中通快递");

        HttpResult<Boolean> response = orderClient.finishDelivery(deliveryRequest);

        System.out.println("finishDeliveryDemo response: " + response);
    }
}
