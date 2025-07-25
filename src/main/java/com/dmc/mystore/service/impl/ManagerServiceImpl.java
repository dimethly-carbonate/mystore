package com.dmc.mystore.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dmc.mystore.common.Constants;
import com.dmc.mystore.controller.dto.ManagerDTO;
import com.dmc.mystore.controller.dto.UserPasswordDTO;
import com.dmc.mystore.entity.Manager;
import com.dmc.mystore.entity.Menu;
import com.dmc.mystore.exception.ServiceException;
import com.dmc.mystore.mapper.ManagerMapper;
import com.dmc.mystore.mapper.RoleMapper;
import com.dmc.mystore.mapper.RoleMenuMapper;
import com.dmc.mystore.service.IManagerService;
import com.dmc.mystore.service.IMenuService;
import com.dmc.mystore.utils.TokenUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements IManagerService {
    private static final Log LOG = Log.get();
    @Resource
    private RoleMapper roleMapper ;
    @Resource
    private RoleMenuMapper roleMenuMapper;
    @Resource ManagerMapper managerMapper;
    @Resource
    private IMenuService menuService;
    @Override
    public ManagerDTO login(ManagerDTO managerDTO) {
        QueryWrapper<Manager> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("adname",managerDTO.getAdname());
        queryWrapper.eq("adpwd",managerDTO.getAdpwd());
        Manager one;
        try {
            one = getOne(queryWrapper);//从数据库查询用户信息
        }catch (Exception e){
            LOG.error(e);
            throw new ServiceException(Constants.CODE_500,"系统错误");

        }
            if (one != null){
                BeanUtil.copyProperties(one,managerDTO,true);
                //设置token
               String token= TokenUtils.genToken(one.getAdid().toString(),one.getAdpwd());
               managerDTO.setToken(token);

               String role=one.getRole();//ROLE_ADMIN

                //设置用户的菜单列表
               List<Menu> roleMenus= getRoleMenus(role);
                managerDTO.setMenus(roleMenus);

                return managerDTO;
            }else {
                throw new ServiceException(Constants.CODE_600,"用户名或密码错误");
            }
        }

    @Override
    public void updatePassword(UserPasswordDTO userPasswordDTO) {
            int update = managerMapper.updatePassword(userPasswordDTO);
            if (update < 1) {
                throw new ServiceException(Constants.CODE_600, "密码错误");

        }
    }

    @Override
    public Page<Manager> findPage(Page<Manager> page) {

        return managerMapper.findPage(page);
    }

    @Override
    public Page<Manager> findPage1(Page<Manager> page) {

        return managerMapper.findPage1(page);
    }
    @Override
    public Page<Manager> findPage2(Page<Manager> page) {

        return managerMapper.findPage2(page);
    }
    /**
     * 获取当前角色的菜单列表
     * @param roleFlag
     * @return
     */
    private List<Menu> getRoleMenus(String roleFlag){
        Integer roleId= roleMapper.selectByFlag(roleFlag);

        //当前角色的所有菜单id集合
            List<Integer> menuIds = roleMenuMapper.selectByRoleId(roleId);
            //查询系统所有的菜单
            List<Menu> menus= menuService.findMenus("");
            //new一个最后筛选完成之后的list
            List<Menu> roleMenus=new ArrayList<>();
            //筛选当前用户角色的菜单
            for (Menu menu : menus){
                if (menuIds.contains(menu.getId())){
                    roleMenus.add(menu);
                }
                List<Menu> children=menu.getChildren();
                //removeIf  移除children里面不在menuIds集合中的元素
                children.removeIf(child -> !menuIds.contains(child.getId()));
            }
            return roleMenus;
        }
    }

