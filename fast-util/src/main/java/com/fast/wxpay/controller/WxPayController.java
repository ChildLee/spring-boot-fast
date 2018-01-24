package com.fast.wxpay.controller;

import com.fast.result.Result;
import com.fast.result.ResultUtil;
import com.fast.wxpay.model.UnifiedOrder;
import com.fast.wxpay.service.WxPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class WxPayController {
    @Autowired
    private WxPayService wxPayService;

    @PostMapping("getPrepayId")
    public Result getPrepayId(UnifiedOrder unifiedOrder) {
        Map<String, String> map = wxPayService.getPrepayId(unifiedOrder);
        if ("SUCCESS".equals(map.get("return_code"))) {
            return ResultUtil.success(map);
        }
        return ResultUtil.wxPayError(map.get("return_msg"));
    }
}
