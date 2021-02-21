package com.accp.controller;


import com.accp.domain.Menu;
import com.accp.service.impl.MenuServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 树形菜单 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuServiceImpl service;

    @RequestMapping("/findAll")
    public List<Menu> findAll(){
        List<Menu> list=service.list();
        for (Menu m:list){
            if(m.getParentid()!=0){
                List<Menu> list2=new ArrayList<Menu>();
                for (Menu m2:list){
                    if(m2.getId()==m.getParentid()){
                        list2.add(m);
                        m2.setChildrens(list2);
                    }
                }
            }
        }
        return list;
    }
}

