package com.tencent.sr.rmall.openapi.demo.right;

/**
 * 描述用途 ：获取未发货退款单详情
 *
 * @author chenmx
 * @date 2020/7/17
 */

import com.tencent.sr.rmall.openapi.business.right.TsrRightClient;
import com.tencent.sr.rmall.openapi.business.right.request.GetRightsDetailOpenApiRequest;
import com.tencent.sr.rmall.openapi.business.right.response.RightsDetailOpenApiResponse;
import com.tencent.sr.rmall.openapi.demo.InitUtil;
import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.http.HttpResult;

/**
 * @author
 * @date 2020-07-14
 */

public class RightGetCancelDetailDemo {


    public static void main(String[] args) throws TsrSdkException {

        InitUtil.initSecret();
        //订单sdk客户端  可以对客户端再做个性化处理
        //例如 设置超时时间, 个性化密钥
        TsrRightClient orderClient = new TsrRightClient();
        //泳道请求头
        //orderClient.addHeader("tversion", "rights-refund");
        //组装业务请求参数
        GetRightsDetailOpenApiRequest rightsDetailOpenApiRequest = getRightsDetailOpenApiRequest();

        //发起调用
        HttpResult<RightsDetailOpenApiResponse> response = orderClient.getCancelDetail(rightsDetailOpenApiRequest);
        System.out.println(response);
        System.out.println(response.getData().getRights());
        //获取结果
        System.out.println("请求结果id=" + response.getRequestId());

    }

    private static GetRightsDetailOpenApiRequest getRightsDetailOpenApiRequest() {
        GetRightsDetailOpenApiRequest request = new GetRightsDetailOpenApiRequest();
        request.setSaasId(70000001L);
        request.setRightsNo("288525710503579265");

        return request;
    }

}
