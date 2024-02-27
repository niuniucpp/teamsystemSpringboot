package com.yanzhen.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("type_info")
public class TypeInfo {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String remarks;
}
