package com.system.entity;

import lombok.Data;

/**
 * @description 统一 API响应结果封装
 * @author YangChen
 * @date 2020年02月21日
 * @memo 控制Result权限，构建结果Result对象统一使用com.javalsj.blog.vo.ResultFactory工厂类来创建
 */
@Data
public class Result {
    /**
     * 响应状态码
     */
    private int code;
    /**
     * 响应提示信息
     */
    private String message;
    /**
     * 响应结果对象
     */
    private Object data;
    /**
     * token密钥
     */
//    private String token;

    Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
//        this.token=token;
    }

}
