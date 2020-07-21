package com.tencent.sr.rmall.openapi.business.order.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "开放平台收获地址")
public class OpenApiAddressVO {
    @ApiModelProperty("收货人所在省份")
    private String receiverProvince;
    @ApiModelProperty("收货人所在城市")
    private String receiverCity;
    @ApiModelProperty("收货人所在区/县")
    private String receiverCounty;
    @ApiModelProperty("收货人所在乡镇/街道")
    private String receiverArea;
    @ApiModelProperty("收货人详细地址")
    private String receiverAddress;
    @ApiModelProperty("收货人电话")
    private String receiverPhone;
    @ApiModelProperty("收货人名称")
    private String receiverName;

}