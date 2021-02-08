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
 * @since 2021-02-04
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
        return service.removeById(code);
    }

    @RequestMapping("/findById/{code}")
    public Mechanicstar findById(@PathVariable("code") String code){
        return service.getById(code);
    }

    @RequestMapping("/insert")
    public boolean insert(Mechanicstar mechanicstar){
        return service.save(mechanicstar);
    }

    @RequestMapping("/update")
    public boolean update(Mechanicstar mechanicstar){
        return service.updateById(mechanicstar);
    }

}

