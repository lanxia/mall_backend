package com.xiadiao.fruits.mall.backend.module;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.xiadiao.fruits.mall.backend.constant.RespEnum;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageResp<T> {
    /**
     * 响应状态码
     */
    private int status = RespEnum.SUCCESS.getStatus();;
    /**
     * 响应消息
     */
    private String msg = RespEnum.SUCCESS.getMsg();
    /**
     * 当前页码
     */
    private int page;
    /**
     * 每页展示数量
     */
    private int size;
    /**
     * 总记录数
     */
    private long total;
    /**
     * 总页数
     */
    private long pageTotal;
    /**
     * 响应带回的具体数据；
     */
    private List<T> items;

    public PageResp() {
    }

    public PageResp(RespEnum respEnum) {
        this.status = respEnum.getStatus();
        this.msg = respEnum.getMsg();
    }
}

