package com.dmc.mystore.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dmc.mystore.entity.Sort;
import com.dmc.mystore.mapper.SortMapper;
import com.dmc.mystore.service.ISortService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SortServiceImpl extends ServiceImpl<SortMapper, Sort> implements ISortService {

    @Resource
    private SortMapper sortMapper;

    @Override
    public Page<Sort> findPage(Page<Sort> page, String sortname) {

        return sortMapper.findPage(page,sortname);
    }

    @Override
    public Page<Sort> findPage1(Page<Sort> page) {
        return sortMapper.findPage1(page);

    }
}
