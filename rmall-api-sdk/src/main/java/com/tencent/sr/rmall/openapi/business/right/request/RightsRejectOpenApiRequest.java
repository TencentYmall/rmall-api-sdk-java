package com.tencent.sr.rmall.openapi.business.right.request;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

@Data
@ApiOperation("拒绝售后/退款请求")
public class RightsRejectOpenApiRequest extends OpenApiRightsBaseRequest {
    @ApiModelProperty(value = "售后单号",required = true)
    private String rightsNo;
    @ApiModelProperty(value = "拒绝原因",required = true)
    private String rejectReason;
}