package com.yanzhen.controller;

//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class TestController {
    /**
     * 测试案例
     * 在页面上输出打印 一句话
     */
    @RequestMapping("/hello")
    public String hello(){
        return "正在使用springboot！！！";
    }
}
