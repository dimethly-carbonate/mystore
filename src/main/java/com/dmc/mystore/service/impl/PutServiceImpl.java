package com.dmc.mystore.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dmc.mystore.entity.Putstorage;
import com.dmc.mystore.mapper.PutMapper;
import com.dmc.mystore.service.IPutService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PutServiceImpl extends ServiceImpl<PutMapper, Putstorage> implements IPutService {

    @Resource
    private PutMapper putMapper;

    @Override
    public Page<Putstorage> findPage(Page<Putstorage> page, String putId, String putOper, String startTime, String endTime) {
        return putMapper.findPage(page,putId,putOper,startTime,endTime);

    }
    @Override
    public Double sumByToday() {
        return putMapper.sumByToday();
    }
    @Override
    public int saleValidate() {
        Integer Validate ;

        Validate = putMapper.totalput();

        if(Validate == null)
            return 0;
        return Validate.intValue();
    }
//    @Override
//    public Page<Putstorage> findPage(Page<Putstorage> page, String putId) {
//        return putMapper.findPage(page,putId);
//
//    }
}
