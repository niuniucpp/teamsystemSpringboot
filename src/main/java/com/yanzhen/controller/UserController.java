package com.yanzhen.controller;

import com.github.pagehelper.PageInfo;
import com.yanzhen.model.UserInfo;
import com.yanzhen.service.IUserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("queryUserList")
    public List<UserInfo> queryUserList(){
        List<UserInfo> list = userService.list();
        return list;
    }

    /**
     * 新增
     * @return
     */
    @RequestMapping("/inserUserInfo")
    public String inserUserInfo(){
        UserInfo info = new UserInfo();
        info.setUsername("niuniu");
        info.setPassword("123456");
        boolean br = userService.save(info);
        if (br){
            return "ok";
        }else {
            return "no";
        }

    }
    /**
     * 测试分页效果
     */
    @RequestMapping("/queryListByPage")
    public List<UserInfo> queryListByPage(){
        PageInfo pageInfo = userService.queryUserByPage(2,2);
        return pageInfo.getList();
    }
}
