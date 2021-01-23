package com.dijiang.staff.config;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

/**
 * @author yqj
 * @version 1.0
 * @description
 * @date 2020/12/17 9:03
 */
@Configuration
@EnableScheduling
@Slf4j
public class TimedTaskConfig implements SchedulingConfigurer {
//
    @Value("${time}")
    private String time;

    @Value("${timeout}")
    private String timeout;


    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                ()->{
                    log.info("timeout："+timeout);
                    log.info("正在执行定时任务当前时间间隔："+time);
                    //获取jdbcDatasourceContainer的集合，然后遍历检查时间使用时间

                },triggerContext -> {
                    if(StringUtils.isEmpty(time)){
                        log.info("定时任务时间不合法.......");
                    }
                    return new CronTrigger(time).nextExecutionTime(triggerContext);
                }
        );
    }
}
