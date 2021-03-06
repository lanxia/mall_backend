package com.xiadiao.fruits.mall.backend.controller;

import com.xiadiao.fruits.mall.backend.model.ComputerResult;
import com.xiadiao.fruits.mall.backend.model.Product;
import com.xiadiao.fruits.mall.backend.model.ProductList;
import com.xiadiao.fruits.mall.backend.module.AddCartRequest;
import com.xiadiao.fruits.mall.backend.module.Resp;
import com.xiadiao.fruits.mall.backend.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/goods", produces = {"application/json"})
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/computer", method = RequestMethod.GET)
    public Resp<ComputerResult> compute(@RequestParam(value = "sort", required = false) String sort,
                                        @RequestParam(value = "page", required = false) Integer page,
                                        @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                        @RequestParam(value = "priceGt", required = false) Long priceGt,
                                        @RequestParam(value = "priceLte", required = false) Long priceLte) {
        return goodsService.computer(sort, page, pageSize, priceGt, priceLte);
    }

    @RequestMapping(value = "/addCart", method = RequestMethod.POST)
    public Resp<String> addCart(@CookieValue(value = "userId", required = false) String userId,
                        @RequestBody AddCartRequest request) {
        return goodsService.addCart(userId, request);
    }

    @RequestMapping(value = "/addCartBatch", method = RequestMethod.POST)
    public void addCartBatch() {
        return ;
    }

    @RequestMapping(value = "/productHome", method = RequestMethod.GET)
    public Resp<ProductList> list() {
        return goodsService.list();
    }

    @RequestMapping(value = "/productDet", method = RequestMethod.GET)
    public Resp<Product> detail(@RequestParam("productId") String productId) {
        return goodsService.detail(productId);
    }
}
