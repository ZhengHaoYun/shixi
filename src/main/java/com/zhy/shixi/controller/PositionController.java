package com.zhy.shixi.controller;

import com.zhy.shixi.pojo.Company;
import com.zhy.shixi.pojo.Position;
import com.zhy.shixi.pojo.User;
import com.zhy.shixi.service.PositionService;
import com.zhy.shixi.util.Page4Navigator;
import com.zhy.shixi.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by HeyYun
 * Date 2019/10/9
 */
@RestController
public class PositionController {

    @Autowired
    PositionService positionService;

    @GetMapping("/positionsByPage")
    public Result list(@RequestParam(defaultValue = "0", value = "start") int start,
                       @RequestParam(defaultValue = "5", value = "size") int size) {
        start = start < 0 ? 0 : start;
        Page4Navigator<Position> page = positionService.list(start, size, 5);
        return Result.success(page);
    }

    @GetMapping("/positions")
    public Result list() {
        List<Position> positions = positionService.list();
        return Result.success(positions);
    }

    @GetMapping("/positions/{cid}")
    public Result list(@PathVariable("cid") int cid, @RequestParam(defaultValue = "0", value = "start") int start,
                       @RequestParam(defaultValue = "5", value = "size") int size) {
        start = start < 0 ? 0 : start;
        Page4Navigator<Position> page = positionService.listByCategory(cid, start, size, 5);
        return Result.success(page);
    }

    @GetMapping("/position/{pid}")
    public Result get(@PathVariable("pid") int pid, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Position position = positionService.get(pid);
        boolean isFavor = positionService.isFavor(position,user);
        position.setFavor(isFavor);
        return Result.success(position);
    }


}
