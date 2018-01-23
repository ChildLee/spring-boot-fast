package com.fast.util;

import java.text.SimpleDateFormat;
import java.util.*;

public class Util {

    //<editor-fold> 字符工具类

    /**
     * 判断是不是空值
     *
     * @param value 需要判断的值
     * @return 空值为true, 否则false
     */
    public static Boolean isNull(String value) {
        if (null == value || value.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public static Boolean paramIsNull(String value) {
        if (null == value || value.trim().isEmpty() || "undefined".equals(value) || "null".equals(value)) {
            return true;
        }
        return false;
    }

    //</editor-fold>

    //<editor-fold> 转换工具类

    /**
     * 除去Map集合中的空值
     *
     * @param params 参数集合
     */
    public static void mapFilter(Map<String, String> params) {
        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (isNull(entry.getKey()) || isNull(entry.getValue())) {
                iterator.remove();
            }
        }
    }

    /**
     * 对参数按照key=value的格式，并按照参数名ASCII字典序排序
     *
     * @param params 参数集合
     * @return 拼接完返回字符串
     */
    public static String spliceParamsToString(Map<String, String> params) {
        List<String> keys = new ArrayList<String>(params.keySet());
        //微信要求按照参数名ASCII字典序排序
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = params.get(key);
            if (isNull(value)) {
                continue;
            }
            sb.append("&" + key + "=" + value);
        }
        return sb.substring(1);
    }
    //</editor-fold>

    //<editor-fold> 时间工具类

    /**
     * 获取无分隔的系统时间
     *
     * @return 无分隔格式的系统时间字符串
     */
    public static String getNoSpaceTime() {
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
        return df.format(new Date().getTime() + (minute * 60 * 1000));
    }
    //</editor-fold>

    //<editor-fold> Web工具类


    //</editor-fold>

    //<editor-fold> 随机数工具类


    //</editor-fold>


}
