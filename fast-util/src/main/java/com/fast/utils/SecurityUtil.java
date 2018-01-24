package com.fast.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5
 */
public class SecurityUtil {
    private static final Logger log = LoggerFactory.getLogger(SecurityUtil.class);

    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * 字符串转MD5
     *
     * @param param 转换字符串
     * @return MD5
     */
    public static String MD5(String param) {
        if (param == null) return null;
        char[] chars = new char[32];
        try {
            byte[] bytes = MessageDigest.getInstance("MD5").digest(param.getBytes("utf-8"));
            for (int i = 0; i < chars.length; i = i + 2) {
                byte b = bytes[i / 2];
                chars[i] = HEX_CHARS[(b >>> 0x4) & 0xf];
                chars[i + 1] = HEX_CHARS[b & 0xf];
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            log.error("字符串转MD5时报错");
        }
        return String.valueOf(chars);
    }
}
