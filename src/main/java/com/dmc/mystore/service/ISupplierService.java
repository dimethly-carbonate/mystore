package com.dmc.mystore.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dmc.mystore.entity.Supplier;

public interface ISupplierService extends IService<Supplier> {

    Page<Supplier> findPage(Page<Supplier> page, String supName);
}
