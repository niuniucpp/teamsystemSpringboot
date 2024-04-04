package com.yanzhen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.yanzhen.model.UserInfo;

public interface UserService extends IService<UserInfo>{

    /**
     * 分页查询
     */
    PageInfo<UserInfo> queryUserByPage(int page,int limit);
}
