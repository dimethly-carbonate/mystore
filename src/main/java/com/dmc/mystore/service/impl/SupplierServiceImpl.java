package com.dmc.mystore.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dmc.mystore.entity.Supplier;
import com.dmc.mystore.mapper.SupplierMapper;
import com.dmc.mystore.service.ISupplierService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier> implements ISupplierService {

    @Resource
    private SupplierMapper supplierMapper;


    @Override
    public Page<Supplier> findPage(Page<Supplier> page, String supName) {
        return supplierMapper.findPage(page,supName);

    }
}
