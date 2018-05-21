package com.platform.task;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 名称：TestTask <br>
 * 描述：<br>
 *
 * @author 李鹏军
 * @version 1.0
 * @since 1.0.0
 */
// 声明类为系统配置类
// 开启调度任务
@Configuration
@EnableScheduling
public class TestTask {
    private Logger logger = Logger.getLogger(getClass());

    /**
     * 定义调度器
     */
    @Scheduled(cron = "0 0 12 * * ?")
    public void task() {
        logger.info("定时任务：task execute");
    }
}
