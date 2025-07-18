package com.dmc.mystore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmc.mystore.entity.Putstorage;

public interface PutMapper extends BaseMapper<Putstorage> {
    Page<Putstorage> findPage(Page<Putstorage> page, String putId, String putOper, String startTime, String endTime);

    Double sumByToday();

    public Integer totalput();
}
