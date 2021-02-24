package com.accp.service.impl;

import com.accp.domain.OrganizationSurface;
import com.accp.mapper.OrganizationSurfaceMapper;
import com.accp.service.IOrganizationSurfaceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 组织机构定义表 服务实现类
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Service
public class OrganizationSurfaceServiceImpl extends ServiceImpl<OrganizationSurfaceMapper, OrganizationSurface> implements IOrganizationSurfaceService {

    @Autowired
    OrganizationSurfaceMapper mapper;

    public List<OrganizationSurface> find(){
        return mapper.find(0);
    }

}
