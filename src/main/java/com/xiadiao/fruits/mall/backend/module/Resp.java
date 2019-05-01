package com.xiadiao.fruits.mall.backend.module;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.xiadiao.fruits.mall.backend.constant.RespEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Resp<T> {

    /**
     * 响应状态码
     */
    private int status = RespEnum.SUCCESS.getStatus();

    /**
     * 响应消息
     */
    private String msg = RespEnum.SUCCESS.getMsg();

    /**
     * 响应数据
     */
    private T result;

//    private Integer count = 0;

    public Resp() {
    }

    public Resp(final int status, final String msg) {
        this(status, msg, null);
    }

    public static <T> Resp<T> get(final int status, final String msg) {
        return Resp.get(status, msg, null);
    }

    public static <T> Resp<T> get(final RespEnum respEnum) {
        return Resp.get(respEnum.getStatus(), respEnum.getMsg(), null);
    }

    public static <T> Resp<T> get(final RespEnum respEnum, final T data) {
        return Resp.get(respEnum.getStatus(), respEnum.getMsg(), data);
    }

    public static <T> Resp<T> get(final int status, final String msg, final T data) {
        return new Resp<>(status, msg, data);
    }

    public static <T> Resp<T> success() {
        return Resp.get(RespEnum.SUCCESS);
    }

    public static <T> Resp<T> success(T data) {
        return Resp.get(RespEnum.SUCCESS, data);
    }
}
