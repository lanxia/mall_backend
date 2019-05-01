package com.xiadiao.fruits.mall.backend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiadiao.fruits.mall.backend.dao.GoodsMapper;
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
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private UserCartOrderMapper userCartOrderMapper;

    @Autowired
    private GoodsMapper goodsMapper;

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
        List<Order> orderList = new ArrayList<>();

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

    public Resp<Order> payment(String userId, PaymentRequest request) {
        Resp<Order> resp = new Resp<>();

        if (StringUtils.isEmpty(userId)) {
            resp.setStatus(1);
            resp.setMsg("未登录");

            return resp;
        }

        if (StringUtils.isEmpty(request.getAddressId())
            || StringUtils.isEmpty(request.getOrderTotal())) {
            resp.setStatus(1);
            resp.setMsg("缺少必须参数");

            return resp;
        }

        UsersExample query = new UsersExample();
        query.createCriteria().andUseridEqualTo(userId);
        List<Users> users = usersMapper.selectByExampleWithBLOBs(query);

        UserCartOrderExample select = new UserCartOrderExample();
        select.createCriteria().andUseridEqualTo(userId);
        List<UserCartOrderWithBLOBs> cartOrders =
            userCartOrderMapper.selectByExampleWithBLOBs(select);


        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Address> addresses = mapper.readValue(users.get(0).getAddresslist(),
                                        new TypeReference<List<Address>>() {});

            Address userAddress = new Address();
            for (Address item : addresses) {
                if (item.getAddressId().equals(request.getAddressId())) {
                    userAddress = item;
                    break;
                }
            }

            List<CartGoods> goodsList = new ArrayList<>();

            if (!StringUtils.isEmpty(request.getProductId())
                && !StringUtils.isEmpty(request.getProductNum())) {

                GoodsExample goodsQuery = new GoodsExample();
                goodsQuery.createCriteria().andProductidEqualTo(request.getProductId());
                List<Goods> goods = goodsMapper.selectByExample(goodsQuery);

                CartGoods item = new CartGoods();
                item.setProductImg(goods.get(0).getProductimagebig());
                item.setProductId(goods.get(0).getProductid());
                item.setProductName(goods.get(0).getProductname());
                item.setChecked("1");
                item.setProductNum(request.getProductNum());
                item.setProductPrice(goods.get(0).getSaleprice());

                goodsList.add(item);
            } else {
                List<CartGoods> carts = mapper.readValue(cartOrders.get(0).getCartlist(),
                                                new TypeReference<List<CartGoods>>() {});

                for (CartGoods cart : carts) {
                    if (cart.getChecked().equals("1")) {
                        goodsList.add(cart);
                    }
                }
            }

            Order order = new Order();
            order.setOrderId(UUID.randomUUID().toString());
            order.setAddressInfo(userAddress);
            order.setOrderTotal(request.getOrderTotal());
            order.setOrderStatus("1");
            order.setCreateDate(new Date());
            order.setGoodsList(mapper.writeValueAsString(goodsList));

            List<Order> orders = mapper.readValue(cartOrders.get(0).getOrderlist(),
                                    new TypeReference<List<Order>>() {});

            orders.add(order);

            cartOrders.get(0).setCartlist("[]");
            cartOrders.get(0).setOrderlist(mapper.writeValueAsString(orders));

            userCartOrderMapper.updateByPrimaryKey(cartOrders.get(0));

            resp.setResult(order);
        } catch (Exception e) {
            resp.setStatus(1);
            resp.setMsg(e.getMessage());

            return resp;
        }

        return resp;
    }

    public Resp<List<Order>> listOrder(String userId) {
        Resp<List<Order>> resp = new Resp<>();

        if (StringUtils.isEmpty(userId)) {
            resp.setStatus(1);
            resp.setMsg("未登录");

            return resp;
        }

        UserCartOrderExample select = new UserCartOrderExample();
        select.createCriteria().andUseridEqualTo(userId);
        List<UserCartOrderWithBLOBs> cartOrders =
            userCartOrderMapper.selectByExampleWithBLOBs(select);

        ObjectMapper mapper = new ObjectMapper();

        try {
            List<Order> orders = mapper.readValue(cartOrders.get(0).getOrderlist(),
                new TypeReference<List<Order>>() {});

            resp.setResult(orders);
            resp.setCount(orders.size());
        } catch (Exception e) {
            resp.setStatus(1);
            resp.setMsg(e.getMessage());
        }

        return resp;
    }

    public Resp<String> delOrder(String userId, DelOrderRequest request) {
        Resp<String> resp = new Resp<>();

        if (StringUtils.isEmpty(userId)) {
            resp.setStatus(1);
            resp.setMsg("未登录");

            return resp;
        }

        if (StringUtils.isEmpty(request.getOrderId())) {
            resp.setStatus(1);
            resp.setMsg("缺少订单号");

            return resp;
        }

        UserCartOrderExample select = new UserCartOrderExample();
        select.createCriteria().andUseridEqualTo(userId);
        List<UserCartOrderWithBLOBs> cartOrders =
            userCartOrderMapper.selectByExampleWithBLOBs(select);

        ObjectMapper mapper = new ObjectMapper();

        try {
            List<Order> orders = mapper.readValue(cartOrders.get(0).getOrderlist(),
                new TypeReference<List<Order>>() {});

            for (Order order : orders) {
                if (order.getOrderId().equals(request.getOrderId())) {
                    orders.remove(order);
                    break;
                }
            }

            cartOrders.get(0).setOrderlist(mapper.writeValueAsString(orders));

            userCartOrderMapper.updateByPrimaryKey(cartOrders.get(0));
            resp.setResult("suc");
        } catch (Exception e) {
            resp.setStatus(1);
            resp.setMsg(e.getMessage());
        }

        return resp;
    }
}
