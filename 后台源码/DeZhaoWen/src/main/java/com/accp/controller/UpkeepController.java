package com.accp.controller;


import com.accp.domain.Upkeep;
import com.accp.service.impl.UpkeepServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping("/findById/{carnum}")
    public List<Upkeep> findById(Integer id){
        QueryWrapper<Upkeep> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("carnum",id);
        List<Upkeep> list=service.list(queryWrapper);
        return list;
    }
    @RequestMapping("/insert")
    public boolean insert(Upkeep up){
        return service.save(up);
    }
    @RequestMapping("/update")
    public boolean update(Upkeep up){
        return service.updateById(up);
    }
    @RequestMapping("/delete/{id}")
    public boolean delete(Integer id){
        return service.removeById(id);
    }
}

