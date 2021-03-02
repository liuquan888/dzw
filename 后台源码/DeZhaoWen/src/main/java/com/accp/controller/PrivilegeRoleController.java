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

        QueryWrapper qq=new QueryWrapper<DzwPrivilege>();
        Integer [] types={2};
        qq.in("pvg_type",types);
        List<DzwPrivilege> list3 =dzwPrivilegeService.list(qq);

        List<Integer> list4=new ArrayList();

        for (PrivilegeRole pr:list){
            DzwPrivilege dzw = dzwPrivilegeService.getById(pr.getPid());

            if(dzw.getPvgType()==3){
                for (DzwPrivilege dp:list3) {
                    if(dzw.getPid()==dp.getPvgid()){
                        list4.add(dzw.getPid());
                        list2.add(dzw);
                    }
                }
            }

        }

//        List<Integer> list5=new ArrayList();
//
//        for (PrivilegeRole pr:list){
//            DzwPrivilege dzw = dzwPrivilegeService.getById(pr.getPid());
//            if(dzw.getPvgType()==2){
//                for (Integer i : list4){
//                    if(dzw.getPvgid()!=i){
//                        list5.add(dzw.getPvgid());
//                    }
//                }
//            }
//        }
//        List<Integer> list6=new ArrayList();
//        for (PrivilegeRole pr:list){
//            list6.add(pr.getPid());
//        }
//        QueryWrapper tiaoj=new QueryWrapper<DzwPrivilege>();
//        tiaoj.in("pvgid",list6);
//        tiaoj.notIn("pvgid",list5);
//        tiaoj.eq("pvg_type",2);
//        List<DzwPrivilege> list7=dzwPrivilegeService.list(tiaoj);
//        for (DzwPrivilege data:list7){
//            System.out.println(data.getPvgName());
//        }
        return list2;
    }
}

