package com.platform.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 名称：StringUtils <br>
 * 描述：字符串工具类<br>
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-07-24 10:33
 */
public class StringUtils {
    private static Pattern linePattern = Pattern.compile("_(\\w)");
    /**
     * 数据库驱动
     */
    public static String dbType = "";

    /**
     * 下划线转驼峰
     */
    public static String lineToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
