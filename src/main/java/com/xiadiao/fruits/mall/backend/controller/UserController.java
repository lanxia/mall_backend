package com.xiadiao.fruits.mall.backend.controller;

import com.xiadiao.fruits.mall.backend.model.*;
import com.xiadiao.fruits.mall.backend.module.LoginRequest;
import com.xiadiao.fruits.mall.backend.module.RegisterRequest;
import com.xiadiao.fruits.mall.backend.module.Resp;
import com.xiadiao.fruits.mall.backend.module.UpdateHeadImageRequest;
import com.xiadiao.fruits.mall.backend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/users", produces = {"application/json"})
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Resp<Users> login(@Valid @RequestBody LoginRequest request,
                             HttpServletResponse response) {
        return userService.login(request, response);
    }

    @RequestMapping(value = "/loginOut", method = RequestMethod.POST)
    public Resp<String> login(HttpServletResponse response) {
        return userService.logout(response);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Resp<String> register(@Valid @RequestBody RegisterRequest request,
                                HttpServletResponse response) {
        return userService.register(request, response);
    }

//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    public void upload() {
//        return ;
//    }

//    @RequestMapping(value = "/updateheadimage", method = RequestMethod.POST)
//    public void updateHeadImage(@CookieValue(value = "userId", required = false) String userId,
//                                @Valid @RequestBody UpdateHeadImageRequest request) {
//        return ;
//    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.POST)
    public Resp<Users> userInfo(@CookieValue(value = "userId", required = false) String userId) {
        return userService.userInfo(userId);
    }

    @RequestMapping(value = "/cartList", method = RequestMethod.POST)
    public Resp<List<CartGoods>> cartList(@CookieValue(value = "userId") String userId) {
        return userService.listCart(userId);
    }

    @RequestMapping(value = "/cartEdit", method = RequestMethod.POST)
    public void cartEdit(@CookieValue(value = "userId") String userId) {
        return ;
    }

    @RequestMapping(value = "/editCheckAll", method = RequestMethod.POST)
    public void editCheckAll(@CookieValue(value = "userId") String userId) {
        return ;
    }

    @RequestMapping(value = "/cartDel", method = RequestMethod.POST)
    public void cartDel(@CookieValue(value = "userId") String userId) {
        return ;
    }

    @RequestMapping(value = "/addressList", method = RequestMethod.POST)
    public Resp<List<Address>> addressList(@CookieValue(value = "userId") String userId,
                                           @RequestBody ListAddressRequest request) {
        return userService.listAddress(userId, request);
    }

    @RequestMapping(value = "/addressUpdate", method = RequestMethod.POST)
    public void addressUpdate(@CookieValue(value = "userId") String userId) {
        return ;
    }

    @RequestMapping(value = "/addressAdd", method = RequestMethod.POST)
    public Resp<String> addressAdd(@CookieValue(value = "userId") String userId,
                           @RequestBody AddAddressRequest request) {
        return userService.addAddress(userId, request);
    }

    @RequestMapping(value = "/addressDel", method = RequestMethod.POST)
    public void addressDel(@CookieValue(value = "userId") String userId) {
        return ;
    }

    @RequestMapping(value = "/payMent", method = RequestMethod.POST)
    public Resp<Order> payment(@CookieValue(value = "userId") String userId,
                        @RequestBody PaymentRequest request) {
        return userService.payment(userId, request);
    }

    @RequestMapping(value = "/orderList", method = RequestMethod.POST)
    public Resp<List<Order>> orderList(@CookieValue(value = "userId") String userId) {
        return userService.listOrder(userId);
    }

    @RequestMapping(value = "/delOrder", method = RequestMethod.POST)
    public Resp<String> orderDel(@CookieValue(value = "userId") String userId,
                         @RequestBody DelOrderRequest request) {
        return userService.delOrder(userId, request);
    }
}
