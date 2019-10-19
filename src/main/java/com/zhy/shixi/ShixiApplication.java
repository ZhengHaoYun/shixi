package com.zhy.shixi;

import com.zhy.shixi.util.PortUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ShixiApplication {
    //检查redis服务器是否启动
//    static {
//        PortUtil.checkPort(6379, "Redis 服务端", true);
//    }

    public static void main(String[] args) {

        SpringApplication.run(ShixiApplication.class, args);
    }

}
