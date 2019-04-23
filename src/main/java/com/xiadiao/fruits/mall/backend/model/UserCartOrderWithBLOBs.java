package com.xiadiao.fruits.mall.backend.model;

public class UserCartOrderWithBLOBs extends UserCartOrder {
    private String cartlist;

    private String orderlist;

    public String getCartlist() {
        return cartlist;
    }

    public void setCartlist(String cartlist) {
        this.cartlist = cartlist == null ? null : cartlist.trim();
    }

    public String getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(String orderlist) {
        this.orderlist = orderlist == null ? null : orderlist.trim();
    }
}