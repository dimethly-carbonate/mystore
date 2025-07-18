package com.dmc.mystore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmc.mystore.entity.Customer;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper extends BaseMapper<Customer> {
    Page<Customer> findPage(Page<Customer> page, @Param("cusName") String cusName);

    public Integer userNameValidate();

    public Integer salerValidate();
}
