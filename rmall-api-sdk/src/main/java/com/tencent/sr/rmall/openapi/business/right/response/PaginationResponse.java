package com.tencent.sr.rmall.openapi.business.right.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PaginationResponse<T> implements Serializable {
    private static final long serialVersionUID = -8266377191573464318L;
    @ApiModelProperty(
            notes = "当前页，起始值为1"
    )
    private Integer pageNum;
    @ApiModelProperty(
            notes = "分页大小"
    )
    private Integer pageSize;
    @ApiModelProperty(
            notes = "总数"
    )
    private Integer totalCount;
    @ApiModelProperty(
            notes = "数据列表"
    )
    private List<T> dataList;


}