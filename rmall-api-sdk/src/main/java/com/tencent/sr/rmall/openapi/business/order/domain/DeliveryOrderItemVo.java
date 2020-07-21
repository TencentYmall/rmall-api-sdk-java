package com.tencent.sr.rmall.openapi.business.order.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeliveryOrderItemVo implements Serializable {

    private static final long serialVersionUID = -4539658783382933565L;

    /**
     * @description 订单项id
     * @default
     * @example
     */
    private Long itemId;

    /**
     * @description 商品规格id
     * @default
     * @example
     */
    private Long skuId;

    /**
     * @description 发货的数量
     * @default
     * @example
     */
    private Integer skuQuantity;
}
