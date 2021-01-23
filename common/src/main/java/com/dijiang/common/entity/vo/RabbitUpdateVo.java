package com.dijiang.common.entity.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "RabbitUpdateVo",description = "Rabbit队列信息修改参数实体类")
public class RabbitUpdateVo implements Serializable {
    private String applicationId;
    private String queueName;
    private Integer concurrentConsumers;
}
