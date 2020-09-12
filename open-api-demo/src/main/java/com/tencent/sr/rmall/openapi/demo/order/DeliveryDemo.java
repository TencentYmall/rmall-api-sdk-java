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
        //测试环境传qa标识,不传默认为online
        InitUtil.initSecret("qa");
        //订单sdk客户端  可以对客户端再做个性化处理
        //例如 设置超时时间, 个性化密钥
        TsrOrderClient orderClient = new TsrOrderClient();
        //可根据需要设置客户端超时时间,默认连接3秒
        orderClient.setConnectionTimeout(3000);
        orderClient.setReadTimeout(3000);
        // 发货
        finishDeliveryDemo(orderClient);
    }

    public static void finishDeliveryDemo(TsrOrderClient orderClient) throws TsrSdkException {
        //构建调用参数
        OpenApiFinishDeliveryRequest deliveryRequest = new OpenApiFinishDeliveryRequest();
        OpenApiFinishDeliveryRequest.DeliveryParameter parameter = new OpenApiFinishDeliveryRequest.DeliveryParameter();
        deliveryRequest.setParameter(parameter);
        parameter.setIsBreak(false);
        parameter.setOrderNo("264115470218702393");
        OpenApiLogisticsInfoVO logisticsInfoVO = new OpenApiLogisticsInfoVO();
        parameter.setLogisticsInfos(Arrays.asList(logisticsInfoVO));
        logisticsInfoVO.setLogisticsCompanyCode("zhongtong");
        logisticsInfoVO.setLogisticsCompanyName("中通快递");
        logisticsInfoVO.setLogisticsNo("1111111");

        //发起远程调用
        HttpResult<Boolean> response = orderClient.finishDelivery(deliveryRequest);
        System.out.println("finishDeliveryDemo response: " + response);
    }
}
