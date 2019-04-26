package com.xiadiao.fruits.mall.backend.model;

import java.util.List;

@lombok.Data
public class Product {
    private String productId;
    private Long salePrice;
    private String productName;
    private String sub_title;
    private Long limit_num;
    private String productImageBig;
    private ProductMsg productMsg;
    private Long stock;
    private List<String> productImageSmall;
}
