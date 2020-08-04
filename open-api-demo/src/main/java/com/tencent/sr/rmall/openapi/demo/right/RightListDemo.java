package com.tencent.sr.rmall.openapi.demo.right;

import com.tencent.sr.rmall.openapi.business.right.TsrRightClient;
import com.tencent.sr.rmall.openapi.business.right.request.GetRightsListOpenApiRequest;
import com.tencent.sr.rmall.openapi.business.right.request.PaginationRequest;
import com.tencent.sr.rmall.openapi.business.right.response.RightsListOpenApiResponse;
import com.tencent.sr.rmall.openapi.demo.InitUtil;
import com.tencent.sr.rmall.openapi.exception.TsrSdkException;
import com.tencent.sr.rmall.openapi.http.HttpResult;

/**
 * openapi查询售后单列表demo
 */
public class RightListDemo {

    public static void main(String[] args) throws TsrSdkException {

        InitUtil.initSecret();
        //订单sdk客户端  可以对客户端再做个性化处理
        //例如 设置超时时间, 个性化密钥
        TsrRightClient orderClient = new TsrRightClient();
        //联调环境需要加上这个,路由到泳道
        //orderClient.addHeader("tversion","rights-refund");

        //查询全量
        GetRightsListOpenApiRequest request = getRightListOpenApiRequest();

        HttpResult<RightsListOpenApiResponse> responseHttpResult = orderClient.getRightsList(request);
        System.out.println(responseHttpResult);
        System.out.println(responseHttpResult.getRequestId());

    }

    /**
     *
     * @return
     */
    private static GetRightsListOpenApiRequest getRightListOpenApiRequest() {
        GetRightsListOpenApiRequest request = new GetRightsListOpenApiRequest();
        request.setSaasId(70000001L);
        //request.setStoreId(708L);
        request.setRightsType(10);
        request.setStartTime(1595503434000L);
        request.setEndTime(1595589834000L);
        PaginationRequest page = new PaginationRequest();
        page.setPageNum(1);
        page.setPageSize(10);
        page.setQueryCriteria(null);
        request.setPage(page);
        return request;
    }


}
