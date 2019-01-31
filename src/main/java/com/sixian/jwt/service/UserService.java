package com.sixian.jwt.service;

import com.sixian.jwt.pojo.User;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * @Auther: ${WM}
 * @Date: 2019/1/31 15:16
 * @Description: 这里不直接访问数据库
 */
@Service
public class UserService {

    public  User findUserById (String id){
        User user = new User();
        user.setId("1");
        user.setPassword("123456");
//        Optional<User> optional =Optional.ofNullable(user);
//        return optional.map(temp->{if(temp.getId()==id){return  temp;}return null;}).orElse(null);
        if ("1".equals(id)){
            return user;
        }
        return null;
    }
    public  User findByUsername (User user){
        User user2 = new User();
        user2.setId("1");
        user2.setPassword("123456");
        user2.setUsername("wsx");
       if("wsx".equals(user.getUsername())){
           return user2;
       }
        return null;
    }


//    public static void main(String[] args) {
//        System.out.println(findUserById("1"));
//    }
}
