package com.zhy.shixi.controller;

import com.zhy.shixi.pojo.User;
import com.zhy.shixi.service.UserService;
import com.zhy.shixi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by HeyYun
 * Date 2019/10/12
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{userId}")
    public Result get(@PathVariable("userId") int userId) {
        if (null == userService.get(userId)) {
            return Result.fail("该用户不存在！");
        }
        return Result.success(userService.get(userId));
    }

    @PutMapping("/user")
    public Result update(@RequestBody User user) {
        userService.update(user);
        return Result.success("修改成功！");
    }
}
