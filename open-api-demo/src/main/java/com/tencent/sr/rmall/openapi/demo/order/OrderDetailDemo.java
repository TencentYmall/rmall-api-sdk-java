package com.tencent.sr.rmall.openapi.demo.order;

/**
 * 描述用途
 *
 * @author chenmx
 * @date 2020/7/17
 */

import com.google.gson.JsonObject;
import com.tencent.sr.rmall.openapi.business.order.TsrOrderClient;
import com.tencent.sr.rmall.openapi.business.order.request.TsrOrderRequest;
import com.tencent.sr.rmall.openapi.business.order.response.TsrOrderResponse;
import com.tencent.sr.rmall.openapi.demo.InitUtil;
import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.http.HttpResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @author effortjiang
 * @date 2020-07-14
 */

public class OrderDetailDemo {


    public static void main(String[] args) throws TsrSdkException {

        //测试环境传qa标识,不传默认为online
        InitUtil.initSecret("qa");
        //订单sdk客户端  可以对客户端再做个性化处理
        //例如 设置超时时间, 个性化密钥
        TsrOrderClient orderClient = new TsrOrderClient();
        //组装业务请求参数
        TsrOrderRequest request = getTsrOrderRequest();
        //发起调用
        HttpResult<TsrOrderResponse> tsrOrderResponse = orderClient.queryOrder(request);
        System.out.println(tsrOrderResponse.getData());
        //获取结果
        System.out.println("请求结果id=" + tsrOrderResponse.getRequestId());

    }


    private static TsrOrderRequest getTsrOrderRequest() {
        TsrOrderRequest request = new TsrOrderRequest();
        TsrOrderRequest.ParameterBean parameterBean = new TsrOrderRequest.ParameterBean();
        parameterBean.setOrderNo("298670031782161203");
        request.setParameter(parameterBean);
        return request;
    }

}
