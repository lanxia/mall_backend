package com.xiadiao.fruits.mall.backend.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public enum RespEnum {
    /**
     * 常用状态枚举
     */
    SUCCESS("0", "操作成功!");

    /**
     * 响应状态码
     */
    private String status;
    /**
     * 默认响应消息
     */
    private String msg;
}

