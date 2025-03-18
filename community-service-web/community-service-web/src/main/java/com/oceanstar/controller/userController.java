package com.oceanstar.controller;

import com.oceanstar.Pojo.Result;
import com.oceanstar.Pojo.User1;
import com.oceanstar.service.userService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class userController {
    //注入service
    private final userService userService;
    //构造器注入
    public userController(userService userService) {
        this.userService = userService;
    }
    //注册
    @PostMapping("/user")
    public Result user(@RequestBody User1 user1){
        System.out.println("注册：" + user1);
        userService.add(user1);
        return Result.success();
    }

}
