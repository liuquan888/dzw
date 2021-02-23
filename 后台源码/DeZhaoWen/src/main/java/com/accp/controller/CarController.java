package com.accp.controller;


import com.accp.domain.Vehicle;
import com.accp.service.impl.VehicleServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 车型表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    VehicleServiceImpl service;
    @RequestMapping("find")
    public List<Vehicle> find(String condition,Integer carbrandid){
        QueryWrapper<Vehicle> queryWrapper=new QueryWrapper<>();
        if (carbrandid!=null){
            queryWrapper.eq("vehicleid",carbrandid);
        }
        if (condition!=null){
            queryWrapper.like("vehiclename",condition);
        }
        return service.list(queryWrapper);
    }
    @RequestMapping("/findById")
    public List<Vehicle> findById(String v){
        QueryWrapper<Vehicle> query=new QueryWrapper<>();
        if (v!=null){
            query.eq("carcoding",v);
        }
        List<Vehicle> list=service.list(query);
        return list;
    }
    @RequestMapping("/findAll")
    public List<Vehicle> findAll(){
        return service.list();
    }
}

