package com.dmc.mystore.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dmc.mystore.entity.Product;

public interface IProductService extends IService<Product> {

    Page<Product> findPage(Page<Product> page, String name,String psort);



}
