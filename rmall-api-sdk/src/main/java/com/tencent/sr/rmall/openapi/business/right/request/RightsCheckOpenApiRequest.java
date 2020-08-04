package com.tencent.sr.rmall.openapi.business.right.request;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

@Data
@ApiOperation("同意退款请求")
public class RightsCheckOpenApiRequest extends OpenApiRightsBaseRequest {
    @ApiModelProperty(value = "售后单号",required = true)
    private String rightsNo;

}
