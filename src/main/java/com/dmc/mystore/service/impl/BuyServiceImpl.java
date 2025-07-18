package com.dmc.mystore.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dmc.mystore.entity.Buy;
import com.dmc.mystore.mapper.BuyMapper;
import com.dmc.mystore.service.IBuyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BuyServiceImpl extends ServiceImpl<BuyMapper, Buy> implements IBuyService {

    @Resource
    private BuyMapper buyMapper;


    @Override
    public Page<Buy> findPage(Page<Buy> page, String buyid,String buyApply,String buyer, String buyName,String buyStatus,String startTime,String endTime) {
        return buyMapper.findPage(page,buyid, buyApply, buyer, buyName, buyStatus, startTime, endTime);

    }

    @Override
    public Page<Buy> findPage1(Page<Buy> page) {
        return buyMapper.findPage1(page);

    }


}
