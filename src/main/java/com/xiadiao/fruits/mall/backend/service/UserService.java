package com.xiadiao.fruits.mall.backend.service;

import com.xiadiao.fruits.mall.backend.dao.UsersMapper;
import com.xiadiao.fruits.mall.backend.module.LoginRequest;
import com.xiadiao.fruits.mall.backend.module.RegisterRequest;
import com.xiadiao.fruits.mall.backend.module.Resp;
import com.xiadiao.fruits.mall.backend.model.Users;
import com.xiadiao.fruits.mall.backend.model.UsersExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UsersMapper usersMapper;

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

        resp.setData(users.get(0));

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
        user.setAvatar("");
        user.setUsername(request.getUserName());
        user.setUserpwd(request.getUserPwd());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setNickname(request.getNickName());
        user.setRealname(request.getRealName());

        usersMapper.insert(user);

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

        resp.setData(users.get(0));

        return resp;
    }
}
