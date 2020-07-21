package com.tencent.sr.rmall.openapi.business.order.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 订单条目
 * @author T_ZL
 * @date 2020年2月27日
 */
@Data
@ApiModel(description = "订单商品条目")
public class OrderItemVO {

    /**
     * 订单条目ID
     */
    @ApiModelProperty(value = "订单条目ID", required = false)
    private Long id;
    /**
     * 订单号
     */
    @ApiModelProperty(value = "订单号", required = true)
    private String orderNo;
    /**
     * 商品SPU
     */
    @ApiModelProperty(value = "商品SPU", required = true)
    private Long spuId;
    /**
     * 商品SKU
     */
    @ApiModelProperty(value = "商品SKU", required = true)
    private Long skuId;
    /**
     * 直播间ID
     */
    @ApiModelProperty(value = "直播间ID", required = false)
    private Long roomId;
    /**
     * 商品主类型
     */
    @ApiModelProperty(value = "商品主类型", required = true)
    private Integer goodsMainType;
    /**
     * 商品副类型
     */
    @ApiModelProperty(value = "商品副类型", required = false)
    private Integer goodsViceType;
    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称", required = true)
    private String goodsName;
    /**
     * 商品图片
     */
    @ApiModelProperty(value = "商品图片", required = false)
    private String goodsPictureUrl;
    /**
     * 商品原价，单位分
     */
    @ApiModelProperty(value = "商品原价，单位分", required = true)
    private Long originPrice;
    /**
     * 实际价格，单位分
     */
    @ApiModelProperty(value = "实际价格，单位分", required = true)
    private Long actualPrice;
    /**
     * 规格属性名称列表
     */
    @ApiModelProperty(value = "规格名称列表", required = false)
    private List<Specification> specifications;
    /**
     * 购买数量
     */
    @ApiModelProperty(value = "购买数量", required = true)
    private Integer buyQuantity;
    /**
     * 订单条目总金额，SKU数*单价
     */
    @ApiModelProperty(value = "订单条目总金额，SKU数*单价", required = true)
    private Long itemTotalAmount;
    /**
     * 订单条目优惠总金额
     */
    @ApiModelProperty(value = "订单条目优惠总金额", required = true)
    private Long itemDiscountAmount;
    /**
     * 订单条目实际支付金额
     */
    @ApiModelProperty(value = "订单条目实际支付金额", required = true)
    private Long itemPaymentAmount;
    /**
     * 实际付款单价
     */
    @ApiModelProperty(value = "实际付款单价", required = true)
    private Long goodsPaymentPrice;
    /**
     * 外部商品ID
     */
    @ApiModelProperty(value = "外部商品ID", required = false)
    private String outCode;
    /**
     * 渠道追踪
     */
    @ApiModelProperty(value = "渠道追踪", required = false)
    private List<LabelVO> labelVOs;
    /**
     * 按钮列表
     */
    @ApiModelProperty(value = "按钮列表", required = false)
    private List<ButtonVO> buttonVOs;

    /**
     * 规格属性
     *
     * @author T_ZL
     * @date 2020年3月20日
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

    @Data
    @ApiModel(description = "渠道追踪")
    public static class LabelVO {

        /**
         * 渠道追踪类型
         */
        @ApiModelProperty("渠道追踪类型")
        private String  labelType;

        /**
         * 追踪ID
         */
        @ApiModelProperty("追踪ID")
        private String  attachId;

        /**
         * 追踪数据
         */
        @ApiModelProperty("追踪数据")
        private  Object attachment;

    }

    @Data
    @ApiModel(description = "按钮")
    public static class ButtonVO {

        /**
         * 高亮
         */
        @ApiModelProperty("高亮")
        private Boolean primary;
        /**
         * 按钮类型
         */
        @ApiModelProperty("按钮类型")
        private Integer type;
        /**
         * 按钮名称
         */
        @ApiModelProperty("按钮名称")
        private String name;

    }



}
