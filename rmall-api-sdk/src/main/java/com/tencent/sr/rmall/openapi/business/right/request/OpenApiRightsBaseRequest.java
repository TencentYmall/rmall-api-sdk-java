package com.tencent.sr.rmall.openapi.business.right.request;

import com.tencent.sr.rmall.openapi.base.BaseApiRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 请求基类
 * @Author: Z_RT
 * @Date: 2020/7/20
 */
@Data
public class OpenApiRightsBaseRequest extends BaseApiRequest {
    @ApiModelProperty(value = "商户号", required = true)
    private Long saasId;
    @ApiModelProperty(value = "店铺id")
    private Long storeId;

}
