package com.accp.controller;


import com.accp.domain.DzwRole;
import com.accp.domain.PrivilegeRole;
import com.accp.service.impl.DzwRoleServiceImpl;
import com.accp.service.impl.PrivilegeRoleServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/dzwRole")
public class DzwRoleController {
    @Autowired
    DzwRoleServiceImpl role;

    @Autowired
    PrivilegeRoleServiceImpl privilegeRoleService;

    @RequestMapping("/find")
    public List<DzwRole> find(){
        return role.list();
    }

    @PostMapping("add/{roleId}")
    public String add(@RequestBody List<Integer> list, @PathVariable Integer roleId){
       QueryWrapper<PrivilegeRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(PrivilegeRole::getRid,roleId);
        privilegeRoleService.remove(queryWrapper);
        for (Integer li:list) {
            PrivilegeRole privilegeRole = new PrivilegeRole();
            privilegeRole.setPid(li);
            privilegeRole.setRid(roleId);
            privilegeRoleService.save(privilegeRole);
        }
        return "授权成功！";
    }
}

