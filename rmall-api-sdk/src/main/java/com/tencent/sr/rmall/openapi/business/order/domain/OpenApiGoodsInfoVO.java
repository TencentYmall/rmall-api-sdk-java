package com.tencent.sr.rmall.openapi.business.order.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 开放平台商品信息
 * @author T_ZL
 */
@Data
@ApiModel(description = "开放平台订单商品条目")
public class OpenApiGoodsInfoVO {

    @ApiModelProperty(value = "商品SKU", required = true)
    private Long skuId;
    @ApiModelProperty(value = "直播间ID", required = false)
    private Long roomId;
    @ApiModelProperty(value = "商品主类型", required = true)
    private Integer goodsMainType;
    @ApiModelProperty(value = "商品副类型", required = false)
    private Integer goodsViceType;
    @ApiModelProperty(value = "商品名称", required = true)
    private String goodsName;
    @ApiModelProperty(value = "商品图片", required = false)
    private String goodsPictureUrl;
    @ApiModelProperty(value = "规格名称列表", required = false)
    private List<OrderItemVO.Specification> specifications;
    @ApiModelProperty(value = "购买数量", required = true)
    private Integer buyQuantity;
    @ApiModelProperty(value = "实际价格，单位分", required = true)
    private Long actualPrice;
    @ApiModelProperty(value = "商品优惠总金额", required = true)
    private Long itemDiscountAmount;

    /**
     * 规格属性
     *
     * @author T_ZL
     */
    @Data
    @ApiModel(description = "商品规格")
    public static class Specification {
        /**
         * 规格名称
         */
        @ApiModelProperty("规格名称")
        private String specTitle;

        /**
         * 规格值
         */
        @ApiModelProperty("规格值")
        private String specValue;
    }
}

