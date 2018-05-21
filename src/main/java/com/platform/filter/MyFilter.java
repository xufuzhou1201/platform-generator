package com.platform.filter;

import org.apache.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 使用注解定义一个过滤器
 *
 * @author lipengjun
 * @date 2018年01月15日 下午22:29:40
 */
@WebFilter(urlPatterns = "/*", filterName = "myFilter")
public class MyFilter implements Filter {

    private Logger logger = Logger.getLogger(getClass());

    @Override
    public void destroy() {
        logger.info("destroy()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        logger.info("doFilter()");
        logger.info("before filter");
        chain.doFilter(request, response);
        logger.info("after filter");
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        logger.info("init()");
    }
}
