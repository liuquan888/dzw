package com.accp.controller;


import com.accp.domain.DzwPrivilege;
import com.accp.domain.DzwUser;
import com.accp.domain.Waiqin;
import com.accp.service.impl.DzwPrivilegeServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-22
 */
@RestController
@RequestMapping("/dzwPrivilege")
public class DzwPrivilegeController {
    @Autowired
    DzwPrivilegeServiceImpl privilege;
    @RequestMapping("/find")
    public List<DzwPrivilege> find(){
        return privilege.list();
    }

    @RequestMapping("query")
    public List<DzwPrivilege> query(Integer pvgType){
        QueryWrapper<DzwPrivilege> dzwPrivilegeQueryWrapper=new QueryWrapper<>();
        dzwPrivilegeQueryWrapper.lambda().eq(DzwPrivilege::getPvgType,pvgType);
       return privilege.list(dzwPrivilegeQueryWrapper);
    }

    @RequestMapping("update")
    public boolean update(DzwPrivilege menus){
        menus.setReserved1(null);
        return privilege.updateById(menus);
    }

    @RequestMapping("query2")
    public List<DzwPrivilege> query2(String name){
        QueryWrapper<DzwPrivilege> dzwp=new QueryWrapper<>();
        dzwp.lambda().like(DzwPrivilege::getPvgName,name);
        return privilege.list(dzwp);
    }
}

