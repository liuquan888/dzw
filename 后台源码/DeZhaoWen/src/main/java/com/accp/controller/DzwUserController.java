package com.accp.controller;


import com.accp.domain.DzwPrivilege;
import com.accp.domain.DzwUser;
import com.accp.domain.PrivilegeRole;
import com.accp.domain.RoleUser;
import com.accp.service.impl.DzwPrivilegeServiceImpl;
import com.accp.service.impl.DzwUserServiceImpl;
import com.accp.service.impl.PrivilegeRoleServiceImpl;
import com.accp.service.impl.RoleUserServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.DirectFieldAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.util.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/dzwUser")
public class DzwUserController{
    @Autowired
    DzwUserServiceImpl duser;

    @Autowired
    RoleUserServiceImpl ruser;

    @Autowired
    PrivilegeRoleServiceImpl prser;

    @Autowired
    DzwPrivilegeServiceImpl dpser;

    @Autowired
    RoleUserServiceImpl role;

    @RequestMapping("/find")
    public DzwUser find(DzwUser user,HttpSession session){
        QueryWrapper<DzwUser> query=new QueryWrapper<>();
        query.lambda().eq(DzwUser::getUserPwd,user.getUserPwd()).eq(DzwUser::getUserLogin,user.getUserLogin());
        List<DzwUser> li=duser.list(query);
        if(li.size()>0){
            for(DzwUser us:li){
                if(us!=null){
                    QueryWrapper<RoleUser> userQueryWrapper= new QueryWrapper<>();
                    userQueryWrapper.lambda().eq(RoleUser::getUid,li.get(0).getUserId());
                    List<RoleUser> listrole= role.list(userQueryWrapper);
                    us.setReserved1(listrole.get(0).getRid().toString());
                    session.setAttribute("user",li);
                }
            }
        }
        return li.get(0);
    }

    //根据用户ID获取菜单，
    //字段type表示权限对象的类别必须与type相等，为空则返回全部
    //pid自己的父级id与type作用类似
    @RequestMapping("/getMenu")
    public List<DzwPrivilege> getMenu(Integer userId,Integer type,Integer pid){
        if(userId==null){
            return null;
        }

        //获取角色id
        QueryWrapper qw=new QueryWrapper<RoleUser>();
        qw.eq("uid",userId);
        List<RoleUser> ru=ruser.list(qw);
        Integer rid=-1;
        for (RoleUser r:ru) {
            rid=r.getRid();
        }
        if(rid==-1){
            return null;
        }

        //根据角色id获取权限id
        QueryWrapper qw2=new QueryWrapper<PrivilegeRole>();
        qw2.eq("rid",rid);
        List<PrivilegeRole> list=prser.list(qw2);

        //待会要返回的权限对象集合
        List<DzwPrivilege> list2=new ArrayList<DzwPrivilege>();

        //根据权限id获取权限对象
        for (PrivilegeRole pr:list){
            DzwPrivilege dzwP=dpser.getById(pr.getPid());

            //判断类别
            if(type==null){
                list2.add(dzwP);
            }else if(dzwP.getPvgType()==type){

                //判断父级id
                if(pid==null){
                    list2.add(dzwP);
                }else{
                    if(dzwP.getPid()==pid){
                        list2.add(dzwP);
                    }
                }

            }

        }
        if(pid!=null){
            List<Integer> ids=new ArrayList<Integer>();
            for (DzwPrivilege d:list2){
                ids.add(d.getPvgid());
            }

            //根据左侧最上级meunID查询它的下级菜单
            QueryWrapper q=new QueryWrapper<DzwPrivilege>();
            q.in("pid",ids);
            List<DzwPrivilege> list3=dpser.list(q);

//            for (PrivilegeRole pr:list){
//                for (DzwPrivilege dp:list3){
//                    if(pr.getPid()=){
//
//                    }
//                }
//            }

            //循环左侧最上级meun
            for (DzwPrivilege dd:list2) {

                //创建list4
                List<DzwPrivilege> list4=new ArrayList<DzwPrivilege>();

                //循环下级菜单
                for (DzwPrivilege ddd:list3){

                    //判断下级菜单的父级与之是否对应
                    if(dd.getPvgid()==ddd.getPid()){

                        for (PrivilegeRole pr:list){
                            if(pr.getPid()==ddd.getPvgid()){
                                list4.add(ddd);
                            }
                        }
                    }
                }
                dd.setChildren(list4);
            }
        }
        return list2;
    }

    @RequestMapping("select")
    public List<DzwUser> select(){
        return duser.list();
    }

    @RequestMapping("query")
    public DzwUser query(Integer userId){
        QueryWrapper<DzwUser> user=new QueryWrapper<>();
        user.lambda().eq(DzwUser::getUserId,userId);
        return duser.list(user).get(0);
    }

    @RequestMapping("update")
    public boolean update(DzwUser user){
        user.setUpdateDate(null);
        user.setCreateDate(null);
        QueryWrapper<DzwUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",user.getUserId());
        return user.update(queryWrapper);
    }

    @PostMapping("add")
    public String add(@RequestBody DzwUser user){
      boolean bool=  duser.save(user);
        return bool?"0000":"1111";
    }

    @RequestMapping("remove")
    public String remove( Integer userId){
        QueryWrapper<DzwUser> dzwuser=new QueryWrapper<>();
        QueryWrapper<RoleUser> roleUserQueryWrapper=new QueryWrapper<>();
        roleUserQueryWrapper.lambda().eq(RoleUser::getUid,userId);
        role.remove(roleUserQueryWrapper);
        dzwuser.lambda().eq(DzwUser::getUserId,userId);
        boolean bool= duser.remove(dzwuser);
        return bool?"0000":"1111";
    }

    @PostMapping("insert/{userId}")
    public String insert(@RequestBody List<Integer> list, @PathVariable Integer userId){
        QueryWrapper<RoleUser> roleuser=new QueryWrapper<>();
        roleuser.lambda().eq(RoleUser::getUid,userId);
        ruser.remove(roleuser);
        for (Integer l:list) {
            RoleUser role=new RoleUser();
            role.setUid(userId);
            role.setRid(l);
            ruser.save(role);
        }
        return "0000";
    }
}

