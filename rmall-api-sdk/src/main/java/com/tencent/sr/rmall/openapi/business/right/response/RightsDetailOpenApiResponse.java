package com.tencent.sr.rmall.openapi.business.right.response;


import com.tencent.sr.rmall.openapi.business.right.domain.LogisticsOpenApiVo;
import com.tencent.sr.rmall.openapi.business.right.domain.RefundOpenApiVO;
import com.tencent.sr.rmall.openapi.business.right.domain.RightsItemOpenApiVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(description = "openapi售后详情")
public class RightsDetailOpenApiResponse extends BaseRightsOpenApiResponse {


    @ApiModelProperty("物流信息(买家寄回退货包裹)")
    private LogisticsOpenApiVo logisticsVO = new LogisticsOpenApiVo();

    @ApiModelProperty("退货商品信息")
    private List<RightsItemOpenApiVO> rightsItem = new ArrayList<>();

    @ApiModelProperty("退款信息")
    private RefundOpenApiVO rightsRefund = new RefundOpenApiVO();


}


