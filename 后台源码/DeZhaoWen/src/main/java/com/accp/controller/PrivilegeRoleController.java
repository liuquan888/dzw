package com.accp.controller;


import com.accp.domain.DzwPrivilege;
import com.accp.domain.PrivilegeRole;
import com.accp.service.impl.DzwPrivilegeServiceImpl;
import com.accp.service.impl.PrivilegeRoleServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import netscape.security.Privilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 权限与角色中间表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/privilegeRole")
public class PrivilegeRoleController {
    @Autowired
    PrivilegeRoleServiceImpl privilegeRoleService;

    @Autowired
    DzwPrivilegeServiceImpl dzwPrivilegeService;

    @RequestMapping("/findPerms")
    public List<DzwPrivilege> findPermsByRoleId(Integer roleId){
        QueryWrapper<PrivilegeRole> queryWrapper =new QueryWrapper<>();
        queryWrapper.lambda().eq(PrivilegeRole::getRid,roleId);
        List<PrivilegeRole> list=privilegeRoleService.list(queryWrapper);
        List<DzwPrivilege> listDzw=new ArrayList<>();
        for (PrivilegeRole p:list) {
           DzwPrivilege dzw = dzwPrivilegeService.getById(p.getPid());
           listDzw.add(dzw);
        }
        return listDzw;
    }
}

