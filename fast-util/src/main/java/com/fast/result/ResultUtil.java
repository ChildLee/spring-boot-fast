package com.fast.result;


/**
 * 返回结果对象工具类
 */
public class ResultUtil {

    private static Result<Object> result = new Result<>();

    /**
     * @param object 需要返回的结果对象
     * @return 成功后的结果
     */
    public static Result success(Object object) {
        result.setCode(0);
        result.setMsg("success");
        result.setData(object);
        return result;
    }

    /**
     * 自定义错误码和错误提示
     *
     * @param code 状态码
     * @param msg  提示信息
     * @return 失败后的结果
     */
    public static Result error(int code, String msg) {
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**
     * 根据错误码返回相应的错误信息
     *
     * @param code 错误码
     * @return 返回对应的错误信息
     */
    public static Result error(int code) {
        Result err;
        switch (code) {
            case 1001:
                err = error(10001, "参数值为空");
                break;
            case 1002:
                err = error(10002, "参数长度不正确");
                break;
            default:
                err = error(-1, "服务器内部错误");
                break;
        }
        return err;
    }

    /**
     * 根据错误码返回相应的错误信息
     *
     * @param errCode 错误码
     * @return 返回对应的错误信息
     */
    public static Result wxPayError(String errCode) {
        Result err;
        switch (errCode) {
            case "NOAUTH":
                err = error(11001, "商户无此接口权限");
                break;
            case "NOTENOUGH":
                err = error(11002, "余额不足");
                break;
            case "ORDERPAID":
                err = error(11003, "商户订单已支付");
                break;
            case "ORDERCLOSED":
                err = error(11004, "订单已关闭");
                break;
            case "SYSTEMERROR":
                err = error(11005, "系统错误");
                break;
            case "APPID_NOT_EXIST":
                err = error(11006, "APPID不存在");
                break;
            case "MCHID_NOT_EXIST":
                err = error(11007, "MCHID不存在");
                break;
            case "APPID_MCHID_NOT_MATCH":
                err = error(11008, "appid和mch_id不匹配");
                break;
            case "LACK_PARAMS":
                err = error(11009, "缺少参数");
                break;
            case "OUT_TRADE_NO_USED":
                err = error(11010, "商户订单号重复");
                break;
            case "SIGNERROR":
                err = error(11011, "签名错误");
                break;
            case "XML_FORMAT_ERROR":
                err = error(11012, "XML格式错误");
                break;
            case "REQUIRE_POST_METHOD":
                err = error(11013, "请使用post方法");
                break;
            case "POST_DATA_EMPTY":
                err = error(11014, "post数据为空");
                break;
            case "NOT_UTF8":
                err = error(11015, "编码格式错误");
                break;
            default:
                err = error(11000, "未知错误");
                break;
        }
        return err;
    }
}
