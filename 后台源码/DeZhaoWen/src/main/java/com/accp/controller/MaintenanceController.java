package com.accp.controller;


import com.accp.domain.Service;
import com.accp.mapper.EngineMapper;
import com.accp.service.impl.MaintenanceServiceImpl;
import com.accp.service.impl.ServiceServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 历史维修表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {
    @Autowired
    ServiceServiceImpl serviceService;
    @Autowired
    MaintenanceServiceImpl maintenanceService;

    //菜单两层递归
    @GetMapping("/findmenu")
    public List<Service> findmenu(){
        try {
            QueryWrapper serviceqw=new QueryWrapper<Service>();
            serviceqw.eq("ser_parent","1");
            List<Service> serviceList=serviceService.list(serviceqw);
            for (Service service:serviceList){
                QueryWrapper serviceqw2=new QueryWrapper<Service>();
                serviceqw2.eq("ser_parent",service.getSerId());
                service.setServices(serviceService.list(serviceqw2));
            }
            return serviceList;
        }catch (Exception ex){
            System.out.print("维修项目菜单报错了！");
        }
        return null;
    }



}

