package com.dmc.mystore.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dmc.mystore.entity.Outstorage;
import com.dmc.mystore.mapper.OutMapper;
import com.dmc.mystore.service.IOutService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OutServiceImpl extends ServiceImpl<OutMapper, Outstorage> implements IOutService {

    @Resource
    private OutMapper outMapper;

    @Override
    public Page<Outstorage> findPage(Page<Outstorage> page, String outId, String outOper,String outCustomer, String startTime, String endTime) {
        return outMapper.findPage(page,outId,outOper,outCustomer,startTime,endTime);

    }

    @Override
    public Page<Outstorage> findPage1(Page<Outstorage> page, String startTime, String endTime) {
        return outMapper.findPage1(page,startTime,endTime);
    }

    @Override
    public Double sumByToday() {
        return outMapper.sumByToday();
    }
    @Override
    public Double sumByPaid() {
        return outMapper.sumByPaid();
    }
    @Override
    public int saleValidate() {
        Integer Validate ;

        Validate = outMapper.totalsale();

        if(Validate == null)
            return 0;
        return Validate.intValue();
    }
}
