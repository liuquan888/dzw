package com.accp.controller;


import com.accp.domain.Menu;
import com.accp.service.impl.MenuServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/findByParentId")
    public List<Menu> findByParentId(){
        return service.findByParentId();
    }

    @RequestMapping("/findByTeamId/{teamid}")
    public Menu findByTeamId(@PathVariable("teamid") Integer teamid){
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("teamid",teamid);
        return service.list(queryWrapper).get(0);
    }

    @RequestMapping("/findNoByParentId")
    public List<Menu> findNoByParentId(){
        return service.findNoByParentId();
    }

    @RequestMapping("/findTeamIdDesc")
    public Menu findTeamIdDesc(){
        Menu menu=service.findTeamIdDesc();
        return menu;
    }



    @RequestMapping("/insertMenu")
    public boolean insertMenu(Menu menu){
        return service.save(menu);
    }

    @RequestMapping("/updateMenu")
    public boolean updateMenu(@RequestBody Menu menu){
        return service.updateById(menu);
    }

    @RequestMapping("/removeMenu/{teamid}")
    public boolean removeMenu(@PathVariable("teamid") Integer teamid){
        QueryWrapper<Menu> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("teamid",teamid);
        return service.remove(queryWrapper);
    }

}

