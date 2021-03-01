package com.accp.controller;


import com.accp.domain.Fieldvehicles;
import com.accp.service.impl.FieldvehiclesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 外勤车辆表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/fieldvehicles")
public class FieldvehiclesController {
    @Autowired
    FieldvehiclesServiceImpl service;

    @RequestMapping("/findAll")
    public List<Fieldvehicles> findAll(){
        return service.findAll();
    }

    @RequestMapping("/findById/{id}")
    public Fieldvehicles findById(@PathVariable("id") Integer id){
        return service.getById(id);
    }

    @RequestMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Integer id){
        return service.removeById(id);
    }

    @RequestMapping("/update")
    public boolean update(@RequestBody Fieldvehicles fieldvehicles){
        System.out.println("111111");
        return service.updateById(fieldvehicles);
    }

    @RequestMapping("/insert")
    public boolean insert(Fieldvehicles fieldvehicles){
        return service.save(fieldvehicles);
    }

    @RequestMapping("/findByTeamId/{teamid}")
    public List<Fieldvehicles> findByTeamId(@PathVariable("teamid") Integer teamid){
        return service.findByTeamId(teamid);
    }
}

