package com.xiadiao.fruits.mall.backend.model;

@lombok.Data
public class PaymentRequest {
    private String addressId;
    private Integer orderTotal;
    private String productId;
    private Integer productNum;
}
