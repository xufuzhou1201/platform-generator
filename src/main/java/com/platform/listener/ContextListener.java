package com.platform.listener;

import com.alibaba.druid.pool.DruidDataSource;
import com.platform.utils.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

/**
 * 监听器
 *
 * @author lipengjun
 * @date 2018年01月15日 下午22:29:40
 */
@WebListener
public class ContextListener implements ServletContextListener {
    @Autowired
    DataSource dataSource;

    private Logger logger = Logger.getLogger(getClass());
    private static final String ORACLE_DRIVER_CLASS_NAME = "oracle.jdbc.OracleDriver";
    private static final String MYSQL_DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String driverClassName = ((DruidDataSource) dataSource).getDriverClassName();

        if (driverClassName.equals(ORACLE_DRIVER_CLASS_NAME)) {
            StringUtils.dbType = "oracle";
        } else if (driverClassName.equals(MYSQL_DRIVER_CLASS_NAME)) {
            StringUtils.dbType = "mysql";
        }
        logger.info("DRIVER_CLASS_NAME：" + StringUtils.dbType);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
