package com.tencent.sr.rmall.openapi.business.order.response;

import com.tencent.sr.rmall.openapi.base.BaseApiResponse;
import com.tencent.sr.rmall.openapi.business.order.domain.OpenApiAddressVO;
import com.tencent.sr.rmall.openapi.business.order.domain.OpenApiGoodsInfoVO;
import com.tencent.sr.rmall.openapi.business.order.domain.OpenApiOrderInfoVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 开放平台历史订单返回对象
 *
 * @author Z_RT
 * @date 2020年4月29日
 */
@Data
@ApiModel(description = "开放平台历史订单信息")
public class OpenApiHistoryOrderListResponse extends BaseApiResponse implements Serializable {

    /**
     * 序列号
     */
    private static final long serialVersionUID = -4120487819123519234L;

    /**
     * 当前页，起始值为1
     */
    @ApiModelProperty(notes = "当前页，起始值为1")
    private Integer pageNum;
    /**
     * 分页大小
     */
    @ApiModelProperty(notes = "分页大小")
    private Integer pageSize;
    /**
     * 总数
     */
    @ApiModelProperty(notes = "总数")
    private Integer totalCount;
    /**
     * 订单列表
     */
    @ApiModelProperty(notes = "订单列表")
    private List<OpenApiHistoryOrderDetailResponse> orders;

    /**
     * 开放平台历史订单详情
     *
     * @author Z_RT
     * @date 2020年3月5日
     */
    @Data
    @ApiModel(description = "开放平台历史订单详情基础信息")
    public static class OpenApiHistoryOrderDetailResponse implements Serializable {

        /**
         * 序列号
         */
        private static final long serialVersionUID = -6681441276975295088L;

        @ApiModelProperty("订单信息")
        private OpenApiOrderInfoVO orderInfo;

        @ApiModelProperty("商品信息")
        private List<OpenApiGoodsInfoVO> goodsInfos;

        @ApiModelProperty("收货地址")
        private OpenApiAddressVO addressInfo;




    }

}

