package com.tencent.sr.rmall.openapi.business.right.response;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiOperation("openapi售后单列表")
public class RightsListOpenApiResponse implements Serializable {

    private static final long serialVersionUID = -4120487819123519234L;

    @ApiModelProperty(value = "商户id")
    private Long saasId;
    @ApiModelProperty(value = "用户id" )
    private String uid;
    @ApiModelProperty(value = "店铺id")
    private Long storeId;

    @ApiModelProperty(notes = "售后单列表")
    private PaginationResponse<BaseRightsOpenApiResponse> rightsResponse;
}
