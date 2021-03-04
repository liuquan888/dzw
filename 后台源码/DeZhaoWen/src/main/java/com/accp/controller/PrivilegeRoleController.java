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
//        QueryWrapper<PrivilegeRole> queryWrapper =new QueryWrapper<>();
//        queryWrapper.lambda().eq(PrivilegeRole::getRid,roleId);
//        List<PrivilegeRole> list=privilegeRoleService.list(queryWrapper);
//        List<DzwPrivilege> listDzw=new ArrayList<>();
//        for (PrivilegeRole p:list) {
//           DzwPrivilege dzw = dzwPrivilegeService.getById(p.getPid());
//           listDzw.add(dzw);
//        }
//        return listDzw;
        QueryWrapper qw=new QueryWrapper<PrivilegeRole>();
        qw.eq("rid",roleId);
        List<PrivilegeRole> list=privilegeRoleService.list(qw);
        List<DzwPrivilege> list2=new ArrayList();
        for (PrivilegeRole pr:list){
            DzwPrivilege dzw = dzwPrivilegeService.getById(pr.getPid());
            if(dzw.getPvgType()==2){
                QueryWrapper qq=new QueryWrapper<DzwPrivilege>();
                qq.eq("pvg_type",2);
               List<DzwPrivilege> list3 =dzwPrivilegeService.list(qq);
               for (DzwPrivilege dp:list3){
                   if(dzw.getPid()==dp.getPvgid()){
                       list2.add(dzw);
                       System.out.println(dp.getPvgName()+"的子级"+dzw.getPvgName());
                   }else{
                       System.out.println(0);
                       System.out.println(dp.getPvgName()+"*****/"+dzw.getPvgName());
                   }
               }
            }
        }
        return list2;
    }
}

