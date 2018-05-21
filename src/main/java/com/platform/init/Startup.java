package com.platform.init;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 实现服务器启动即执行某些操作，只需要实现spring boot中的CommandLineRunner接口即可
 *
 * @author lipengjun
 * @date 2018年01月15日 下午22:29:40
 */
@Component
// 设置启动执行顺序
@Order(value = 1)
public class Startup implements CommandLineRunner {
    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void run(String... strings) throws Exception {
        logger.info("执行启动任务1...");
    }
}
