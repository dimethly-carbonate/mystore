package com.dmc.mystore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmc.mystore.entity.Sort;
import org.apache.ibatis.annotations.Param;

public interface SortMapper extends BaseMapper<Sort> {

     Page<Sort> findPage(Page<Sort> page, @Param("sortname") String sortname);

    Page<Sort> findPage1(Page<Sort> page);
}
