package com.dmc.mystore.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dmc.mystore.entity.Putstorage;

public interface IPutService extends IService<Putstorage> {

    Page<Putstorage> findPage(Page<Putstorage> page, String putId,String putOper, String startTime,String endTime);
    Double sumByToday();
    int saleValidate();

}
