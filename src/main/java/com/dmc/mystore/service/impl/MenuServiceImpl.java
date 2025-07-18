package com.dmc.mystore.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dmc.mystore.entity.Menu;
import com.dmc.mystore.mapper.MenuMapper;
import com.dmc.mystore.service.IMenuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    @Override
    public List<Menu> findMenus(String name) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        if(StrUtil.isNotBlank(name)){
            queryWrapper.like("name", name);
            queryWrapper.orderByDesc("id");
        }

        //查询所有数据
        List<Menu> list= list(queryWrapper);
        //找出pid为null的一级菜单
        List<Menu> parentNodes= list.stream().filter(menu -> menu.getPid() == null).collect(Collectors.toList());
        //找出一级菜单的子菜单
        for (Menu menu : parentNodes){
            //筛选所有数据中pid=父级id的数据就是二级菜单
            menu.setChildren(list.stream().filter(menu1 -> menu.getId().equals(menu1.getPid())).collect(Collectors.toList()));
        }
        return parentNodes;
    }
}
