package com.tencent.sr.rmall.openapi.business.right.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class PaginationRequest<T> implements Serializable {
    private static final long serialVersionUID = -8217997127513052254L;
    @ApiModelProperty(
            notes = "当前页，从1开始",
            required = true
    )
    private Integer pageNum;
    @ApiModelProperty(
            notes = "分页大小",
            required = true
    )
    private Integer pageSize;
    @ApiModelProperty(
            notes = "查询条件"
    )
    private T queryCriteria;

}