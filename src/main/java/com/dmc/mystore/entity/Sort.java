package com.dmc.mystore.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@TableName("fl_sort")
@Data
public class Sort {

    @ApiModelProperty("类别编号")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("类别名称")
    private String sortname;

    @TableField(exist = false)
    private List<Product> products;
}
