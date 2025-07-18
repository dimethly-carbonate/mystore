package com.dmc.mystore.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmc.mystore.common.Result;
import com.dmc.mystore.entity.Unit;
import com.dmc.mystore.mapper.UnitMapper;
import com.dmc.mystore.service.IUnitService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/unit")
public class UnitController {
    @Resource
    private IUnitService unitService;

    @Resource
    private UnitMapper unitMapper;
    // 新增或者更新
    @PostMapping
    public Result save(@RequestBody Unit unit) {
        unitService.saveOrUpdate(unit);
        return Result.success();
    }

    @DeleteMapping("/{unitsid}")
    public Result delete(@PathVariable Integer unitsid) {
        unitService.removeById(unitsid);
        return Result.success();
    }

    @PostMapping("/del/batch")
    public Result deleteBatch(@RequestBody List<Integer> unitsids) {
        unitService.removeByIds(unitsids);
        return Result.success();
    }


    @GetMapping
    public Result findAll(@RequestParam(defaultValue = "") String unitname) {


        return Result.success(unitService.findUnits(unitname));
    }

    @GetMapping("/{unitsid}")
    public Result findOne(@PathVariable Integer unitsid) {
        return Result.success(unitService.getById(unitsid));
    }

    //分页查询——mybatis-plus的方式查询
    @GetMapping("/page")
    public  Result findPage(@RequestParam Integer pageNum,
                            @RequestParam Integer pageSize,
                            @RequestParam(defaultValue = "") String unitname



    ) {
        IPage<Unit> page=new Page<>(pageNum,pageSize);
        QueryWrapper<Unit> queryWrapper=new QueryWrapper<>();
        if (!"".equals(unitname)){
            queryWrapper.like("unitname",unitname);
        }

        queryWrapper.orderByDesc("unitsid");
        return Result.success(unitService.page(page,queryWrapper));
    }


}
