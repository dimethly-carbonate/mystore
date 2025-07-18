package com.dmc.mystore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dmc.mystore.entity.Unit;

import java.util.List;

public interface IUnitService extends IService<Unit> {
    List<Unit> findUnits(String unitname);
}
