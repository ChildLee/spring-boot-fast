package com.fast.wxpay.service;

import com.fast.wxpay.model.UnifiedOrder;

import java.util.Map;

public interface WxPayService {
    /**
     * 1.获取OpenID
     */
    String getOpenId();

    /**
     * 2.获取prepay_id
     */
    Map<String, String> getPrepayId(UnifiedOrder unifiedOrder);
}