package com.accp.controller;


import com.accp.domain.Mechanicstar;
import com.accp.service.impl.MechanicstarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 技工星级表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@RestController
@RequestMapping("/mechanicstar")
public class MechanicstarController {
    @Autowired
    MechanicstarServiceImpl service;

    @RequestMapping("/find")
    public List<Mechanicstar> find(){
        return service.list();
    }

    @RequestMapping("/delete/{code}")
    public boolean delete(@PathVariable("code") String code){
        boolean bl=service.removeById(code);
        System.out.println(bl);
        return false;
    }

    @RequestMapping("/findById/{code}")
    public Mechanicstar findById(@PathVariable("code") String code){
        System.out.println(code);
        return service.getById(code);
    }

}

