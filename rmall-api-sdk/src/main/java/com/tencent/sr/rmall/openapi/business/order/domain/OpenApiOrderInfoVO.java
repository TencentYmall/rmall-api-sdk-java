package com.tencent.sr.rmall.openapi.business.order.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 开放平台订单信息
 * @author Z_RT
 * @date 2020年4月29日
 */
@Data
@ApiModel(description = "开放平台订单信息")
public class OpenApiOrderInfoVO {
    @ApiModelProperty("店铺id")
    private Long storeId;
    @ApiModelProperty("订单号")
    private String orderNo;
    @ApiModelProperty("订单类型")
    private Integer orderType;
    @ApiModelProperty("店铺名称")
    private String storeName;
    @ApiModelProperty("渠道来源")
    private String channelSource;
    @ApiModelProperty("订单状态")
    private Integer orderStatus;
    @ApiModelProperty("订单状态名称")
    private String orderStatusName;
    @ApiModelProperty("订单备注")
    private String remark;
    @ApiModelProperty("商品总金额")
    private Long goodsAmount;
    @ApiModelProperty("运费")
    private Long freightFee;
    @ApiModelProperty("订单总金额")
    private Long totalAmount;
    @ApiModelProperty("总优惠金额")
    private Long discountAmount;
    @ApiModelProperty("下单时间")
    private Long createTime;
    @ApiModelProperty("支付时间")
    private Long payTime;
    @ApiModelProperty("最后更新时间")
    private Long updateTime;
    @ApiModelProperty("取消订单时间")
    private Long cancelTime;
    @ApiModelProperty("取消类型,用户、客服、商家")
    private Integer cancelType;
    @ApiModelProperty("取消的具体原因")
    private String cancelReason;

    @ApiModelProperty(value = "V享号Id", required = false)
    private String vshareId;

    @ApiModelProperty(value = "V享号名称", required = false)
    private String vshareName;

    @ApiModelProperty(value = "V享号手机号", required = false)
    private String vsharePhone;

//        "支付时间，最后更新时间，取消订单时间"

    @ApiModelProperty(value = "下单人q享号信息",required = false)
    private Long userVshareId;
    @ApiModelProperty(value = "下单人手机号信息",required = false)
    private String userPhone;

    @ApiModelProperty(value = "主播名称",required = false)
    private String anchorName;

    @ApiModelProperty(value = "主播手机号",required = false)
    private String anchorMobile;

    @ApiModelProperty(value = "直播间id",required = false)
    private String roomId;

    @ApiModelProperty(value = "直播间名称",required = false)
    private String roomName;

}
