package com.tencent.sr.rmall.openapi.business.right.request;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

@Data
@ApiOperation("同意售后退货请求")
public class RightsReturnOpenApiRequest extends OpenApiRightsBaseRequest {
    @ApiModelProperty(value = "售后单号",required = true)
    private String rightsNo;
    @ApiModelProperty(
            value = "收货人所在省份"
    )
    private String receiverProvince;
    @ApiModelProperty(
            value = "收货人所在城市"
    )
    private String receiverCity;
    @ApiModelProperty(
            value = "收货人所在区/县"
    )
    private String receiverCounty;
    @ApiModelProperty(
            value = "收货人所在乡镇/街道"
    )
    private String receiverArea;
    @ApiModelProperty(
            value = "收货人详细地址"
    )
    private String receiverAddress;
    @ApiModelProperty(
            value = "收货人名称"
    )
    private String receiverName;
    @ApiModelProperty(
            value = "收货人电话"
    )
    private String receiverPhone;
}
