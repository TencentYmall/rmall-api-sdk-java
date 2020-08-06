package com.tencent.sr.rmall.openapi.business.order.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 开放平台发票信息
 * @author Z_RT
 */
@Data
@ApiModel(description = "开放平台发票信息")
public class OpenApiInvoiceInfoVO {
    @ApiModelProperty("发票类型,0：不开票 5：区块链电子发票")
    private Integer invoiceType;
    @ApiModelProperty("'抬头类型，1：个人 2：企业'")
    private Integer titleType;
    @ApiModelProperty("纳税识别编号")
    private String buyerTaxNo;
    @ApiModelProperty(value = "发票内容", required = false)
    private String content;

}
