package com.fast.utils;

import java.util.Random;

/**
 * 随机数
 */
public class RandomUtil {

    private static Random random = new Random();

    /**
     * 获取一定长度的随机数字
     *
     * @param length 指定数字长度
     * @return 一定长度的数字
     */
    public static String getRandomNumber(int length) {
        String sources = "0123456789";
        return generateRandomString(length, sources);
    }

    /**
     * 获取一定长度的随机字符串
     *
     * @param length 指定字符串长度
     * @return 一定长度的字符串
     */
    public static String getRandomString(int length) {
        String sources = "abcdefghijklmnopqrstuvwxyz0123456789";
        return generateRandomString(length, sources);
    }

    public static String generateRandomString(int length, String sources) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(sources.charAt(random.nextInt(sources.length())));
        }
        return sb.toString();
    }
}
