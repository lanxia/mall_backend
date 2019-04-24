package com.xiadiao.fruits.mall.backend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiadiao.fruits.mall.backend.dao.GoodsMapper;
import com.xiadiao.fruits.mall.backend.dao.UserCartOrderMapper;
import com.xiadiao.fruits.mall.backend.model.*;
import com.xiadiao.fruits.mall.backend.module.AddCartRequest;
import com.xiadiao.fruits.mall.backend.module.Resp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private UserCartOrderMapper userCartOrderMapper;


    public Resp<String> addCart(String userId, AddCartRequest request) {
        Resp<String> resp = new Resp<>();

        if (StringUtils.isEmpty(userId)) {
            resp.setStatus(1);
            resp.setMsg("用户未登录");

            return resp;
        }

        UserCartOrderExample query = new UserCartOrderExample();
        query.createCriteria().andUseridEqualTo(userId);

        List<UserCartOrderWithBLOBs> cartAndOrders =
            userCartOrderMapper.selectByExampleWithBLOBs(query);
        if (CollectionUtils.isEmpty(cartAndOrders)) {
            resp.setStatus(1);
            resp.setMsg("用户不存在");

            return resp;
        }

        UserCartOrderWithBLOBs cartAndGoods = cartAndOrders.get(0);
        String cartList = cartAndGoods.getCartlist();
        ObjectMapper mapper = new ObjectMapper();
        String productId = request.getProductId();
        Integer productNum = request.getProductNum() == null ? 1 : request.getProductNum();

        try {
            List<CartGoods> cartGoods = mapper.readValue(cartList,
                                            new TypeReference<List<CartGoods>>(){});

            Boolean have = false;
            if (!CollectionUtils.isEmpty(cartGoods)) {
                for (CartGoods good : cartGoods) {
                    if (good.getProductId().equals(productId)) {
                        good.setProductNum(good.getProductNum() + productNum);
                        have = true;
                        break;
                    }
                }
            }

            if (CollectionUtils.isEmpty(cartGoods) || !have) {
                GoodsExample goodsQuery = new GoodsExample();
                goodsQuery.createCriteria().andProductidEqualTo(productId);

                List<Goods> goods = goodsMapper.selectByExample(goodsQuery);
                if (CollectionUtils.isEmpty(goods)) {
                    resp.setStatus(1);
                    resp.setMsg("商品不存在");

                    return resp;
                }

                CartGoods cartGood = new CartGoods();
                cartGood.setProductName(goods.get(0).getProductname());
                cartGood.setChecked("1");
                cartGood.setProductId(goods.get(0).getProductid());
                cartGood.setProductImg(goods.get(0).getProductimagebig());
                cartGood.setProductPrice(goods.get(0).getSaleprice());
                cartGood.setProductNum(productNum);

                cartGoods.add(cartGood);
            }

            cartAndGoods.setCartlist(mapper.writeValueAsString(cartGoods));
            userCartOrderMapper.updateByPrimaryKeyWithBLOBs(cartAndGoods);

            resp.setMsg("加入成功");
            resp.setData("suc");
        } catch (IOException e) {
            resp.setStatus(1);
            resp.setMsg("购物和有误");

            return resp;
        }


        return resp;
    }

}
