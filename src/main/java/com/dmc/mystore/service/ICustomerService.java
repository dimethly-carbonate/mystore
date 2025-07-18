package com.dmc.mystore.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dmc.mystore.entity.Customer;

public interface ICustomerService extends IService<Customer> {
    Page<Customer> findPage(Page<Customer> page, String cusName);
    int nameValidate();
    int saleValidate();

}
