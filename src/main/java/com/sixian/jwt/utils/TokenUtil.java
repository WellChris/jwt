package com.sixian.jwt.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.sixian.jwt.pojo.User;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: ${WM}
 * @Date: 2019/1/31 15:01
 * @Description: token生成
 */
public class TokenUtil {
    /**
     * jwt token 生成
     * Signature
     * jwt的第三部分是一个签证信息，这个签证信息由三部分组成：
     * header (base64后的)
     * payload (base64后的)
     * secret
     * 这个部分需要base64加密后的header和base64加密后的payload使用.连接组成的字符串，
     * 然后通过header中声明的加密方式进行加盐secret组合加密，然后就构成了jwt的第三部分。
     *
     * @param user
     * @return eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxIn0.qfd0G-elhE1aGr15LrnYlIZ_3UToaOM5HeMcXrmDGBM
     *
     *          eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxIn0.qfd0G-elhE1aGr15LrnYlIZ_3UToaOM5HeMcXrmDGBM
     *          withExpiresAt 设置过期时间 360000
     *
     *          .withHeader(map)
     */
    public static String getToken(User user) {
//        Map<String, Object> map = new HashMap();
//        map.put("alg", "HS256");
//        map.put("typ", "JWT");
        String token="";
        token= JWT.create().withAudience(user.getId())
                .withExpiresAt(new Date(System.currentTimeMillis()+6000))
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setId("1");
        user.setPassword("123456");
        System.out.println(getToken(user));
    }
}
