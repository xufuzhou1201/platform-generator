package com.platform.advice;

import com.platform.utils.R;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 建言
 *
 * @author lipengjun
 * @date 2018年01月15日 下午22:29:40
 */
@RestControllerAdvice(value = {"com.platform"})
public class BasePackageAdvice {
    private Logger logger = Logger.getLogger(getClass());

    @ExceptionHandler(value = Exception.class)
    public R ExceptionHandler(Exception exception) {
        String msg = generateMessage(exception);

        logger.error(msg);
        return R.error(msg);
    }

    /**
     * 主要功能: 根据异常生成Log日志信息 注意事项:无
     *
     * @param exception 异常信息
     * @return String 日志信息
     */
    private String generateMessage(Exception exception) {
        // 记录详细日志到LOG文件
        String message = "";
        for (StackTraceElement stackTraceElement : exception.getStackTrace()) {

            if (stackTraceElement.toString().startsWith("com.platform")) {
                message += "类名：" + stackTraceElement.getFileName() + ";方法："
                        + stackTraceElement.getMethodName() + ";行号："
                        + stackTraceElement.getLineNumber() + ";异常信息:"
                        + exception.getMessage();
                break;
            }
            if (stackTraceElement.toString().startsWith(
                    "org.springframework")) {
                message += "类名：" + stackTraceElement.getFileName() + ";方法："
                        + stackTraceElement.getMethodName() + ";行号："
                        + stackTraceElement.getLineNumber() + ";异常信息:"
                        + exception.getMessage();
                break;
            }
        }
        exception.printStackTrace();
        return message;
    }
}
