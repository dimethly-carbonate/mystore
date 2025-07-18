package com.dmc.mystore.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dmc.mystore.entity.Sale;
import com.dmc.mystore.mapper.SaleMapper;
import com.dmc.mystore.service.ISaleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SaleServiceImpl extends ServiceImpl<SaleMapper, Sale> implements ISaleService {

    @Resource
    private SaleMapper saleMapper;

    @Override
    public Page<Sale> findPage(Page<Sale> page, String saleId) {
        return saleMapper.findPage(page,saleId);

    }

    @Override
    public Page<Sale> findPage1(Page<Sale> page, String saleId, String saler,String reviewer,String results,String startTime,String endTime) {
        return saleMapper.findPage1(page,saleId,saler,reviewer,results,startTime,endTime);

    }

    @Override
    public Page<Sale> findPage2(Page<Sale> page) {
        return saleMapper.findPage2(page);
    }

}
