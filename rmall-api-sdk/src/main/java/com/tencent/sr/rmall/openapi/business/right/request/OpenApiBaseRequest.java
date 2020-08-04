package com.tencent.sr.rmall.openapi.business.right.request;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

@Data
@ApiOperation("openapi列表请求基类")
public class OpenApiBaseRequest extends OpenApiRightsBaseRequest{
    @ApiModelProperty(value = "分页信息", required = false)
    private PaginationRequest page;
    @ApiModelProperty(value = "起始时间, 单位:毫秒", required = true)
    private Long startTime;
    @ApiModelProperty(value = "结束时间,单位:毫秒", required = true)
    private Long endTime;

}
