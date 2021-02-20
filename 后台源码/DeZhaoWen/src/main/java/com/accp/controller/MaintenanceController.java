package com.accp.controller;


import com.accp.domain.Income;
import com.accp.domain.Maintenance;
import com.accp.domain.Service;
import com.accp.mapper.EngineMapper;
import com.accp.service.impl.IncomeServiceImpl;
import com.accp.service.impl.MaintenanceServiceImpl;
import com.accp.service.impl.ServiceServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    IncomeServiceImpl incomeService;

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

    //默认显示所有维修进程
    @GetMapping("/findmain/{serId}/{fserId}")
    public List<Maintenance> findmain(@PathVariable Integer serId,@PathVariable Integer fserId){
        try {
            System.out.print(fserId);
            System.out.print(">>");
            List<Integer> fuserid=null;
            List<Maintenance> list=null;
            QueryWrapper mainqw=new QueryWrapper<Maintenance>();
            if(serId!=0){
                mainqw.eq("ser_id",serId);
            }
            if (fserId!=0){
                QueryWrapper serqw=new QueryWrapper<Service>();
                serqw.eq("ser_parent",fserId);
                List<Service> serlist=serviceService.list(serqw);
                for (Service service:serlist) {
                    System.out.print(service.getSerId());
                    System.out.print("--");
                    mainqw.eq("ser_id",service.getSerId());
                }
            }
            list=maintenanceService.list(mainqw);
            for(Maintenance maintenance:list){
                QueryWrapper serqw=new QueryWrapper<Service>();
                serqw.eq("ser_id",maintenance.getSerId());
                maintenance.setService((Service) serviceService.list(serqw).get(0));
                QueryWrapper serqw2=new QueryWrapper<Service>();
                serqw2.eq("ser_id",maintenance.getService().getSerParent());
                maintenance.getService().setService((Service) serviceService.list(serqw2).get(0));
                QueryWrapper incqw=new QueryWrapper<Income>();
                incqw.eq("in_id",maintenance.getInId());
                maintenance.setIncome((Income) incomeService.list(incqw).get(0));
            }
            return list;
        }catch (Exception ex){
            System.out.print("查询所有维修进程出错了！");
            return maintenanceService.list();
        }

    }




}

