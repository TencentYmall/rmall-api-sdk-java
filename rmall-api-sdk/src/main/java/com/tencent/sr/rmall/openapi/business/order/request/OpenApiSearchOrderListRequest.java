package com.tencent.sr.rmall.openapi.business.order.request;

import com.tencent.sr.rmall.openapi.base.BaseApiRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OpenApiSearchOrderListRequest extends BaseApiRequest {

    private Parameter parameter;
    private int saasId;
    private String uid;

    @Data
    public static class Parameter {
        /**
         * 当前页
         */
        @ApiModelProperty(value = "当前页", required = true)
        private Integer pageNum;
        /**
         * 每页大小
         */
        @ApiModelProperty(value = "每页大小", required = true)
        private Integer pageSize;

        /**
         * 订单类型
         */
        @ApiModelProperty("订单类型  普通订单:1")
        private Integer orderType;
        /**
         * 订单状态
         */
        @ApiModelProperty("订单状态")
        private Integer orderStatus;
        /**
         * 待查询门店列表
         */
        @ApiModelProperty("待查询门店")
        private Long storeId;
        /**
         * 时间区间
         * [beginTime, endTime]
         */
        @ApiModelProperty("时间区间:[beginTime, endTime]")
        private Long[] createTimeInterval;

        /**
         * 时间区间
         * [beginTime, endTime]
         */
        @ApiModelProperty("时间区间:[beginTime, endTime]")
        private Long[] operationTimeInterval;


    }


}
