package com.tencent.sr.rmall.openapi.business.order.domain;

import com.tencent.sr.rmall.openapi.business.order.domain.DeliveryOrderItemVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "开放平台物流信息")
public class OpenApiLogisticsInfoVO {
    @ApiModelProperty("配送单号")
    private String logisticsNo;
    @ApiModelProperty("配送公司编号")
    private String logisticsCompanyCode;
    @ApiModelProperty("配送公司名称")
    private String logisticsCompanyName;
    /**
     * 发货单明细（不拆包时可以不传）
     */
    @ApiModelProperty(value = "发货单明细(不拆包时可以不传)", required = false)
    private List<DeliveryOrderItemVo> deliveryOrderItemList;

}

