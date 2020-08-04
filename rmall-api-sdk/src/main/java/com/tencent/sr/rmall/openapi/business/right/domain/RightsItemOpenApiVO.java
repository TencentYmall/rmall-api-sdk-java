package com.tencent.sr.rmall.openapi.business.right.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "openapi退款商品")
public class RightsItemOpenApiVO {

	@ApiModelProperty(value = "sku id")
	private Long skuId;
	@ApiModelProperty(value = "spu id")
	private Long spuId;

	@ApiModelProperty(value = "商品名称")
	private String goodsName;

	@ApiModelProperty(value = "售后数量")
	private Integer rightsQuantity;


}
