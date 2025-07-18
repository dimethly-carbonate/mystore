package com.dmc.mystore.controller.dto;

import com.dmc.mystore.entity.Menu;
import lombok.Data;

import java.util.Date;
import java.util.List;

/*接收前端登录请求的参数*/
@Data
public class ManagerDTO {
    private String adname;
    private String adpwd;
    private Date createTime;
    private String avatarUrl;
    private String nikename;
    private String token;
    private String role;
    private List<Menu> menus;
}
