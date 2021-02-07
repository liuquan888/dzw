package com.accp.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 车型表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    VehicleServiceImpl service;
    @RequestMapping("/findById")
    public List<Vehicle> findById(Vehicle v){
        QueryWrapper<Vehicle> query=new QueryWrapper<>();
        if(v.getCarcoding()!=null){
            query.eq("carcoding",v.getCarcoding());
        }
        if(v.getVehicleid()!=null){
            query.lambda().like(Vehicle::getVehicleid,v.getVehicleid());
        }
        if(v.getVehiclename()!=null){
            query.lambda().like(Vehicle::getVehiclename,v.getVehiclename());
        }
        List<Vehicle> list=service.list();
        return list;
    }
}

