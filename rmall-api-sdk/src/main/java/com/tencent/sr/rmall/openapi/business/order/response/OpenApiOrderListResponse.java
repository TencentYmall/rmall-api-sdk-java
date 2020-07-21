package com.tencent.sr.rmall.openapi.business.order.response;

import com.tencent.sr.rmall.openapi.base.BaseApiResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "开放平台增量订单信息")
public class OpenApiOrderListResponse extends BaseApiResponse {


        /**
         * 序列号
         */
        private static final long serialVersionUID = -4120487819123519234L;

        /**
         * 当前页，起始值为1
         */
        @ApiModelProperty(notes = "当前页，起始值为1")
        private Integer pageNum;
        /**
         * 分页大小
         */
        @ApiModelProperty(notes = "分页大小")
        private Integer pageSize;
        /**
         * 总数
         */
        @ApiModelProperty(notes = "总数")
        private Integer totalCount;
        /**
         * 订单列表
         */
        @ApiModelProperty(notes = "订单列表")
        private List<OpenApiOrderDetailResponse> orders;


}
