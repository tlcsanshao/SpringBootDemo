package com.sanshao.SpringBootDemo.jwt.controller;

import com.alibaba.fastjson.JSONObject;
import com.sanshao.SpringBootDemo.jwt.annotation.UserLoginToken;
import com.sanshao.SpringBootDemo.jwt.model.User;
import com.sanshao.SpringBootDemo.jwt.service.TokenService;
import com.sanshao.SpringBootDemo.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class JwtUserController {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;

    @PostMapping("/register")
    public Object register(@RequestBody User user){
        JSONObject jsonObject = new JSONObject();
        User userForBase = userService.getUserByUsername(user);
        if(userForBase != null){
            jsonObject.put("message", "用户名已存在");
            return jsonObject;
        } else {
            userService.addUser(user);
            jsonObject.put("message", "添加成功");
            jsonObject.put("user", userForBase);
            return jsonObject;

        }
    }


    //登录
    @PostMapping("/login")
    public Object login(@RequestBody User user) {
        JSONObject jsonObject = new JSONObject();
        User userForBase = userService.getUserByUsername(user);
        if (userForBase == null) {
            jsonObject.put("message", "登录失败,用户不存在");
            return jsonObject;
        } else {
            if (!userForBase.getPassword().equals(user.getPassword())) {
                jsonObject.put("message", "登录失败,密码错误");
                return new ResponseEntity(HttpStatus.UNAUTHORIZED);
            } else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }

//    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {
        return "你已通过验证";
    }
}