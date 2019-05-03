package com.xiadiao.fruits.mall.backend.model;

@lombok.Data
public class EditCartRequest {
    private String productId;
    private Integer productNum;
    private String checked;
}
