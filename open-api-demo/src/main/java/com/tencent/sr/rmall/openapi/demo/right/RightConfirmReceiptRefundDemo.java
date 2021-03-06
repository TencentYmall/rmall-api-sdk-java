package com.tencent.sr.rmall.openapi.demo.right;

/**
 * 描述用途 ： 　商家确认退款
 *
 * @author chenmx
 * @date 2020/7/17
 */

import com.tencent.sr.rmall.openapi.business.right.TsrRightClient;
import com.tencent.sr.rmall.openapi.business.right.request.RightsCheckOpenApiRequest;
import com.tencent.sr.rmall.openapi.demo.InitUtil;
import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.http.HttpResult;

/**
 * @author effortjiang
 * @date 2020-07-14
 */

public class RightConfirmReceiptRefundDemo {


    public static void main(String[] args) throws TsrSdkException {

        InitUtil.initSecret();
        //订单sdk客户端  可以对客户端再做个性化处理
        //例如 设置超时时间, 个性化密钥
        TsrRightClient orderClient = new TsrRightClient();
        //泳道请求头
        //orderClient.addHeader("tversion", "rights-refund");
        //组装业务请求参数
        RightsCheckOpenApiRequest request = getRightRequest();
        //发起调用
        HttpResult<Boolean> response = orderClient.confirmReceiptRefund(request);
        System.out.println(response);
        //获取结果
        System.out.println("请求结果id=" + response.getRequestId());

    }


    private static RightsCheckOpenApiRequest getRightRequest() {
        RightsCheckOpenApiRequest request = new RightsCheckOpenApiRequest();
        request.setRightsNo("288527782137434241");
        request.setSaasId(70000001L);
        //request.setStoreId(504L);

        return request;
    }

}
