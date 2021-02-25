package com.accp.controller;


import com.accp.domain.Car;
import com.accp.domain.Income;
import com.accp.domain.Maintenance;

import com.accp.domain.Service;
import com.accp.mapper.EngineMapper;
import com.accp.service.impl.IncomeServiceImpl;
import com.accp.service.impl.MaintenanceServiceImpl;
import com.accp.service.impl.ServiceServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.FileAlreadyExistsException;
import java.util.DuplicateFormatFlagsException;
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
    @PostMapping("/findmain")
    public List<Maintenance> findmain(@RequestBody List<Integer> params){
        try {
            List<Maintenance> list=null;
            QueryWrapper<Maintenance> mainqw=new QueryWrapper<Maintenance>();
            if(params!=null && params.size()>0){
                mainqw.lambda().in(Maintenance::getSerId,params);
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

    //查询最大编号用于新增默认值
    @GetMapping("/findmax")
    public int findmax(){
        QueryWrapper serviceqw=new QueryWrapper<Service>();
        serviceqw.orderByDesc("ser_id");
        List<Service> list = serviceService.list(serviceqw);
        return list.get(0).getSerId();
    }

    @PostMapping("/addservice")
    public String addservice(Service service){
        try {
            QueryWrapper serviceqw=new QueryWrapper<Service>();
            serviceqw.eq("ser_id",service.getSerId());
            if(serviceService.list(serviceqw).size()>0){
                return "000001";
            }
            return serviceService.save(service)?"000000":"-1";
        }catch (Exception ex){
            return "500";
        }
    }

    //判断是否为车型发动机
    @GetMapping("/findtemp1/{serId}")
    public boolean findtemp1(@PathVariable Integer serId){
        QueryWrapper serqw=new QueryWrapper<Service>();
        Service service=serviceService.getById(serId);
        serqw.eq("ser_id",service.getSerParent());
        Service service1=(Service)serviceService.list(serqw).get(0);
        if(service1.getSerName().equals("车型")||service1.getSerName().equals("发动机")){
            return true;
        }
        return false;
    }

    @PostMapping("/updateservice")
    public String updateservice(Service service){
        try {
            return serviceService.updateById(service)?"000000":"-1";
        }catch (Exception ex){
            return "500";
        }
    }

    //所有收费种类
    @GetMapping("/findgong")
    public List<Income> findgong(){
        try {
            return incomeService.list();
        }catch (Exception ex){
            System.out.print("查询收费种类报错了！");
        }
        return null;
    }

    @PostMapping("/addmain")
    public String addmain(Maintenance maintenance){
        try {
            QueryWrapper mainqw=new QueryWrapper<Maintenance>();
            mainqw.eq("m_id",maintenance.getMId());
            if(maintenanceService.list(mainqw).size()>0){
                return "000001";
            }
            return maintenanceService.save(maintenance)?"000000":"-1";
        }catch (Exception ex){

        }
        return "";
    }



}

