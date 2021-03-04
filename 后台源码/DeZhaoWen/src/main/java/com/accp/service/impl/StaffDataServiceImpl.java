package com.accp.service.impl;

import com.accp.domain.OrganizationSurface;
import com.accp.domain.StaffData;
import com.accp.mapper.StaffDataMapper;
import com.accp.service.IStaffDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 员工资料表 服务实现类
 * </p>
 *
 * @author quanl
 * @since 2021-02-25
 */
@Service
public class StaffDataServiceImpl extends ServiceImpl<StaffDataMapper, StaffData> implements IStaffDataService {

    @Autowired
    StaffDataMapper mapper;

    public boolean gai(Integer id){
        return mapper.xiugai(id);
    }
}
