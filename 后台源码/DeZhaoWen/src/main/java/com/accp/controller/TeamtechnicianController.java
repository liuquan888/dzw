package com.accp.controller;


import com.accp.domain.Teamtechnician;
import com.accp.service.impl.TeamtechnicianServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/findByTeamId/{teamid}")
    public List<Teamtechnician> findByTeamId(@PathVariable("teamid") Integer teamid){
        return service.findByTeamId(teamid);
    }

    @RequestMapping("/insertTeamtechnician")
    public boolean insertTeamtechnician(Teamtechnician teamtechnician){
        return service.save(teamtechnician);
    }

    @RequestMapping("/findByIds/{id}")
    public Teamtechnician findByIds(@PathVariable("id") Integer id){
        return service.getById(id);
    }

    @RequestMapping("/removeById/{id}")
    public boolean removeById(@PathVariable("id") Integer id){
        return service.removeById(id);
    }

    @RequestMapping("/updateTeamtechnician")
    public boolean updateTeamtechnician(@RequestBody Teamtechnician teamtechnician){
        return service.updateById(teamtechnician);
    }

    @RequestMapping("/findByAll")
    public List<Teamtechnician> findByAll(String name){
        QueryWrapper<Teamtechnician> queryWrapper=new QueryWrapper<>();
        if(name!=null && name!=" " && name.length()>0){
            queryWrapper.like("technicianid",name).or().like("technicianidname",name).or().like("phone",name);
            return service.list(queryWrapper);
        }else{
            return null;
        }
    }

}

