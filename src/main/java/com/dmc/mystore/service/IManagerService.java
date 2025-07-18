package com.dmc.mystore.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dmc.mystore.controller.dto.ManagerDTO;
import com.dmc.mystore.controller.dto.UserPasswordDTO;
import com.dmc.mystore.entity.Manager;

public interface IManagerService extends IService<Manager> {
    ManagerDTO login(ManagerDTO managerDTO);
    void updatePassword(UserPasswordDTO userPasswordDTO);
    Page<Manager> findPage(Page<Manager> objectPage);
    Page<Manager> findPage1(Page<Manager> objectPage);
    Page<Manager> findPage2(Page<Manager> objectPage);



}
