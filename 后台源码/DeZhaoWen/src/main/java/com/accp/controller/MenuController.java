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

    @RequestMapping("/findByParentId")
    public List<Menu> findByParentId(){
        return service.findByParentId();
    }
}

