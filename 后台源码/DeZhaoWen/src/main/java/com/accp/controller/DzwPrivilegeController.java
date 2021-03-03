package com.accp.controller;


import com.accp.domain.DzwPrivilege;
import com.accp.domain.DzwUser;
import com.accp.service.impl.DzwPrivilegeServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

