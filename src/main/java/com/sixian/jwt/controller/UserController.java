package com.sixian.jwt.controller;

import com.sixian.jwt.config.UserLoginToken;
import com.sixian.jwt.pojo.User;
import com.sixian.jwt.service.UserService;
import com.sixian.jwt.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: ${WM}
 * @Date: 2019/1/31 14:58
 * @Description:
 */
@RestController
@RequestMapping("api")
/**
 * 1.登录接口
 * 2.登录后的接口
 */
public class UserController {
    @Autowired
    private UserService userService;
    //登录
    @PostMapping("/login")
    public Object login(@RequestBody User user){
        Map map =new HashMap();
        User userForBase=userService.findByUsername(user);
        if(userForBase==null){
            map.put("message","登录失败,用户不存在");
            return map;
        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
                map.put("message","登录失败,密码错误");
                return map;
            }else {
                String token = TokenUtil.getToken(userForBase);
                map.put("token", token);
                map.put("user", userForBase);
                return map;
            }
        }
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public Object getMessage(){
        Map map =new HashMap();
        map.put("info", "你已通过验证");
        return map;
    }
}
