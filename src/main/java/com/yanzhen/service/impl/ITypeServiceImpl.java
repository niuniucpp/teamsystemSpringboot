package com.yanzhen.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yanzhen.mapper.TypeMapper;
import com.yanzhen.model.TypeInfo;
import com.yanzhen.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class ITypeServiceImpl extends ServiceImpl<TypeMapper, TypeInfo> implements ITypeService {

    @Autowired
    private TypeMapper typeDao;

    @Override
    public IPage<TypeInfo> findListByPage(Integer page, Integer pageCount) {
        return null;
    }

    @Override
    public int add(TypeInfo typeInfo) {
        return baseMapper.insert(typeInfo);
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public int updateData(TypeInfo typeInfo) {
        return 0;
    }

    @Override
    public TypeInfo findById(Long id) {
        return null;
    }

    @Override
    public PageInfo<TypeInfo> queryTypeList(int page, int pageSize, TypeInfo info) {
        PageHelper.startPage(page,pageSize);
        //获取查询到的结果
        List<TypeInfo> list = typeDao.queryTypeList(info);
        PageInfo<TypeInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
