package com.xiadiao.fruits.mall.backend.model;

@lombok.Data
public class CartGoods {
    private String productId;
    private Integer productNum;
    private String productImg;
    private String productName;
    private String checked;
    private Long productPrice;
}
