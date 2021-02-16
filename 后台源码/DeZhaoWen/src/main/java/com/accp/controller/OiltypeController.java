package com.accp.controller;


import com.accp.domain.Oiltype;
import com.accp.service.impl.OiltypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 燃油表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/oiltype")
public class OiltypeController {
    @Autowired
    OiltypeServiceImpl service;
    @RequestMapping("/findAll")
    public List<Oiltype> findAll(){
        return service.list();
    }
    @RequestMapping("/findById/{id}")
    public Oiltype findById(@PathVariable Integer id){
        return service.getById(id);
    }
    @RequestMapping("/update")
    public boolean update(@PathVariable Oiltype o){
        return service.updateById(o);
    }
}

