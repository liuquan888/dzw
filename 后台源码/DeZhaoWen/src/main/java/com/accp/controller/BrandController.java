package com.accp.controller;


import com.accp.domain.Brand;
import com.accp.domain.Car;
import com.accp.domain.Suppiler;
import com.accp.service.impl.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 车型品牌 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    BrandServiceImpl brandService;
    @Autowired
    CarServiceImpl carService;
    @Autowired
    EngineServiceImpl engineService;
    @Autowired
    SuppilerServiceImpl suppilerService;

    @GetMapping("/findall")
    public List<Brand> list(){
        return brandService.list();
    }

    @GetMapping("/findbyidcar/{bid}")
    public List<Car> carList(@PathVariable Integer bid){
        QueryWrapper qw=new QueryWrapper<Car>();
        qw.eq("b_id",bid);
        List<Car> list=carService.list(qw);
        for (Car car:list) {
            car.setEngine(engineService.getById(car.getEId()));
            QueryWrapper suppqw=new QueryWrapper<Suppiler>();
            suppqw.eq("p_id",car.getPId());
            Suppiler suppiler= (Suppiler) suppilerService.list(suppqw).get(0);
            car.setSuppiler(suppiler);
        }
        return list;
    }

    @PostMapping("/addbrand")
    public String addbrand(Brand brand){
        try {
            brandService.save(brand);
        }catch (Exception ex){
            return "编号不能重复";
        }
        return "添加品牌成功";
    }

    @GetMapping("/removebrand/{bid}")
    public String removebrand(@PathVariable Integer bid){
        
        return "55";
    }

}

