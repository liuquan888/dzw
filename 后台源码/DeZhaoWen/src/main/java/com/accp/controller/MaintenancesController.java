package com.accp.controller;


import com.accp.domain.Maintenances;
import com.accp.service.impl.MaintenancesServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 历史维修 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/maintenances")
public class MaintenancesController {
    @Autowired
    MaintenancesServiceImpl service;
    @RequestMapping("/find")
    public List<Maintenances> find(String chepai){
        QueryWrapper<Maintenances> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("chepai",chepai);
        List<Maintenances> list=service.list(queryWrapper);
        return list;
    }
    @RequestMapping("/selectRepairByCarNumber")
    public List<Maintenances> selectRepairByCarNumber(String number){
        QueryWrapper<Maintenances> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("chepai",number);
        List<Maintenances> list=service.list(queryWrapper);
        return list;
    }

}

