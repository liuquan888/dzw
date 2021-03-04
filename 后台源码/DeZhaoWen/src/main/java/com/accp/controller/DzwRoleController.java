package com.accp.controller;


import com.accp.domain.DzwRole;
import com.accp.domain.DzwUser;
import com.accp.domain.PrivilegeRole;
import com.accp.domain.RoleUser;
import com.accp.service.impl.DzwRoleServiceImpl;
import com.accp.service.impl.PrivilegeRoleServiceImpl;
import com.accp.service.impl.RoleUserServiceImpl;
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

    @Autowired
    RoleUserServiceImpl roleuser;


    @RequestMapping("/find")
    public List<DzwRole> find(){
        return role.list();
    }

    @PostMapping("add/{roleId}")
    public boolean add(@RequestBody List<Integer> list, @PathVariable Integer roleId){
       QueryWrapper<PrivilegeRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(PrivilegeRole::getRid,roleId);
        privilegeRoleService.remove(queryWrapper);
        for (Integer li:list) {
            PrivilegeRole privilegeRole = new PrivilegeRole();
            privilegeRole.setPid(li);
            privilegeRole.setRid(roleId);
            privilegeRoleService.save(privilegeRole);
        }
        return true;
    }

    @PostMapping("address")
    public String address(@RequestBody DzwRole dzwrole){
        boolean bool=role.save(dzwrole);
        return bool?"0000":"1111";
    }

    @RequestMapping("/remove")
    public String remove( Integer roleId){
        QueryWrapper<DzwRole> dzwrole=new QueryWrapper<>();
        QueryWrapper<RoleUser> roleUserQueryWrapper=new QueryWrapper<>();
        QueryWrapper<PrivilegeRole> privilegeRoleQueryWrapper=new QueryWrapper<>();
        privilegeRoleQueryWrapper.lambda().eq(PrivilegeRole::getRid,roleId);
        privilegeRoleService.remove(privilegeRoleQueryWrapper);
        roleUserQueryWrapper.lambda().eq(RoleUser::getRid,roleId);
        roleuser.remove(roleUserQueryWrapper);
        dzwrole.lambda().eq(DzwRole::getRoleId,roleId);
        boolean bool= role.remove(dzwrole);
        return bool?"0000":"1111";
    }

    @RequestMapping("update")
    public boolean update(DzwRole dzwRole){
//        QueryWrapper<DzwRole> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("role_id",dzwRole.getRoleId());
        return role.updateById(dzwRole);
    }
}

