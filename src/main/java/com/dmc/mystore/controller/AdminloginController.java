package com.dmc.mystore.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmc.mystore.common.Result;
import com.dmc.mystore.entity.Adminlogin;
import com.dmc.mystore.service.IAdminloginService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/adminlogin")
public class AdminloginController {

    @Resource
    private IAdminloginService adminloginService;


    //新增和修改
    @PostMapping
    public Result save(@RequestBody Adminlogin adminlogin) {
        //新增或者更新
        return Result.success(adminloginService.saveOrUpdate(adminlogin));

    }

    //查询所有数据
    @GetMapping("/")
    public Result findAll() {
        return Result.success(adminloginService.list());
    }


    //分页查询——mybatis-plus的方式查询
    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize

    ) {
        IPage<Adminlogin> page = new Page<>(pageNum, pageSize);
        QueryWrapper<Adminlogin> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("id");
        return Result.success(adminloginService.page(page, queryWrapper));
    }
}
