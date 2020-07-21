package com.tencent.sr.rmall.openapi.business.order.response;

import com.tencent.sr.rmall.openapi.business.order.domain.OpenApiInvoiceInfoVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "开放平台增量订单详情")
public class OpenApiOrderDetailResponse extends OpenApiHistoryOrderListResponse.OpenApiHistoryOrderDetailResponse {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("发票信息")
    private OpenApiInvoiceInfoVO invoiceInfo;

}