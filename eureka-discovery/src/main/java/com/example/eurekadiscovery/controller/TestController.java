package com.example.eurekadiscovery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @description:
 * @author: lee
 * @create: 2019/03/09 13:52
 */
@RestController
public class TestController {
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() {
        String services = "Services: " + discoveryClient.getServices() + new Date().getTime();
        System.out.println(services);
        return services;
    }

    @GetMapping("/add")
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        System.out.println(a + b);
        return a + b;
    }

    @GetMapping("/stop")
    public String stop() throws InterruptedException {
        System.out.println("stop");
//        Thread.sleep(5000L);
        Thread.sleep(2000L);
        return "stop";
    }


}
