package com.tencent.sr.rmall.openapi.business.order.domain;

import lombok.Data;

import java.util.List;

@Data
public  class OpenApiDiscountInfoVO {
    private String code;

    private String type;

    private String typeName;
    private String name;

    /**
     * SKU详情列表
     */
    private List<SKUList> skus;


    @Data
    public static class SKUList {
        /**
         * SKUID
         */
        private Long skuId;

        /**
         * 商品名称
         */
        private String goodsName;

        /**
         * SKU级别优惠
         */
        private Long skuDiscountAmount;

        /**
         * SKU条码
         */
        private String skuBarCode;
        /**
         * 父skuID,如赠品的主商品
         */
        private Long parentSkuId;
        /**
         * 数量
         */
        private Integer quantity;
    }
}
