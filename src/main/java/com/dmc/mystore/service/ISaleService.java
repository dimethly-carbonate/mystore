package com.dmc.mystore.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dmc.mystore.entity.Sale;

public interface ISaleService extends IService<Sale> {

    Page<Sale> findPage(Page<Sale> page, String saleId);
    Page<Sale> findPage1(Page<Sale> page, String saleId,String saler, String reviewer,String results,String startTime,String endTime);
    Page<Sale> findPage2(Page<Sale> objectPage);
}
