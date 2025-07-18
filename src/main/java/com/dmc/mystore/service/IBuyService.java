package com.dmc.mystore.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dmc.mystore.entity.Buy;

public interface IBuyService extends IService<Buy> {

    Page<Buy> findPage(Page<Buy> page, String buyid ,String buyApply,String buyer,String buyName,String buyStatus,String startTime,String endTime);
    Page<Buy> findPage1(Page<Buy> objectPage);



}
