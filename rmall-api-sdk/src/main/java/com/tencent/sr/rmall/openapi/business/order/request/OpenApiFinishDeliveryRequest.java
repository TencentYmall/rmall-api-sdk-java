package com.tencent.sr.rmall.openapi.business.order.request;

import com.tencent.sr.rmall.openapi.base.BaseApiRequest;
import com.tencent.sr.rmall.openapi.business.order.domain.OpenApiLogisticsInfoVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OpenApiFinishDeliveryRequest extends BaseApiRequest implements Serializable {

    private static final long serialVersionUID = 4979860788203678571L;

    private DeliveryParameter parameter;
    private int saasId;

    @Data
    public static class DeliveryParameter{

        /**
         * 订单号
         */
        @ApiModelProperty(value = "订单号", required = true)
        private String orderNo;
        /**
         * 是否分包裹发货
         */
        @ApiModelProperty(value = "是否分包裹发货", required = true)
        private Boolean isBreak;

        /**
         * 运单明细列表
         */
        @ApiModelProperty(value = "运单明细列表", required = true)
        private List<OpenApiLogisticsInfoVO> logisticsInfos;

    }

}

