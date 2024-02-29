package com.yanzhen.controller;


import com.yanzhen.util.R;
import com.github.pagehelper.PageInfo;
import com.yanzhen.model.TypeInfo;
import com.yanzhen.service.ITypeService;
import com.yanzhen.util.JsonObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 社团分类和介绍 前端控制器
 * @author niuniu
 * @since 2024-02-17
 */
@Data
@Api(tags = {"社团分类和介绍"})
@RequestMapping("/typeInfo")
@RestController
@CrossOrigin
public class TypeController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private ITypeService typeService;

    /**
     * 分页高级查询
     */
    @CrossOrigin
    @RequestMapping("/queryTypeList")
    public JsonObject queryTypeList(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "15") Integer limit,
                                    String name){
        //创建对象模型
        JsonObject object=new JsonObject();

        //包装对象
        TypeInfo info=new TypeInfo();
        info.setName(name);

        //获取结果集
        PageInfo<TypeInfo> pageInfo = typeService.queryTypeList(page,limit,info);
        object.setCode(20000);
        object.setTotal(pageInfo.getTotal());
        object.setData(pageInfo.getList());
        return object;
    }

    @ApiOperation(value = "新增社团分类和介绍")
    @RequestMapping("/addInfo")
//    @CrossOrigin
    public R add(@RequestBody TypeInfo typeInfo){
        //新增后的返回参数  如果是1 成功 0 失败
        int num= typeService.add(typeInfo);
        if(num>0){
            return R.ok();
        }
        return R.fail("类型添加失败");
    }


    @ApiOperation(value = "删除社团分类和介绍")
    @RequestMapping(value = "/updateInfo")
    public R update(@RequestBody TypeInfo typeInfo){
        int num =typeService.updateData(typeInfo);
        if (num>0){
            return R.ok();
        }
        return R.fail("修改失败");
    }
}
