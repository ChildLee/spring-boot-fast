package com.fast.wxpay.model;

public class UnifiedOrder {
    private String appid;//小程序ID
    private String mch_id;//商户号
    private String device_info;//设备号
    private String nonce_str;//随机字符串
    private String sign;//签名
    private String sign_type;//签名类型
    private String body;//商品描述
    private String detail;//商品详情
    private String attach;//附加数据
    private String out_trade_no;//商户订单号
    private String fee_type;//货币类型
    private String total_fee;//总金额
    private String spbill_create_ip;//终端IP
    private String time_start;//交易起始时间
    private String time_expire;//交易结束时间
    private String goods_tag;//订单优惠标记
    private String notify_url;//通知地址
    private String trade_type;//交易类型
    private String product_id;//商品ID
    private String limit_pay;//指定支付方式
    private String openid;//用户标识

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getFee_type() {
        return fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getTime_expire() {
        return time_expire;
    }

    public void setTime_expire(String time_expire) {
        this.time_expire = time_expire;
    }

    public String getGoods_tag() {
        return goods_tag;
    }

    public void setGoods_tag(String goods_tag) {
        this.goods_tag = goods_tag;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getLimit_pay() {
        return limit_pay;
    }

    public void setLimit_pay(String limit_pay) {
        this.limit_pay = limit_pay;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UnifiedOrder{");
        sb.append("appid='").append(appid).append('\'');
        sb.append(", mch_id='").append(mch_id).append('\'');
        sb.append(", device_info='").append(device_info).append('\'');
        sb.append(", nonce_str='").append(nonce_str).append('\'');
        sb.append(", sign='").append(sign).append('\'');
        sb.append(", sign_type='").append(sign_type).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append(", detail='").append(detail).append('\'');
        sb.append(", attach='").append(attach).append('\'');
        sb.append(", out_trade_no='").append(out_trade_no).append('\'');
        sb.append(", fee_type='").append(fee_type).append('\'');
        sb.append(", total_fee='").append(total_fee).append('\'');
        sb.append(", spbill_create_ip='").append(spbill_create_ip).append('\'');
        sb.append(", time_start='").append(time_start).append('\'');
        sb.append(", time_expire='").append(time_expire).append('\'');
        sb.append(", goods_tag='").append(goods_tag).append('\'');
        sb.append(", notify_url='").append(notify_url).append('\'');
        sb.append(", trade_type='").append(trade_type).append('\'');
        sb.append(", product_id='").append(product_id).append('\'');
        sb.append(", limit_pay='").append(limit_pay).append('\'');
        sb.append(", openid='").append(openid).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
