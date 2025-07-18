package com.dmc.mystore.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmc.mystore.common.Constants;
import com.dmc.mystore.common.Result;
import com.dmc.mystore.controller.dto.ManagerDTO;
import com.dmc.mystore.controller.dto.UserPasswordDTO;
import com.dmc.mystore.entity.Manager;
import com.dmc.mystore.mapper.ManagerMapper;
import com.dmc.mystore.service.IManagerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Resource
    private IManagerService managerService;
    @Resource
    private ManagerMapper managerMapper;

    @PostMapping("/login")
    public Result login(@RequestBody ManagerDTO managerDTO){
        String adname=managerDTO.getAdname();
        String adpwd=managerDTO.getAdpwd();
        if (StrUtil.isBlank(adname) || StrUtil.isBlank(adpwd)){
            return Result.error(Constants.CODE_400,"参数错误");
        }
        ManagerDTO dto = managerService.login(managerDTO);
        return Result.success(dto);

    }
//修改密码
    @PostMapping("/password")
    public Result password(@RequestBody UserPasswordDTO userPasswordDTO) {
        managerService.updatePassword(userPasswordDTO);
        return Result.success();
    }
    //新增和修改
    @PostMapping
    public Result save(@RequestBody Manager manager){
        //新增或者更新
        return Result.success(managerService.saveOrUpdate(manager));

    }
    @GetMapping("/adname/{adname}")
    public Result findOne(@PathVariable String adname){
        QueryWrapper<Manager> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("adname",adname);
        return Result.success(managerService.getOne(queryWrapper));
    }

    //查询所有数据
    @GetMapping("/")
    public Result findAll() {
        return Result.success(managerService.list());
    }



    //查询身份为采购员的用户
    @GetMapping("/flagisbuy")
    public  Result findPage(@RequestParam Integer pageNum,
                            @RequestParam Integer pageSize

    ) {
        return Result.success(
                managerService.findPage(new Page<>(pageNum,pageSize)));
    }

    //查询身份为管理员的用户
    @GetMapping("/flagisadmin")
    public  Result findPage1(@RequestParam Integer pageNum,
                            @RequestParam Integer pageSize

    ) {
        return Result.success(
                managerService.findPage1(new Page<>(pageNum,pageSize)));
    }
    //查询身份为销售员的用户
    @GetMapping("/flagissale")
    public  Result findPage2(@RequestParam Integer pageNum,
                             @RequestParam Integer pageSize

    ) {
        return Result.success(
                managerService.findPage2(new Page<>(pageNum,pageSize)));
    }
    //新增和修改
    @PostMapping("/update")
    public Result update(@RequestBody Manager manager){
        //新增或者更新
        return Result.success(managerMapper.updateById(manager));

    }
    //删除数据
    @DeleteMapping("/{adid}")
    public Result delete(@PathVariable Integer adid){
        Manager manager= managerMapper.selectById(adid);
        manager.setIsDelete(true);
        managerMapper.updateById(manager);
        return Result.success();
    }


    //分页查询——mybatis-plus的方式查询
    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String adname


    ) {
        QueryWrapper<Manager> queryWrapper=new QueryWrapper<>();
        //查询未删除的记录
        queryWrapper.eq("is_delete",false);
        queryWrapper.orderByDesc("adid");

        if (!"".equals(adname)){
            queryWrapper.like("adname",adname);
        }
        return Result.success(managerMapper.selectPage(new Page<>(pageNum,pageSize),queryWrapper));
    }
    //分页查询
    //接口路径：/user/page?pageNum=1&pageSize=10
    //@RequestParam接收
//    @GetMapping("/page")
//    public  Map<String,Object> findPage(@RequestParam Integer pageNum,
//                                        @RequestParam Integer pageSize,
//                                        @RequestParam String adName) {
//        pageNum = (pageNum - 1) * pageSize;
//        List<Manager> data=managerMapper.selectpage(pageNum,pageSize,adName);
//        Integer total=managerMapper.selectTotal(adName);
//        Map<String,Object> res=new HashMap<>();
//        res.put("data",data);
//        res.put("total",total);
//        return res;
//    }


}
