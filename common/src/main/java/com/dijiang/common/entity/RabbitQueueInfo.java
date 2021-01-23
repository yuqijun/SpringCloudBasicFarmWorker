package com.dijiang.common.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;
import java.io.Serializable;
import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@ApiModel(value = "RabbitQueueInfo",description = "RabbitMQ 队列配置实体类")
@TableName(value = "tb_rabbit_queue_info")
public class RabbitQueueInfo implements Serializable {

    @ApiModelProperty(name = "id",value = "表主键")
    private String id;

    @ApiModelProperty(name = "applicationId",value = "系统编号")
    private String applicationId;

    @ApiModelProperty(name = "applicationName",value = "系统名称")
    private String applicationName;

    @ApiModelProperty(name = "modularId" , value = "系统模块编号")
    private String modularId;

    @ApiModelProperty(name = "modularName",value = "系统模块名称")
    private String modularName;

    @ApiModelProperty(name = "createUserId",value = "记录创建用户编号")
    private String createUserId;

    @ApiModelProperty(name = "userName",value = "用户名称")
    private String userName;

    @ApiModelProperty(name = "siteCode",value = "网点编码")
    private String siteCode;

    @ApiModelProperty(name = "siteName",value = "网点名称")
    private String siteName;

    @ApiModelProperty(name = "createTime",value = "记录创建时间")
    private Date createTime;

    @ApiModelProperty(name = "updateUserId",value = "记录修改用户编号")
    private String updateUserId;

    @ApiModelProperty(name = "updateTime",value = "记录修改时间")
    private Date updateTime;



    @ApiModelProperty(name = "name",value = "队列名称")
    private String name;

    @ApiModelProperty(name = "durable",value = "是否持久化")
    private boolean durable;

    @ApiModelProperty(name = "exclusive",value = "是否独占队列")
    private boolean exclusive;

    @ApiModelProperty(name = "autoDelete",value = "没有消息是是否删除队列")
    private boolean autoDelete;

    @ApiModelProperty(name = "arguments",value = "其他参数")
    private String arguments;

    /* 队列监听容器配置 */

    @ApiModelProperty(name = "concurrentConsumers",value = "初始化消费者数量")
    private Integer concurrentConsumers;

    @ApiModelProperty(name = "maxConcurrentConsumers",value = "消费者最大数量")
    private Integer maxConcurrentConsumers;

    @ApiModelProperty(name = "defaultRequeueRejected",value = "是否丢弃消息或者发布到死信队列")
    private boolean defaultRequeueRejected;

    @ApiModelProperty(name = "acknowledgeMode",value = "消息确认机制")
    private String acknowledgeMode;

    @ApiModelProperty(name = "exposeListenerChannel",value = "是否向外暴漏监听通道")
    private boolean exposeListenerChannel;
}
