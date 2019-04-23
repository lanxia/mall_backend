package com.xiadiao.fruits.mall.backend.controller;

import com.xiadiao.fruits.mall.backend.module.Resp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/goods", produces = {"application/json"})
public class GoodsController {
    private final String SMARTISAN_URL = "http://www.smartisan.com/product/home";

    @RequestMapping(value = "/computer", method = RequestMethod.GET)
    public void compute() {
        return ;
    }

    @RequestMapping(value = "/addCart", method = RequestMethod.POST)
    public void addCart() {
        return ;
    }

    @RequestMapping(value = "/addCartBatch", method = RequestMethod.POST)
    public void addCartBatch() {
        return ;
    }

    @RequestMapping(value = "/productHome", method = RequestMethod.GET)
    public void list() {
        return ;
    }

    @RequestMapping(value = "/productDet", method = RequestMethod.GET)
    public void detail() {
        return ;
    }
}
