package com.tencent.sr.rmall.openapi.business.right.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 支付信息
 *
 * @author T_ZL
 * @date 2020年2月27日
 */
@Data
@ApiModel(description = "openapi退款信息")
public class RefundOpenApiVO {

    @ApiModelProperty(
            value = "退款状态",
            required = true
    )
    private int refundStatus;


    @ApiModelProperty(
            value = "退款状态名称",
            required = true
    )
    private String refundStatusName;

    @ApiModelProperty(
            value = "交易流水号",
            required = true
    )

    private String traceNo;

}
