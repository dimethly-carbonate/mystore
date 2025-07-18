package com.dmc.mystore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dmc.mystore.controller.dto.UserPasswordDTO;
import com.dmc.mystore.entity.Manager;
import org.apache.ibatis.annotations.Update;

public interface ManagerMapper extends BaseMapper<Manager> {
    Page<Manager> findPage(Page<Manager> page);
    Page<Manager> findPage1(Page<Manager> page);
    Page<Manager> findPage2(Page<Manager> page);

    @Update("update fl_admin set adpwd = #{newPassword} where adname = #{adname} and adpwd = #{adpwd}")
    int updatePassword(UserPasswordDTO userPasswordDTO);

}