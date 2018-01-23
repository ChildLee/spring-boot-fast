package com.fast.result;


/**
 * 返回结果对象工具类
 */
public class ResultUtil {

    /**
     * @param object 需要返回的结果对象
     * @return 成功后的结果
     */
    public static Result success(Object object) {
        Result<Object> result = new Result<>();
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
        Result result = new Result();
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
        Result result = new Result();
        switch (code) {
            case 1001:
                result.setCode(1001);
                result.setMsg("参数值为空");
                break;
            case 1002:
                result.setCode(1002);
                result.setMsg("参数长度不正确");
                break;
            default:
                result.setCode(-1);
                result.setMsg("服务器内部错误");
                break;
        }
        return result;
    }
}
