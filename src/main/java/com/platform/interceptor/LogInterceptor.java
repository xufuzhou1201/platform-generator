package com.platform.interceptor;

import com.platform.utils.RequestUtil;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 拦截器
 *
 * @author lipengjun
 * @date 2018年01月15日 下午22:29:40
 */
public class LogInterceptor implements HandlerInterceptor {
    private Logger logger = Logger.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("REQUEST_START_TIME", new Date());
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String ip = RequestUtil.getIpAddrByRequest(request);

        UrlPathHelper urlPathHelper = new UrlPathHelper();
        String urlPath = urlPathHelper.getLookupPathForRequest(request);

        Date start = (Date) request.getAttribute("REQUEST_START_TIME");

        Date end = new Date();

        logger.info("本次请求耗时：" + (end.getTime() - start.getTime()) + "毫秒" + " 请求路径=" + urlPath + " 请求参数=" + RequestUtil.getParameters(request).toString() + " 来源IP=" + ip);
    }
}
