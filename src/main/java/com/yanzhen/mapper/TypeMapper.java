package com.yanzhen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yanzhen.model.TypeInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("typeDao")
public interface TypeMapper extends BaseMapper<TypeInfo> {

    /**
     * 支持高级查询
     */
    List<TypeInfo> queryTypeList(TypeInfo info);
}
