package com.xiadiao.fruits.mall.backend.model;

import java.util.Date;

@lombok.Data
public class Order {
    private String orderId;
    private Integer orderTotal;
    private Address addressInfo;
    private String goodsList;
    private String orderStatus;
    private Date createDate;
}
