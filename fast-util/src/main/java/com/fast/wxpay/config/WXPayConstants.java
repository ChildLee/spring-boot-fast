package com.fast.wxpay.config;

public class WxPayConstants {
    public enum SignType {
        MD5, HMACSHA256
    }

    public static final String FAIL = "FAIL";
    public static final String SUCCESS = "SUCCESS";
    public static final String HMACSHA256 = "HMAC-SHA256";
    public static final String MD5 = "MD5";

    public static final String FIELD_SIGN = "sign";
    public static final String FIELD_SIGN_TYPE = "sign_type";

    public static final String JSCODE2SESSION_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    public static final String UNIFIEDORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
}
