package com.tencent.sr.rmall.openapi.demo.right;

/**
 * 描述用途 ： 拒绝退货退款申请
 *
 * @author chenmx
 * @date 2020/7/17
 */

import com.tencent.sr.rmall.openapi.business.right.TsrRightClient;
import com.tencent.sr.rmall.openapi.business.right.request.RightsRejectOpenApiRequest;
import com.tencent.sr.rmall.openapi.demo.InitUtil;
import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.http.HttpResult;

/**
 * @author effortjiang
 * @date 2020-07-14
 */

public class ReturnRejectDemo {


    public static void main(String[] args) throws TsrSdkException {

        //测试环境传qa标识,不传默认为online
        InitUtil.initSecret("qa");
        //订单sdk客户端  可以对客户端再做个性化处理
        //例如 设置超时时间, 个性化密钥
        TsrRightClient orderClient = new TsrRightClient();
        //组装业务请求参数
        RightsRejectOpenApiRequest request = getRightRequest();
        //发起调用
        HttpResult<Boolean> response = orderClient.returnReject(request);
        System.out.println(response);
        //获取结果
        System.out.println("请求结果id=" + response.getRequestId());

    }


    private static RightsRejectOpenApiRequest getRightRequest() {
        RightsRejectOpenApiRequest request = new RightsRejectOpenApiRequest();
        request.setRightsNo("288527782137434241");
        request.setRejectReason("已发货");

        return request;
    }

}
