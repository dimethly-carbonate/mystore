package com.dmc.mystore.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dmc.mystore.entity.Foster;
import com.dmc.mystore.mapper.FosterMapper;
import com.dmc.mystore.service.IFosterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ForsterServiceImpl extends ServiceImpl<FosterMapper, Foster> implements IFosterService {

    @Resource private FosterMapper fosterMapper;

    @Override
    public Page<Foster> findPage(Page<Foster> page, String phone, String fosName, String startTime, String fosOper, String fosStatus) {
        return fosterMapper.findPage(page,phone, fosName, startTime, fosOper, fosStatus);

    }
}
