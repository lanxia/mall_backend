package com.xiadiao.fruits.mall.backend.model;

import java.util.List;

@lombok.Data
public class OrderGoods {
    private String orderId;
    private Integer orderTotal;
    private Address addressInfo;
    private List<CartGoods> goodsList;
    private String orderStatus;
    private String createDate;
}
