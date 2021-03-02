package com.accp.service.impl;

import com.accp.domain.Fieldvehicles;
import com.accp.mapper.FieldvehiclesMapper;
import com.accp.service.IFieldvehiclesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 外勤车辆表 服务实现类
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Service
public class FieldvehiclesServiceImpl extends ServiceImpl<FieldvehiclesMapper, Fieldvehicles> implements IFieldvehiclesService {

    @Autowired
    FieldvehiclesMapper fieldvehiclesMapper;

    public List<Fieldvehicles> findByTeamId(Integer teamid){
        return fieldvehiclesMapper.findByTeamId(teamid);
    }

    public List<Fieldvehicles> findAll(){
        return fieldvehiclesMapper.findAll();
    }

}
