package com.dijiang.common.entity.query;

import com.dijiang.common.entity.PageVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReExportStatisticsQuery extends PageVo {



    @ApiModelProperty(name = "exportId",value = "导出任务id编号")
    private String exportId;

    @ApiModelProperty(name = "startTime",value = "导出任务起始时间")
    private String startTime;

    @ApiModelProperty(name = "endTime",value = "导出任务结束时间")
    private String endTime;






//    @ApiModelProperty(name = "fileId",value = "文件id编号")
//    private String fileId;
//
//    @ApiModelProperty(name = "fileName",value = "文件名称")
//    private String fileName;
//
//    @ApiModelProperty(name = "fileSize",value = "文件大小")
//    private Integer fileSize;


    @NotEmpty
    @ApiModelProperty(name = "applicationId",value = "应用id编号")
    private String applicationId;

    @NotNull(message = "系统名称不能为空")
    @ApiModelProperty(name = "applicationName",value = "应用(系统)名称")
    private String applicationName;

    @NotEmpty
    @ApiModelProperty(name = "modularId",value = "系统模块id编号")
    private String modularId;

    @NotNull(message = "系统模块名称不能为空")
    @ApiModelProperty(name = "modularName",value = "系统模块名称")
    private String modularName;

    @ApiModelProperty(name = "siteCode",value = "网点编号")
    private String siteCode;

    @ApiModelProperty(name = "siteName",value = "网点名称")
    private String siteName;


    @NotEmpty
    @ApiModelProperty(name = "createUserId",value = "创建记录者id编号")
    private String createUserId;


    @ApiModelProperty(name = "userName",value = "用户名称")
    private String userName;


}
