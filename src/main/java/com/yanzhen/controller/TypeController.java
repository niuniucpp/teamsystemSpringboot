package com.yanzhen.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yanzhen.util.R;
import com.github.pagehelper.PageInfo;
import com.yanzhen.model.TypeInfo;
import com.yanzhen.service.TypeService;
import com.yanzhen.util.JsonObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
    private TypeService typeService;

    /**
     * 分页高级查询
     */
    @ApiOperation(value = "分页查询社团信息")
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
    public R addType(@RequestBody TypeInfo typeInfo){
        //新增后的返回参数  如果是1 成功 0 失败
        int num= typeService.add(typeInfo);
        if(num>0){
            return R.ok();
        }
        return R.fail("类型添加失败");
    }


    @ApiOperation(value = "删除社团分类和介绍")
    @RequestMapping(value = "/deleteInfo")
    public R deleteType(long id){
        int num =typeService.delete(id);
        if (num > 0){
            return R.ok();
        }
        return R.fail("删除失败！！");
    }

    @ApiOperation(value = "在线编辑社团的信息")
    @CrossOrigin
    @PostMapping(value = "/updataInfo")
    public R updataType(@RequestBody TypeInfo typeInfo) {
        int num = typeService.updateData(typeInfo);
        if (num > 0) {
            return R.ok();
        }
        return R.fail("修改失败！！！");
    }

    @ApiOperation(value = "查询社团分类和介绍分页数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<TypeInfo> findListByPage(@RequestParam Integer page,
                                          @RequestParam Integer pageCount){
        return typeService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询社团分类和介绍")
    @GetMapping("{id}")
    public TypeInfo findById(@PathVariable Long id){
        return typeService.findById(id);
    }
}
