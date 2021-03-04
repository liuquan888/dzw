package com.accp.controller;


import com.accp.domain.Upkeep;
import com.accp.service.impl.UpkeepServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 保养表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/upkeep")
public class UpkeepController {
    @Autowired
    UpkeepServiceImpl service;
    @RequestMapping("/findById/{number}")
    public List<Upkeep> findById(@PathVariable Integer number){
        QueryWrapper<Upkeep> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("carnum",number);
        List<Upkeep> list=service.list(queryWrapper);
        for(int i=0;i<list.size();i++) {
            if(i==0) {
                list.get(i).setCheck(true);
            }else {
                list.get(i).setCheck(false);
            }
        }
        return list;
    }
    @RequestMapping("/insertBaoYang")
    public String insertBaoYang(@RequestBody Upkeep main) {
        boolean i=service.save(main);
        if(i) {
            return "1";
        }else {
            return "0";
        }
    }
    @RequestMapping("/updateBaoYang")
    public String updateBaoYang(@RequestBody Upkeep main) {
        boolean i=service.updateById(main);
        if(i) {
            return "1";
        }else {
            return "0";
        }
    }
    @RequestMapping("/deleteBaoYang/{id}")
    public String deleteBaoYang(@PathVariable Integer id) {
        boolean i=service.removeById(id);
        if(i) {
            return "1";
        }else {
            return "0";
        }
    }
    @RequestMapping("/selectMaintainregistInfoByCarNumber")
    public List<Upkeep> selectMaintainregistInfoByCarNumber(String carNumber){
        QueryWrapper<Upkeep> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("carnum",carNumber);
        List<Upkeep> list=service.list(queryWrapper);
        return list;
    }
}

