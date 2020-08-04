package com.tencent.sr.rmall.openapi.business.right.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class RightsOpenApiVO {

    @ApiModelProperty(
            value = "用户id",
            required = true
    )
    private String uid;
    @ApiModelProperty(
            value = "用户名称",
            required = true
    )
    private String userName;
    @ApiModelProperty(
            value = "售后类型,10:退货退款 20:仅退款",
            required = true
    )
    private Integer rightsType;

    @ApiModelProperty(
            value = "售后单号",
            required = true
    )
    private String rightsNo;
    @ApiModelProperty(
            value = "订单号",
            required = true
    )
    private String orderNo;
    @ApiModelProperty(
            value = "退款申请金额",
            required = true
    )
    private Long refundRequestAmount;

    @ApiModelProperty(
            value = "售后原因描述",
            required = true
    )
    private String rightsReasonDesc;

    @ApiModelProperty(value = "售后凭证url", required = true)
    private List<String> rightsImageUrls;

    @ApiModelProperty("售后状态 10:待审核,20:已审核,30:已收货,40:收货异常,50:已完成,60:已关闭")
    private Integer rightsStatus;
    @ApiModelProperty("售后状态名称")
    private String rightsStatusName;

    @ApiModelProperty("创建时间")
    private Long createTime;
    @ApiModelProperty("修改时间")
    private Long updateTime;
}
