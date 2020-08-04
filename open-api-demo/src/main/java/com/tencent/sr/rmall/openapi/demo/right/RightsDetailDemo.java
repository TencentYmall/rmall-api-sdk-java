package com.tencent.sr.rmall.openapi.demo.right;

import com.tencent.sr.rmall.openapi.business.right.TsrRightClient;
import com.tencent.sr.rmall.openapi.business.right.request.GetRightsDetailOpenApiRequest;
import com.tencent.sr.rmall.openapi.business.right.response.RightsDetailOpenApiResponse;
import com.tencent.sr.rmall.openapi.demo.InitUtil;
import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.http.HttpResult;

/**
 * openApi查看售后详情demo
 */
public class RightsDetailDemo {

    public static void main(String[] args) throws TsrSdkException {

        InitUtil.initSecret();
        //订单sdk客户端  可以对客户端再做个性化处理
        //例如 设置超时时间, 个性化密钥
        TsrRightClient orderClient = new TsrRightClient();
        //联调环境需要加上这个,路由到泳道
        //orderClient.addHeader("tversion","rights-refund");

        //查询全量
        GetRightsDetailOpenApiRequest request = getRightDetailOpenApiRequest();

        HttpResult<RightsDetailOpenApiResponse> responseHttpResult = orderClient.getRightsDetail(request);
        System.out.println(responseHttpResult);
        System.out.println(responseHttpResult.getData().getRights());
    }

    private static GetRightsDetailOpenApiRequest getRightDetailOpenApiRequest() {
        GetRightsDetailOpenApiRequest request = new GetRightsDetailOpenApiRequest();
        request.setRightsNo("278041434733543746");
        request.setSaasId(70000001L);
        //request.setStoreId(504L);

        return request;
    }


}
