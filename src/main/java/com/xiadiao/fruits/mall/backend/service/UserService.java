package com.xiadiao.fruits.mall.backend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiadiao.fruits.mall.backend.dao.UserCartOrderMapper;
import com.xiadiao.fruits.mall.backend.dao.UsersMapper;
import com.xiadiao.fruits.mall.backend.model.*;
import com.xiadiao.fruits.mall.backend.module.LoginRequest;
import com.xiadiao.fruits.mall.backend.module.RegisterRequest;
import com.xiadiao.fruits.mall.backend.module.Resp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private UserCartOrderMapper userCartOrderMapper;

    private static final String avatar = "http://osc9sqdxe.bkt.clouddn.com/default-user-avatar.png";

    public Resp<Users> login(LoginRequest request,
                             HttpServletResponse response) {
        Resp<Users> resp = new Resp<>();

        UsersExample query = new UsersExample();
        query.createCriteria()
            .andUsernameEqualTo(request.getUserName())
            .andUserpwdEqualTo(request.getUserPwd());

        List<Users> users =  usersMapper.selectByExample(query);
        if (CollectionUtils.isEmpty(users)) {
            resp.setStatus(1);
            resp.setMsg("账号或者密码错误");

            return resp;
        }

        Cookie cookie = new Cookie("userId", users.get(0).getUserid());
        cookie.setMaxAge(1000 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);

        resp.setResult(users.get(0));

        return resp;
    }

    public Resp<String> logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("userId", "");
        cookie.setPath("/");
        cookie.setMaxAge(-1);
        response.addCookie(cookie);

        return new Resp<>();
    }

    public Resp<String> register(RegisterRequest request,
                                 HttpServletResponse response) {
        Resp<String> resp = new Resp<>();

        UsersExample query = new UsersExample();
        query.createCriteria()
            .andUsernameEqualTo(request.getUserName());

        List<Users> users =  usersMapper.selectByExample(query);
        if (!CollectionUtils.isEmpty(users)) {
            resp.setStatus(1);
            resp.setMsg("账号已存在");

            return resp;
        }

        Users user = new Users();
        user.setUuid(UUID.randomUUID().toString());
        user.setUserid(user.getUuid());
        user.setAvatar(avatar);
        user.setUsername(request.getUserName());
        user.setUserpwd(request.getUserPwd());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setNickname(request.getNickName());
        user.setRealname(request.getRealName());
        ObjectMapper mapper = new ObjectMapper();
        List<Address> addresses = new ArrayList<>();

        try {
            user.setAddresslist(mapper.writeValueAsString(addresses));
        } catch (Exception e) {
            resp.setStatus(1);
            resp.setMsg(e.getMessage());

            return resp;
        }


        usersMapper.insert(user);

        UserCartOrderWithBLOBs userCartOrderWithBLOBs = new UserCartOrderWithBLOBs();
        userCartOrderWithBLOBs.setUserid(user.getUuid());
        userCartOrderWithBLOBs.setUuid(UUID.randomUUID().toString());

        List<CartGoods> cartList = new ArrayList<>();
        List<OrderItem> orderList = new ArrayList<>();

        try {
            userCartOrderWithBLOBs.setCartlist(mapper.writeValueAsString(cartList));
            userCartOrderWithBLOBs.setOrderlist(mapper.writeValueAsString(orderList));
        } catch (Exception e) {
            resp.setStatus(1);
            resp.setMsg("JSON序列化错误");

            return  resp;
        }

        userCartOrderMapper.insert(userCartOrderWithBLOBs);

        resp.setMsg("注册成功");
        return resp;
    }

    public Resp<Users> userInfo(String userId) {
        Resp<Users> resp = new Resp<>();

        if (StringUtils.isEmpty(userId)) {
            resp.setStatus(1);
            resp.setMsg("未登录");

            return resp;
        }

        UsersExample query = new UsersExample();
        query.createCriteria()
            .andUseridEqualTo(userId);

        List<Users> users =  usersMapper.selectByExample(query);
        if (CollectionUtils.isEmpty(users)) {
            resp.setStatus(1);
            resp.setMsg("未登录");

            return resp;
        }

        resp.setResult(users.get(0));

        return resp;
    }

    public Resp<String> addAddress(String userId, AddAddressRequest request) {
        Resp<String> resp = new Resp<>();

        UsersExample query = new UsersExample();
        query.createCriteria().andUseridEqualTo(userId);
        List<Users> users = usersMapper.selectByExampleWithBLOBs(query);
        if (CollectionUtils.isEmpty(users)) {
            resp.setStatus(1);
            resp.setMsg("用户不存在");

            return resp;
        }

        Users user = users.get(0);
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Address> addresses = mapper.readValue(user.getAddresslist(),
                                        new TypeReference<List<Address>>() {});
            if (request.getIsDefault()) {
                for (Address address : addresses) {
                    address.setIsDefault(false);
                }
            }

            Address add = new Address();
            add.setAddressId(UUID.randomUUID().toString());
            add.setIsDefault(request.getIsDefault());
            add.setStreetName(request.getStreetName());
            add.setTel(request.getTel());
            add.setUserId(request.getUserId());
            add.setUserName(request.getUserName());

            addresses.add(add);

            user.setAddresslist(mapper.writeValueAsString(addresses));

            usersMapper.updateByPrimaryKey(user);
        } catch (Exception e) {
            resp.setStatus(1);
            resp.setMsg(e.getMessage());

            return resp;
        }

        resp.setMsg("suc");
        return resp;
    }

    public Resp<List<Address>> listAddress(String userId, ListAddressRequest request) {
        Resp<List<Address>> resp = new Resp<>();

        if (!StringUtils.isEmpty(userId)) {
            UsersExample query = new UsersExample();
            query.createCriteria().andUseridEqualTo(userId);

            List<Users> users = usersMapper.selectByExampleWithBLOBs(query);
            if (CollectionUtils.isEmpty(users)) {
                resp.setStatus(1);
                resp.setMsg("用户不存在");

                return resp;
            }

            Users user = users.get(0);
            ObjectMapper mapper = new ObjectMapper();

            try {
                List<Address> addresses = mapper.readValue(user.getAddresslist(),
                    new TypeReference<List<Address>>() {});

                if (!StringUtils.isEmpty(request.getAddressId())) {
                    for (Address a : addresses) {
                        if (a.getAddressId().equals(request.getAddressId())) {
                            List<Address> newAddress = new ArrayList<>();
                            newAddress.add(a);

                            resp.setResult(newAddress);
                            break;
                        }
                    }
                } else {
                    resp.setResult(addresses);
                }
            } catch (Exception e) {
                resp.setStatus(1);
                resp.setMsg(e.getMessage());

                return resp;
            }
        }

        return resp;
    }

    public Resp<List<CartGoods>> listCart(String userId) {
        Resp<List<CartGoods>> resp = new Resp<>();
        if (StringUtils.isEmpty(userId)) {
            resp.setStatus(1);
            resp.setMsg("用户不存在");

            return resp;
        }

        UserCartOrderExample query = new UserCartOrderExample();
        query.createCriteria().andUseridEqualTo(userId);
        List<UserCartOrderWithBLOBs> users = userCartOrderMapper.selectByExampleWithBLOBs(query);

        if (CollectionUtils.isEmpty(users)) {
            resp.setStatus(1);
            resp.setMsg("用户不存在");

            return resp;
        }

        UserCartOrderWithBLOBs user = users.get(0);
        ObjectMapper mapper = new ObjectMapper();
        try {
             List<CartGoods> carts = mapper.readValue(user.getCartlist(),
                                        new TypeReference<List<CartGoods>>() {});
             resp.setCount(carts.size());
             resp.setResult(carts);
        } catch (Exception e) {
            resp.setStatus(1);
            resp.setMsg(e.getMessage());

            return resp;
        }

        return  resp;
    }
}
