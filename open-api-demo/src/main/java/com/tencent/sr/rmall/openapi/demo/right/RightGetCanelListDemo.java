package com.tencent.sr.rmall.openapi.demo.right;

/**
 * 描述用途 : openapi查询未发货退款单列表
 *
 * @author chenmx
 * @date 2020/7/17
 */

import com.tencent.sr.rmall.openapi.business.right.TsrRightClient;
import com.tencent.sr.rmall.openapi.business.right.request.GetcancelListOpenApiRequest;
import com.tencent.sr.rmall.openapi.business.right.request.PaginationRequest;
import com.tencent.sr.rmall.openapi.business.right.response.RightsListOpenApiResponse;
import com.tencent.sr.rmall.openapi.demo.InitUtil;
import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.http.HttpResult;

/**
 * @author effortjiang
 * @date 2020-07-14
 */

public class RightGetCanelListDemo {

    static int count = 0;
    public static void main(String[] args) throws TsrSdkException {

        //测试环境传qa标识,不传默认为online
        InitUtil.initSecret("qa");
        //订单sdk客户端  可以对客户端再做个性化处理
        //例如 设置超时时间, 个性化密钥
        TsrRightClient orderClient = new TsrRightClient();
        //组装业务请求参数
        GetcancelListOpenApiRequest request = getRightRequest();
        //发起调用
        HttpResult<RightsListOpenApiResponse> response = orderClient.getCancelList(request);
        System.out.println(response);

        System.out.println(response.getData().getRightsResponse().getDataList());
        //获取结果
        System.out.println("请求结果id=" + response.getRequestId());

    }


    private static GetcancelListOpenApiRequest getRightRequest() {
        GetcancelListOpenApiRequest request = new GetcancelListOpenApiRequest();
        request.setRightsType(20);
        //request.setRightsStatus(200);
        request.setStartTime(1592388637000L);
        request.setEndTime(1595490022866L);
        PaginationRequest paginationRequest = new PaginationRequest();
        paginationRequest.setPageNum(1);
        paginationRequest.setPageSize(10);
        request.setPage(paginationRequest);

        return request;
    }

}
