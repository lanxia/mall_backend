package com.xiadiao.fruits.mall.backend.model;

import javax.validation.constraints.NotNull;

@lombok.Data
public class AddAddressRequest {
    @NotNull
    private String userName;
    @NotNull
    private String tel;
    @NotNull
    private String userId;
    @NotNull
    private String streetName;

    private Boolean isDefault;
}
