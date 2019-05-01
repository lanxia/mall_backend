package com.xiadiao.fruits.mall.backend.model;

@lombok.Data
public class Good {
    private String uuid;

    private String productId;

    private String productName;

    private String productMsg;

    private String sub_title;

    private String productImageSmall;

    private String productImageBig;

    private Long stock;

    private Long salePrice;

    private Long limit_num;
}
