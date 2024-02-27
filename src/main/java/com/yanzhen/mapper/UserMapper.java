package com.yanzhen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yanzhen.model.UserInfo;
import org.springframework.stereotype.Component;

@Component("userDao")
public interface UserMapper extends BaseMapper<UserInfo> {
}
