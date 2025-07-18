package com.dmc.mystore.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dmc.mystore.entity.Menu;
import com.dmc.mystore.entity.Role;
import com.dmc.mystore.entity.RoleMenu;
import com.dmc.mystore.mapper.RoleMapper;
import com.dmc.mystore.mapper.RoleMenuMapper;
import com.dmc.mystore.service.IMenuService;
import com.dmc.mystore.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Resource
    private IMenuService menuService;

    @Transactional
    @Override
    public void setRoleMenu(Integer roleId, List<Integer> menuIds) {

        //先删除当前角色id所有的绑定关系
        roleMenuMapper.deleteByRoleId(roleId);

        //再把前端传过来的菜单id数组绑定到当前的这个角色id上去
        List<Integer> menuIdCopy= CollUtil.newArrayList(menuIds);
        for (Integer menuId : menuIds){


            Menu menu= menuService.getById(menuId);
            if (menu.getPid() != null && !menuIdCopy.contains(menu.getPid())){//二级菜单  并且传过来的menuId数组里面没有它的父级id
                //那么我们就得补上这个父级id
                RoleMenu roleMenu= new RoleMenu();
                roleMenu.setRoleId(roleId);
                roleMenu.setMenuId(menu.getPid());
                roleMenuMapper.insert(roleMenu);
                menuIdCopy.add(menu.getPid());

            }
            RoleMenu roleMenu= new RoleMenu();
            roleMenu.setRoleId(roleId);
            roleMenu.setMenuId(menuId);
            roleMenuMapper.insert(roleMenu);
        }
    }

    @Override
    public List<Integer> getRoleMenu(Integer roleId) {
        return roleMenuMapper.selectByRoleId(roleId);
    }
}
