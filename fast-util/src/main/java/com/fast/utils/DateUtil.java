package com.fast.utils;

import java.text.SimpleDateFormat;

/**
 * 日期/时间
 */
public class DateUtil {
    /**
     * 获取无分隔的系统时间
     *
     * @return 无分隔格式的系统时间字符串
     */
    public static String getNoFormatTime() {
        //获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(System.currentTimeMillis());
    }

    /**
     * 获取分隔的系统时间
     *
     * @return 无分隔格式的系统时间字符串
     */
    public static String getFormatTime() {
        //获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(System.currentTimeMillis());
    }

    /**
     * 获取当前时间往后多少分钟的时间
     *
     * @param minute 分钟
     * @return 当前时间往后延迟的时间
     */
    public static String getTimeOut(int minute) {
        //获取系统当前时间
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(System.currentTimeMillis() + (minute * 60 * 1000));
    }
}
