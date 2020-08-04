package com.tencent.sr.rmall.openapi.business.right.request;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.util.HashSet;

@Data
@ApiOperation("获取售后单详情")
public class GetRightsDetailOpenApiRequest extends OpenApiRightsBaseRequest {
    @ApiModelProperty(value = "售后单号",required = true)
    private String rightsNo;

    @ApiModelProperty(value = "返回字段内容,为空默认返回所有  rights:售后单信息;refund:退款单信息;rightsItems:售后商品信息;logistics:退货物流信息", required = false)
    private HashSet<String> backFieldSet;

}
