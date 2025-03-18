package com.oceanstar.service.impl;

import com.oceanstar.Pojo.User1;
import com.oceanstar.mapper.usermapper;
import com.oceanstar.service.userService;
import org.springframework.stereotype.Service;

//将这个类交给ioc容器管理
@Service
public class userServiceimpl implements userService {
    private final usermapper usermapper;

    public userServiceimpl(usermapper usermapper) {
        this.usermapper = usermapper;
    }

    @Override
    public void add(User1 user1){
//        1.补全属性
        user1.setId(0);

//        2.调用mapper接口
        usermapper.insert(user1);
    }
}
