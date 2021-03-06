package com.tencent.sr.rmall.openapi.demo.right;

import com.tencent.sr.rmall.openapi.business.right.TsrRightClient;
import com.tencent.sr.rmall.openapi.business.right.request.RightsReturnOpenApiRequest;
import com.tencent.sr.rmall.openapi.demo.InitUtil;
import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.http.HttpResult;

/**
 * openapi同意退货申请demo
 */
public class ReturnAgreeDemo {
    public static void main(String[] args) throws TsrSdkException {

        InitUtil.initSecret();
        //订单sdk客户端  可以对客户端再做个性化处理
        //例如 设置超时时间, 个性化密钥
        TsrRightClient orderClient = new TsrRightClient();
        //联调环境需要加上这个,路由到泳道
        //orderClient.addHeader("tversion", "rights-refund");

        //查询全量
        RightsReturnOpenApiRequest request = getRightReturnOpenApiRequest();

        HttpResult<Boolean> responseHttpResult = orderClient.returnAgree(request);
        System.out.println(responseHttpResult);
        System.out.println(responseHttpResult.getRequestId());

    }

    private static RightsReturnOpenApiRequest getRightReturnOpenApiRequest() {
        RightsReturnOpenApiRequest request = new RightsReturnOpenApiRequest();
        request.setRightsNo("288527782137434241");
        request.setSaasId(70000001L);
        request.setReceiverAddress("广东深圳");
        request.setReceiverCity("深圳");
        request.setReceiverArea("南山区");
        request.setReceiverCounty("中关村");
        request.setReceiverPhone("13603086566");
        request.setReceiverProvince("广东省");
        request.setReceiverName("收货人名称");
        return request;

    }
}
