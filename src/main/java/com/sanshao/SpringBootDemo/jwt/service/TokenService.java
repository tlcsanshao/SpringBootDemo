package com.sanshao.SpringBootDemo.jwt.service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.sanshao.SpringBootDemo.jwt.model.User;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;


@Service("TokenService")
public class TokenService {
    public String getToken(User user) {
        String token="";
        try {
            token= JWT.create().withExpiresAt(new Date((new Date().getTime()+60000l)))
                    .withAudience(user.getId()+"")// 将 user id 保存到 token 里面
                    .sign(Algorithm.HMAC256(user.getPassword()));// 以 password 作为 token 的密钥
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return token;
    }
}