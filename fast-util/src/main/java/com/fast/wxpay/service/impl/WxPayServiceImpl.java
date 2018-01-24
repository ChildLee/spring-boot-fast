package com.fast.wxpay.service.impl;

import com.fast.utils.*;
import com.fast.wxpay.model.UnifiedOrder;
import com.fast.wxpay.service.WxPayService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class WxPayServiceImpl implements WxPayService {
    @Override
    public String getOpenId() {
        return null;
    }

    @Override
    public Map<String, String> getPrepayId(UnifiedOrder unifiedOrder) {
        Map<String, String> params = new HashMap();
        params.put("appid", unifiedOrder.getAppid());
        params.put("mch_id", unifiedOrder.getMch_id());
        //params.put("device_info", unifiedOrder.getDevice_info());
        params.put("nonce_str", RandomUtil.getRandomString(32).toUpperCase());
        //params.put("sign", payParams.getSign());
        //params.put("sign_type", unifiedOrder.getSign_type());
        params.put("body", unifiedOrder.getBody());//商品描述,如:腾讯充值中心-QQ会员充值
        //params.put("detail", unifiedOrder.getDetail());
        //params.put("attach", unifiedOrder.getAttach());
        params.put("out_trade_no", DateUtil.getNoFormatTime().concat(RandomUtil.getRandomNumber(18)));
        //params.put("fee_type", unifiedOrder.getFee_type());
        params.put("total_fee", String.valueOf(new BigDecimal(unifiedOrder.getTotal_fee()).movePointRight(2).intValue()));
        params.put("spbill_create_ip", "127.0.0.1");
        //params.put("time_start", unifiedOrder.getTime_start());
        //params.put("time_expire", unifiedOrder.getTime_expire());
        //params.put("goods_tag", unifiedOrder.getGoods_tag());
        params.put("notify_url", unifiedOrder.getNotify_url());
        params.put("trade_type", "JSAPI");
        //params.put("product_id", unifiedOrder.getProduct_id());
        //params.put("limit_pay", unifiedOrder.getLimit_pay());
        params.put("openid", unifiedOrder.getOpenid());

        //ConvertUtil.removeNullValue(params);//除去集合中的空值

        String keyValue = ConvertUtil.toKeyValueSort(params);

        //MD5运算生成签名，这里是第一次签名，用于调用统一下单接口
        String sign = SecurityUtil.MD5(keyValue.concat("&key=").concat("key")).toUpperCase();
        //将签名后的字符串放入集合
        params.put("sign", sign);
        //参数转换成xml格式
        String xml = ConvertUtil.toXML(params);
        //访问微信支付接口发送数据并接受结果
        String result = WebUtil.sendPost("", xml);
        //将获取的xml格式结果转换成map键值对
        Map<String, String> map = ConvertUtil.xmlToMap(result);

        return map;
    }


}
