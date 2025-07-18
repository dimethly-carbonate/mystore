package com.dmc.mystore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dmc.mystore.entity.Role;

import java.util.List;

public interface IRoleService extends IService<Role> {
    void setRoleMenu(Integer roleId, List<Integer> menuIds);

    List<Integer> getRoleMenu(Integer roleId);
}
