package com.dmc.mystore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmc.mystore.entity.Foster;

public interface FosterMapper extends BaseMapper<Foster> {


    Page<Foster> findPage(Page<Foster> page, String phone, String fosName, String startTime, String fosOper, String fosStatus);
}
