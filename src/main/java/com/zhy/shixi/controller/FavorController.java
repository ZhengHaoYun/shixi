package com.zhy.shixi.controller;

import com.zhy.shixi.dao.FavorDAO;
import com.zhy.shixi.dao.UserDAO;
import com.zhy.shixi.pojo.Favor;
import com.zhy.shixi.pojo.Position;
import com.zhy.shixi.pojo.User;
import com.zhy.shixi.service.FavorService;
import com.zhy.shixi.service.UserService;
import com.zhy.shixi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by HeyYun
 * Date 2019/10/13
 */
@RestController
public class FavorController {
    @Autowired
    FavorService favorService;

    @GetMapping("/favors")
    public Result listByUser(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return Result.success(favorService.listByUser(user));
    }


    @PostMapping("/favors")
    public Result add(@RequestBody Favor favor) {
        favorService.add(favor);
        return Result.success();
    }

    @RequestMapping("/cancel")
    public Result delete(@RequestBody Favor favor){
        Favor favor1 = favorService.getByPositionAndUser(favor.getPosition(), favor.getUser());
        System.out.println(favor1.getUser().getEmail());
        favorService.delete(favor1);
        return Result.success();
    }
}
