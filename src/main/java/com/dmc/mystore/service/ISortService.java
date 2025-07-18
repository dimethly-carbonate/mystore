package com.dmc.mystore.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dmc.mystore.entity.Sort;
import com.dmc.mystore.entity.*;

public interface ISortService extends IService<Sort> {

    Page<Sort> findPage(Page<Sort> objectPage, String sortname);
    Page<Sort> findPage1(Page<Sort> objectPage);

}
