package com.dijiang.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "PageVo",description = "数据分页实体")
public class PageVo implements Serializable {

    @ApiModelProperty(name = "pageSize",value = "每页数据条数")
    private Integer pageSize ;

    @ApiModelProperty(name = "page",value = "当前页数")
    private Integer page;
}
