package com.accp.controller;


import com.accp.domain.Mechaniccommission;
import com.accp.service.impl.MechaniccommissionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 技工提成比例 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/mechaniccommission")
public class MechaniccommissionController {

    @Autowired
    MechaniccommissionServiceImpl service;

    @RequestMapping("/find")
    public List<Mechaniccommission> find(){
        return service.list();
    }

    @RequestMapping("/findById/{typeid}")
    public Mechaniccommission findById(@PathVariable("typeid") Integer typeid){
        return service.getById(typeid);
    }

}

