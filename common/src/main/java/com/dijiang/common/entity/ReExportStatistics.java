package com.dijiang.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(value = "ReExportStatistics",description = "统计任务重新导出信息实体")
public class ReExportStatistics  implements Serializable {
    @ApiModelProperty(name = "id",value = "被统计的的导出任务编号")
    private String id;
    @ApiModelProperty(name = "fileId",value = "文件编号")
    private String fileId;
    @ApiModelProperty(name = "fileName",value = "文件名称")
    private String fileName;
    @ApiModelProperty(name = "total",value = "总共被导出多少次")
    private Integer total;
    @ApiModelProperty(name = "initCount",value = "重新导出 正在导出的次数")
    private Integer initCount;
    @ApiModelProperty(name = "normalCount",value = "重新导出  正常导出的次数")
    private Integer normalCount;
    @ApiModelProperty(name = "exceptionCount",value = "重新导出  异常导出的次数")
    private Integer exceptionCount;
    @ApiModelProperty(name = "applicationId",value = "系统编号")
    private String applicationId;
    @ApiModelProperty(name = "applicationName",value = "系统名称")
    private String applicationName;
    @ApiModelProperty(name = "modularId",value = "系统模块编号")
    private String modularId;
    @ApiModelProperty(name = "modularName",value = "系统模块名称")
    private String modularName;
    @ApiModelProperty(name = "siteCode",value = "网点编号")
    private String siteCode;
    @ApiModelProperty(name = "siteName",value = "网点名称")
    private String siteName;
    @ApiModelProperty(name = "userId",value = "创建人编号")
    private String createUserId;
    @ApiModelProperty(name = "userName",value = "创建人名称")
    private String userName;
    @ApiModelProperty(name = "createTime",value = "被统计的任务 创建时间")
    private Date createTime;



}
