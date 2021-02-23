package com.accp.controller;


import com.accp.domain.Teamtechnician;
import com.accp.service.impl.TeamtechnicianServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/teamtechnician")
public class TeamtechnicianController {
    @Autowired
    TeamtechnicianServiceImpl service;

    @RequestMapping("/findAll")
    public List<Teamtechnician> findAll(){
        return service.list();
    }

    @RequestMapping("/findByTeamId")
    public List<Teamtechnician> findByTeamId(@PathVariable("teamid") Integer teamid){
        QueryWrapper<Teamtechnician> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("teamid",teamid);
        return service.list();
    }

}

