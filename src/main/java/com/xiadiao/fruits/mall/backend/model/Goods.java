package com.xiadiao.fruits.mall.backend.model;

public class Goods {
    private String uuid;

    private String productid;

    private String productname;

    private String productmsg;

    private String subtitle;

    private String productimagesmall;

    private String productimagebig;

    private Long stock;

    private Long saleprice;

    private Long limitnum;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid == null ? null : productid.trim();
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public String getProductmsg() {
        return productmsg;
    }

    public void setProductmsg(String productmsg) {
        this.productmsg = productmsg == null ? null : productmsg.trim();
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }

    public String getProductimagesmall() {
        return productimagesmall;
    }

    public void setProductimagesmall(String productimagesmall) {
        this.productimagesmall = productimagesmall == null ? null : productimagesmall.trim();
    }

    public String getProductimagebig() {
        return productimagebig;
    }

    public void setProductimagebig(String productimagebig) {
        this.productimagebig = productimagebig == null ? null : productimagebig.trim();
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(Long saleprice) {
        this.saleprice = saleprice;
    }

    public Long getLimitnum() {
        return limitnum;
    }

    public void setLimitnum(Long limitnum) {
        this.limitnum = limitnum;
    }
}