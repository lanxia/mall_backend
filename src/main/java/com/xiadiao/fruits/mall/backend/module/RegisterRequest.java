package com.xiadiao.fruits.mall.backend.module;

@lombok.Data
public class RegisterRequest {
    private String userName;
    private String userPwd;
    private String realName;
    private String nickName;
    private String email;
    private String phone;
    private String sex;
}
