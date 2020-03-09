package com.system.entity;

import com.system.entity.Result;
import com.system.entity.ResultCode;

/**
 * @description 响应结果生成工厂类
 * @author Yangchen
 * @date 2020年02月21日
 * @memo 无备注说明
 */

public class ResultFactory {
    public static Result buildSuccessResult(Object data) {
        return buidResult(ResultCode.SUCCESS, "success", data);
    }
    public static Result buildSuccessMessage(String message) {
        return buidResult(ResultCode.SUCCESS, message, null);
    }

    public static Result buildFailResult(String message) {
        return buidResult(ResultCode.FAIL, message, null);
    }

    public static Result buidResult(ResultCode resultCode, String message, Object data) {
        return buidResult(resultCode.code, message, data);
    }

    public static Result buidResult(int resultCode, String message, Object data) {
        return new Result(resultCode, message, data);
    }
}
