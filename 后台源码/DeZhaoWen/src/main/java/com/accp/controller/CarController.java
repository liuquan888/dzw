package com.accp.controller;


import com.accp.domain.Car;
import com.accp.domain.Vehicle;
import com.accp.service.impl.CarServiceImpl;
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
    CarServiceImpl service;
    @RequestMapping("find")
    public List<Car> find(String carcoding, String tiaojian){
        QueryWrapper<Car> queryWrapper=new QueryWrapper<>();
        if (tiaojian!=null){
            queryWrapper.eq("cCoder",tiaojian).or().eq("reserved1",tiaojian);
        }
        if (carcoding!=null){
            queryWrapper.eq("bId",carcoding);
        }
        List<Car> list=service.list(queryWrapper);
        for(int i=0;i<list.size();i++) {
            if(i==0) {
                list.get(i).setCheck(true);
            }else {
                list.get(i).setCheck(false);
            }
        }
        return list;
    }
    @RequestMapping("/findById")
    public List<Car> findById(String v){
        QueryWrapper<Car> query=new QueryWrapper<>();
        if (v!=null){
            query.eq("b_id",v);
        }
        List<Car> list=service.list(query);
        for(int i=0;i<list.size();i++) {
            if(i==0) {
                list.get(i).setCheck(true);
            }else {
                list.get(i).setCheck(false);
            }
        }
        return list;
    }
    @RequestMapping("/findAll")
    public List<Car> findAll(){
        List<Car> list=service.list();
        for(int i=0;i<list.size();i++) {
            if(i==0) {
                list.get(i).setCheck(true);
            }else {
                list.get(i).setCheck(false);
            }
        }
        return list;
    }
}

