package com.accp.service.impl;

import com.accp.domain.Teamtechnician;
import com.accp.mapper.TeamtechnicianMapper;
import com.accp.service.ITeamtechnicianService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Service
public class TeamtechnicianServiceImpl extends ServiceImpl<TeamtechnicianMapper, Teamtechnician> implements ITeamtechnicianService {

    @Autowired
    TeamtechnicianMapper teamtechnicianMapper;

    public List<Teamtechnician> findByTeamId(Integer teamid){
        return teamtechnicianMapper.findByTeamId(teamid);
    }

    public List<Teamtechnician> findByAll(String name){
        return teamtechnicianMapper.findByAll(name);
    }

    public boolean clearPwd(Integer id){
        return teamtechnicianMapper.clearPwd(id);
    }

    public List<Teamtechnician> findAll(){
        return teamtechnicianMapper.findAll();
    }

}
