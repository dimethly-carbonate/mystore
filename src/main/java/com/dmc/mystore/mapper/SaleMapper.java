package com.dmc.mystore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmc.mystore.entity.Sale;

public interface SaleMapper extends BaseMapper<Sale> {
     Page<Sale> findPage(Page<Sale> page, String saleId);

     Page<Sale> findPage1(Page<Sale> page, String saleId,String saler,String reviewer ,String results ,String startTime,String endTime);

     Page<Sale> findPage2(Page<Sale> page);
}