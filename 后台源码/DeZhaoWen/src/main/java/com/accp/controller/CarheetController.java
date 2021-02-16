package com.accp.controller;


import com.accp.domain.*;
import com.accp.service.impl.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 车辆资料表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/carheet")
public class CarheetController {
    @Autowired
    CarheetServiceImpl service;
    @Autowired
    CarbrandServiceImpl brandService;
    @Autowired
    CaraffiliationServiceImpl cacservice;
    @Autowired
    EngineServiceImpl engservice;
    @Autowired
    MaintenancesServiceImpl maservice;

    @RequestMapping("/find")
    public List<Carheet> find(Carheet car){
        QueryWrapper<Carheet> queryWrapper=new QueryWrapper<>();
        if (car.getKh().getCustomernum()!=null){

        }
        if (car.getKh().getCustomername()!=null){

        }
        if (car.getKh().getCustomertypeid()!=null){

        }
        if (car.getKh().getLinkman()!=null){

        }
        if (car.getKh().getPhone()!=null){

        }
        if (car.getKh().getCustomeraddress()!=null){

        }
        if (car.getKh().getRemark()!=null){

        }
        if (car.getKh().getCustomernumber()!=null){

        }
        if (car.getKh().getBirthday()!=null){

        }
        if (car.getKh().getCounselorid()!=null){

        }
        if (car.getPlatename()!=null){
            queryWrapper.like("platename",car.getPlatename());
        }
        if (car.getCarbrandid()!=null){
            queryWrapper.eq("carbrandid",car.getCarbrandid());
        }
        if (car.getFramnum()!=null){
            queryWrapper.like("framnum",car.getFramnum());
        }
        if (car.getEnginenum()!=null){
            queryWrapper.like("enginenum",car.getEnginenum());
        }
        if (car.getEngineid()!=null){
            queryWrapper.eq("engineid",car.getEngineid());
        }
        if (car.getDriver()!=null){
            queryWrapper.like("driver",car.getDriver());
        }
        if (car.getDriverphone()!=null){
            queryWrapper.like("driverphone",car.getDriverphone());
        }
        if (car.getKh().getJe1()!=null&&car.getKh().getJe2()!=null){
            queryWrapper.between("earnest",car.getKh().getJe1(),car.getKh().getJe2());
        }
        if (car.getKh().getYe1()!=null&&car.getKh().getYe2()!=null){
            queryWrapper.between("vipprice",car.getKh().getYe1(),car.getKh().getYe2());
        }
        if(car.getKh().getJf1()!=null&&car.getKh().getJf2()!=null){
            queryWrapper.between("integral",car.getKh().getJf1(),car.getKh().getJf2());
        }
        if (car.getJq1()!=null&&car.getJq2()!=null){

        }
        if (car.getSy1()!=null&&car.getSy2()!=null){

        }
        if (car.getSp1()!=null&&car.getSp2()!=null){

        }
        if (car.getGm1()!=null&&car.getGm2()!=null){

        }
        if (car.getKh().getJe1()!=null&&car.getKh().getJe2()!=null){
            queryWrapper.between("earnest",car.getKh().getJe1(),car.getKh().getJe2());
        }
        if (car.getKh().getYe1()!=null&&car.getKh().getYe2()!=null){
            queryWrapper.between("vipprice",car.getKh().getYe1(),car.getKh().getYe2());
        }
        if(car.getKh().getJf1()!=null&&car.getKh().getJf2()!=null){
            queryWrapper.between("integral",car.getKh().getJf1(),car.getKh().getJf2());
        }
        if (car.getKh().getRh1()!=null&&car.getKh().getRh2()!=null){
            queryWrapper.between("jointime",car.getKh().getRh1(),car.getKh().getRh2());
        }
        if (car.getKh().getDq1()!=null&&car.getKh().getDq2()!=null){
            queryWrapper.between("outtime",car.getKh().getDq1(),car.getKh().getDq2());
        }
        List<Carheet> list=service.list(queryWrapper);
        for (Carheet ca:list){
            if (ca.getCarbrandid()!=null){
                Carbrand band=brandService.getById(ca.getCarbrandid());
                ca.setPp(band.getBrandname());
            }
            if (ca.getCaraffiliationid()!=null){
                Caraffiliation cac=cacservice.getById(ca.getCaraffiliationid());
                ca.setGs(cac.getCaraffiliation());
            }
            if (ca.getEngineid()!=null){
                Engine eng=engservice.getById(ca.getEngineid());
                ca.setFdj(eng.getEName());
            }
        }
        return list;
    }
    @RequestMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id){
        QueryWrapper<Maintenances> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("chepai",id);
        boolean bo=maservice.remove(queryWrapper);
        if (bo){
            return service.removeById(id);
        }else {
            return false;
        }
    }
    @RequestMapping("/insert")
    public boolean insert(Carheet car){
        return service.save(car);
    }
    @RequestMapping("/update")
    public boolean update(Carheet car){
        return service.updateById(car);
    }
    @RequestMapping("/findById/{id}")
    public Carheet findById(@PathVariable Integer id){
        return service.getById(id);
    }
}

