package com.dmc.mystore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmc.mystore.entity.Outstorage;

public interface OutMapper extends BaseMapper<Outstorage> {
    Page<Outstorage> findPage(Page<Outstorage> page, String outId, String outOper, String outCustomer,String startTime, String endTime);

    Double sumByToday();

    public Integer totalsale();

    Double sumByPaid();

    Page<Outstorage> findPage1(Page<Outstorage> page, String startTime, String endTime);
}
