package com.tencent.sr.rmall.openapi.demo.right;

import com.tencent.sr.rmall.openapi.business.right.TsrRightClient;
import com.tencent.sr.rmall.openapi.business.right.request.RightsCheckOpenApiRequest;
import com.tencent.sr.rmall.openapi.demo.InitUtil;
import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.http.HttpResult;

/**
 *openapi同意未发货退款单退款申请demo
 */
public class RightCancelAgreeDemo {


    public static void main(String[] args) throws TsrSdkException {
        InitUtil.initSecret();
        //订单sdk客户端  可以对客户端再做个性化处理
        //例如 设置超时时间, 个性化密钥
        TsrRightClient orderClient = new TsrRightClient();
        //联调环境需要加上这个,路由到泳道
        //orderClient.addHeader("tversion", "rights-refund");

        //查询全量
        RightsCheckOpenApiRequest request = getRightReturnOpenApiRequest();

        HttpResult<Boolean> responseHttpResult = orderClient.cancelAgree(request);
        System.out.println(responseHttpResult);
    }

    private static RightsCheckOpenApiRequest getRightReturnOpenApiRequest() {
        RightsCheckOpenApiRequest request = new RightsCheckOpenApiRequest();
        request.setSaasId(70000001L);
        request.setRightsNo("288525710503579265");
//        request.setStoreId(70000001L);
        return request;

    }
}
