package com.tencent.sr.rmall.openapi.business.order.response;

import com.tencent.sr.rmall.openapi.base.BaseApiResponse;
import com.tencent.sr.rmall.openapi.business.order.domain.OpenApiAddressVO;
import com.tencent.sr.rmall.openapi.business.order.domain.OpenApiDiscountInfoVO;
import com.tencent.sr.rmall.openapi.business.order.domain.OpenApiGoodsInfoVO;
import com.tencent.sr.rmall.openapi.business.order.domain.OpenApiOrderInfoVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author effortjiang
 * @date 2020-07-15
 */
@Data
public class TsrOrderResponse extends BaseApiResponse {


    /**
     * orderInfo : {"storeId":"492","orderNo":"212956032099562065","orderType":0,"storeName":"18312560329的Q店","channelSource":"","orderStatus":80,"orderStatusName":"已取消","remark":"","goodsAmount":"1","freightFee":"0","totalAmount":"1","discountAmount":"0","createTime":"1591942658177","cancelTime":"1591945177816","cancelType":2,"cancelReason":"商家无法发货"}
     * goodsInfos : [{"skuId":"1216095","goodsMainType":0,"goodsViceType":0,"goodsName":"快乐的小商品","goodsPictureUrl":"https://qshare-material-qa-1300977798.file.myqcloud.com/persist/70000001/492/700000011054004/material/1/c49e4c92866445fba41a71dd6c3fad41-1591844947955-EPm3XBnNpr.png","specifications":[{"specTitle":"口味","specValue":"原味"}],"buyQuantity":1,"actualPrice":"1","itemDiscountAmount":"0"}]
     * addressInfo : {"receiverProvince":"广东省","receiverCity":"深圳市","receiverCounty":"南山区","receiverArea":"","receiverAddress":"深圳腾讯滨海大厦","receiverPhone":"18702786310","receiverName":"黄女士（示例）"}
     * userInfo : {"userName":"clausetest","phone":""}
     * logisticsInfos : [{"logisticsNo":"","logisticsCompanyCode":"","logisticsCompanyName":""}]
     * paymentInfos : []
     */

    private OpenApiOrderInfoVO orderInfo;
    private OpenApiAddressVO addressInfo;
    private UserInfoBean userInfo;
    private List<OpenApiGoodsInfoVO> goodsInfos;
    private List<LogisticsInfosBean> logisticsInfos;
    private List<OpenApiPaymentInfoVO> paymentInfos;
    private List<OpenApiDiscountInfoVO> discountInfoVOs;


    @Data
    @ApiModel(description = "开放平台支付信息")
    public class OpenApiPaymentInfoVO {
        @ApiModelProperty("交易流水号")
        private String traceNo;
        @ApiModelProperty("支付期数")
        private Integer period;
        @ApiModelProperty("支付时间")
        private Date payTime;
        @ApiModelProperty("金额")
        private Long amount;
        @ApiModelProperty("支付方式")
        private Integer payWay;

    }







    @Data
    public static class UserInfoBean {
        /**
         * userName : clausetest
         * phone :
         */

        private String userName;
        private String phone;

    }



    @Data
    public static class LogisticsInfosBean {
        /**
         * logisticsNo :
         * logisticsCompanyCode :
         * logisticsCompanyName :
         */

        private String logisticsNo;
        private String logisticsCompanyCode;
        private String logisticsCompanyName;

    }

}
