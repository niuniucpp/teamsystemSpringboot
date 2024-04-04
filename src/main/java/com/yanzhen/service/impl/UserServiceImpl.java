package com.yanzhen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yanzhen.mapper.UserMapper;
import com.yanzhen.model.UserInfo;
import com.yanzhen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl
        extends ServiceImpl<UserMapper,UserInfo>
        implements UserService {


    @Autowired
    private UserMapper userDao;

    @Override
    public PageInfo<UserInfo> queryUserByPage(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<UserInfo> list = userDao.selectList(null);
        PageInfo<UserInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
