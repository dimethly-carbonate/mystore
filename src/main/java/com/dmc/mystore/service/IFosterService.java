package com.dmc.mystore.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dmc.mystore.entity.Foster;

public interface IFosterService extends IService<Foster> {

    Page<Foster> findPage(Page<Foster> page, String phone,String fosName,String startTime,String fosOper,String fosStatus);

}
