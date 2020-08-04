package com.tencent.sr.rmall.openapi.business.right.request;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

@Data
@ApiOperation("openapi获取审核单列表")
public class GetcancelListOpenApiRequest extends OpenApiBaseRequest {

    @ApiModelProperty("售后类型 20:仅退款")
    private Integer rightsType;

    @ApiModelProperty("售后状态 200:等待商家审核; 210:商家已审核，待发起退款;260:已发起退款;270:退款到账;280:退款失败;290:已关闭")
    private Integer rightsStatus;
}
