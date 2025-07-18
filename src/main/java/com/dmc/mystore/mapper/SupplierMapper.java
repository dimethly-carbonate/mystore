package com.dmc.mystore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmc.mystore.entity.Supplier;
import org.apache.ibatis.annotations.Param;

public interface SupplierMapper extends BaseMapper<Supplier> {
     Page<Supplier> findPage(Page<Supplier> page, @Param("supName") String supName);
}
