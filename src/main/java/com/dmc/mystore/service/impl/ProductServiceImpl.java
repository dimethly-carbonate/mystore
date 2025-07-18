package com.dmc.mystore.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dmc.mystore.entity.Product;
import com.dmc.mystore.mapper.ProductMapper;
import com.dmc.mystore.service.IProductService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public Page<Product> findPage(Page<Product> page, String name,String psort) {
        return productMapper.findPage(page,name,psort);
    }
}
