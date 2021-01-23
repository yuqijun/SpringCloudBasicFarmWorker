package com.dijiang.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QueueInfo {
    private String userName;
    private String serverPort;
    private String serverIp;
    private String virtualHost;
    private String password;
    private String queueName;
}
