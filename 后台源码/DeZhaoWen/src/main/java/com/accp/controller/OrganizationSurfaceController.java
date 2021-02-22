package com.accp.controller;


import com.accp.domain.OrganizationSurface;
import com.accp.service.impl.OrganizationSurfaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 组织机构定义表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/organizationSurface")
public class OrganizationSurfaceController {

    @Autowired
    OrganizationSurfaceServiceImpl o;

    @RequestMapping("/find")
    public List<OrganizationSurface> findByAll(){
        return o.list();
    }
}