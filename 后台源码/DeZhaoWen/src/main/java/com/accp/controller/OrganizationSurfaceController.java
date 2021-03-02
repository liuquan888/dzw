package com.accp.controller;


import com.accp.domain.OrganizationSurface;
import com.accp.domain.StaffData;
import com.accp.service.IDeparmentSurfaceService;
import com.accp.service.IOrganizationSurfaceService;
import com.accp.service.IStaffDataService;
import com.accp.service.impl.OrganizationSurfaceServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
 * @since 2021-02-04O
 */
@RestController
@RequestMapping("/organizationSurface")
public class OrganizationSurfaceController {

    @Autowired
    OrganizationSurfaceServiceImpl o;
    @Autowired
    IStaffDataService service;
    @Autowired
    IDeparmentSurfaceService bservice;

    @RequestMapping("/find")
    public List<OrganizationSurface> findByAll(){
        return o.list();
    }

    @RequestMapping("/findId")
    public List<OrganizationSurface> findId(){
        return o.find();
    }

    @RequestMapping("/insert")
    public boolean insert(OrganizationSurface or){
        return o.save(or);
    }

    @RequestMapping("/remove")
    public boolean remove(Integer id){
        return o.removeById(id);
    }

    @RequestMapping("/update")
    public boolean update(OrganizationSurface or){
        return o.updateById(or);
    }

}