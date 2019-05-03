package com.xiadiao.fruits.mall.backend.model;

import javax.validation.constraints.NotNull;

@lombok.Data
public class UpdateAddressRequest {
    @NotNull
    private String addressId;
    @NotNull
    private String userName;
    @NotNull
    private String tel;
    @NotNull
    private String streetName;

    private Boolean isDefault;
}
