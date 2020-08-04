package com.tencent.sr.rmall.openapi.business.right.response;

import com.tencent.sr.rmall.openapi.business.right.domain.RightsOpenApiVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "openapi售后单详情基础信息")
public class BaseRightsOpenApiResponse implements Serializable {
    @ApiModelProperty(value = "商户id")
    private Long saasId;
    @ApiModelProperty(value = "用户id" )
    private String uid;
    @ApiModelProperty(value = "店铺id")
    private Long storeId;
    @ApiModelProperty(value = "Q享号主Id")
    private String qshareId;
    @ApiModelProperty(value = "Q享号主名称")
    private String qshareName;
    @ApiModelProperty(value = "Q享号主手机号")
    private String qsharePhone;

    @ApiModelProperty("退货申请单vo")
    private RightsOpenApiVO rights = new RightsOpenApiVO();

}
