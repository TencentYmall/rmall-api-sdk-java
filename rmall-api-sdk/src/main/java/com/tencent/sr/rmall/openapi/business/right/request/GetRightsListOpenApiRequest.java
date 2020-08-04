package com.tencent.sr.rmall.openapi.business.right.request;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

@Data
@ApiOperation("openapi获取售后列表")
public class GetRightsListOpenApiRequest extends OpenApiBaseRequest {

    @ApiModelProperty("售后类型 10:退货退款,20:仅退款")
    private Integer rightsType;

    @ApiModelProperty("售后状态 200:等待商家审核; 210:商家已审核，待发起退款;220:等待买家寄回商品;230:等待商家收货;240:商家已收货，待发起退款;250:收货异常;260:已发起退款;270:退款到账;280:退款失败;290:已关闭")
    private Integer rightsStatus;

}
