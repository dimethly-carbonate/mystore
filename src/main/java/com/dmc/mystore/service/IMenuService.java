package com.dmc.mystore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dmc.mystore.entity.Menu;

import java.util.List;

public interface IMenuService extends IService<Menu> {
    List<Menu> findMenus(String name);
}
