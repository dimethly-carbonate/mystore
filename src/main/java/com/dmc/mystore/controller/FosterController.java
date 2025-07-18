package com.dmc.mystore.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmc.mystore.common.Result;
import com.dmc.mystore.entity.Foster;
import com.dmc.mystore.service.IFosterService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/foster")
public class FosterController {

    @Resource
    private IFosterService fosterService;


    //新增和修改
    @PostMapping
    public Result save(@RequestBody Foster foster){
        //新增或者更新
        return Result.success(fosterService.saveOrUpdate(foster));

    }
    //查询所有数据
    @GetMapping("/")
    public Result findAll() {
        return Result.success(fosterService.list());
    }
    //删除数据
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return Result.success( fosterService.removeById(id));
    }

    //批量删除
    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {

        return Result.success(fosterService.removeByIds(ids));
    }

    //分页查询——mybatis-plus的方式查询
    @GetMapping("/page")
    public  Result findPage(@RequestParam(defaultValue = "") String phone,
                            @RequestParam(defaultValue = "") String fosName,
                            @RequestParam String startTime,
                            @RequestParam(defaultValue = "") String fosOper,
                            @RequestParam(defaultValue = "") String fosStatus,
                            @RequestParam Integer pageNum,
                            @RequestParam Integer pageSize
    ) {

        Page<Foster> page=fosterService.findPage(new Page<>(pageNum,pageSize), phone,fosName,startTime,fosOper,fosStatus);

        return Result.success(page);
    }}






