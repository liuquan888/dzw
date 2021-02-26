package com.accp.controller;


import com.accp.domain.DzwRole;
import com.accp.domain.RoleUser;
import com.accp.service.impl.DzwRoleServiceImpl;
import com.accp.service.impl.DzwUserServiceImpl;
import com.accp.service.impl.RoleUserServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 角色与用户中间表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/roleUser")
public class RoleUserController {
    @Autowired
    DzwUserServiceImpl userService;
    @Autowired
    DzwRoleServiceImpl roleService;
    @Autowired
    RoleUserServiceImpl roleUserService;

    @RequestMapping("/findUser")
    public List<DzwRole> findPerms(Integer userId){
        QueryWrapper<RoleUser> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(RoleUser::getUid,userId);
        List<RoleUser> list=roleUserService.list(queryWrapper);
        List<DzwRole> li= new  ArrayList<>();
        for (RoleUser r:list) {
            QueryWrapper<DzwRole> query=new QueryWrapper<>();
            query.lambda().eq(DzwRole::getRoleId,r.getRid());
            List<DzwRole> li2=roleService.list(query);
            li.add(li2.get(0));
        }
        return li;
    }
}

