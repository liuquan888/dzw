package com.accp.controller;


import com.accp.domain.*;
import com.accp.service.impl.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @Autowired
    CustomerServiceImpl cuservice;

    @Autowired
    CarServiceImpl carService;

    //根据驾驶员姓名查询
    @RequestMapping("/queryCarInformationByCondition")
    public List<Carheet> queryCarInformationByCondition(String condition){
        QueryWrapper<Carheet> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("driver",condition);
        List<Carheet> lastlist=service.list(queryWrapper);
        for (Carheet car:lastlist){
            Carbrand brand=brandService.getById(car.getCarbrandid());
            if (brand!=null){
                car.setPp(brand.getBrandname());
            }
            Car c=carService.getById(car.getReserved5());
            if (c!=null){
                car.setChexing(c.getReserved1());
            }
            Engine engine=engservice.getById(car.getEngineid());
            if (engine!=null){
                car.setFdj(engine.getEName());
            }
        }
        for(int i=0;i<lastlist.size();i++) {
            if(i==0) {
                lastlist.get(i).setCheck(true);
            }else {
                lastlist.get(i).setCheck(false);
            }
        }
        return lastlist;
    }
    @RequestMapping("updateByplatename")
    public boolean updateByplatename(Carheet car){
        QueryWrapper<Carheet> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("platename",car.getPlatename());
        return service.update(queryWrapper);
    }
    @RequestMapping("/findX")
    public List<Carheet> findX(@RequestBody Coll cob){
        QueryWrapper<Carheet> queryWrapper=new QueryWrapper<>();
        if (cob!=null){
            if (cob.getCarInfo()!=null){
                if (cob.getCarInfo().getPlatename()!=null){
                    queryWrapper.eq("platename",cob.getCarInfo().getPlatename()).or();
                }
                if (cob.getCarInfo().getCarbrandid()!=null){
                    queryWrapper.eq("carbrandid",cob.getCarInfo().getCarbrandid()).or();
                }
                if (cob.getCarInfo().getReserved5()!=null){
                    queryWrapper.eq("reserved5",cob.getCarInfo().getReserved5()).or();
                }
                if (cob.getCarInfo().getFramnum()!=null){
                    queryWrapper.eq("framnum",cob.getCarInfo().getFramnum()).or();
                }
                if (cob.getCarInfo().getEnginenum()!=null){
                    queryWrapper.eq("enginenum",cob.getCarInfo().getEnginenum()).or();
                }
                if (cob.getCarInfo().getEngineid()!=null){
                    queryWrapper.eq("engineid",cob.getCarInfo().getEngineid()).or();
                }
                if (cob.getCarInfo().getDriver()!=null){
                    queryWrapper.eq("driver",cob.getCarInfo().getDriver()).or();
                }
                if (cob.getCarInfo().getDriverphone()!=null){
                    queryWrapper.eq("driverphone",cob.getCarInfo().getDriverphone()).or();
                }
                if (cob.getCarInfo().getBirthday()!=null){
                    queryWrapper.eq("birthday",cob.getCarInfo().getBirthday()).or();
                }
            }
            if (cob.getClient()!=null){
                QueryWrapper<Customer> queryWrapper1=new QueryWrapper<>();
                if (cob.getClient().getCustomernum()!=null){
                    queryWrapper1.eq("customernum",cob.getClient().getCustomernum()).or();
                }
                if (cob.getClient().getCustomername()!=null){
                    queryWrapper1.eq("customername",cob.getClient().getCustomername()).or();
                }
                if (cob.getClient().getCustomertypeid()!=null){
                    queryWrapper1.eq("customertypeid",cob.getClient().getCustomertypeid()).or();
                }
                if (cob.getClient().getLinkman()!=null){
                    queryWrapper1.eq("linkman",cob.getClient().getLinkman()).or();
                }
                if (cob.getClient().getPhone()!=null){
                    queryWrapper1.eq("phone",cob.getClient().getPhone()).or();
                }
                if (cob.getClient().getCustomeraddress()!=null){
                    queryWrapper1.eq("customeraddress",cob.getClient().getCustomeraddress()).or();
                }
                if (cob.getClient().getRemark()!=null){
                    queryWrapper1.eq("remark",cob.getClient().getRemark()).or();
                }
                if (cob.getClient().getBirthday()!=null){
                    queryWrapper1.eq("birthday",cob.getClient().getBirthday()).or();
                }
                List<Customer> list=cuservice.list(queryWrapper1);
                if (list.size()>0) {
                    for (Customer cus : list) {
                        queryWrapper.eq("customernum", cus.getCustomernum()).or();
                    }
                }
            }
            List<Carheet> list1=service.list(queryWrapper);
            if (list1.size()>0){
                for (Carheet car:list1){
                    Carbrand brand=brandService.getById(car.getCarbrandid());
                    if (brand!=null){
                        car.setPp(brand.getBrandname());
                    }
                    Car c=carService.getById(car.getReserved5());
                    if (c!=null){
                        car.setChexing(c.getReserved1());
                    }
                    Engine engine=engservice.getById(car.getEngineid());
                    if (engine!=null){
                        car.setFdj(engine.getEName());
                    }
                }
                for(int i=0;i<list1.size();i++) {
                    if(i==0) {
                        list1.get(i).setCheck(true);
                    }else {
                        list1.get(i).setCheck(false);
                    }
                }
            }
            return list1;
        }else {
            List<Carheet> list3=service.list();
            if (list3.size()>0){
                for (Carheet car:list3){
                    Carbrand brand=brandService.getById(car.getCarbrandid());
                    if (brand!=null){
                        car.setPp(brand.getBrandname());
                    }
                    Car c=carService.getById(car.getReserved5());
                    if (c!=null){
                        car.setChexing(c.getReserved1());
                    }
                    Engine engine=engservice.getById(car.getEngineid());
                    if (engine!=null){
                        car.setFdj(engine.getEName());
                    }
                }
                for(int i=0;i<list3.size();i++) {
                    if(i==0) {
                        list3.get(i).setCheck(true);
                    }else {
                        list3.get(i).setCheck(false);
                    }
                }
            }
            return list3;
        }
    }
    //根据条件查询

    //查询所有
    @RequestMapping("/selectAllCarInfo")
    public List<Carheet> selectAllCarInfo(){
        List<Carheet> list=service.list();
        if (list.size()>0){
            for (Carheet car:list){
                Carbrand brand=brandService.getById(car.getCarbrandid());
                if (brand!=null){
                    car.setPp(brand.getBrandname());
                }
                Car c=carService.getById(car.getReserved5());
                if (c!=null){
                    car.setChexing(c.getReserved1());
                }
                Engine engine=engservice.getById(car.getEngineid());
                if (engine!=null){
                    car.setFdj(engine.getEName());
                }
            }
            for(int i=0;i<list.size();i++) {
                if(i==0) {
                    list.get(i).setCheck(true);
                }else {
                    list.get(i).setCheck(false);
                }
            }
        }
        return list;
    }
    //根据ID查询指定信息
    @RequestMapping("/findId/{number}")
    public Carheet findId(@PathVariable String number){
        QueryWrapper<Carheet> queryWrapper=new QueryWrapper<>();
        if (number!=null){
            queryWrapper.eq("platename",number);
        }
        Carheet list=service.list(queryWrapper).get(0);
            Carbrand brand=brandService.getById(list.getCarbrandid());
            if (brand!=null){
                list.setPp(brand.getBrandname());
            }
            Car c=carService.getById(list.getReserved5());
            if (c!=null){
                list.setChexing(c.getReserved1());
            }
            Engine engine=engservice.getById(list.getEngineid());
            if (engine!=null){
                list.setFdj(engine.getEName());
            }
            list.setCheck(true);
        return list;
    }
    @RequestMapping("/findssss/{qwe}")
    public List<Carheet> findssss(@PathVariable String qwe){
        QueryWrapper<Carheet> queryWrapper=new QueryWrapper<>();
        if (qwe!=null){
            queryWrapper.like("customernum",qwe);
        }
        List<Carheet> list=service.list(queryWrapper);
        for (Carheet car:list){
            Carbrand brand=brandService.getById(car.getCarbrandid());
            if (brand!=null){
                car.setPp(brand.getBrandname());
            }
            Car c=carService.getById(car.getReserved5());
            if (c!=null){
                car.setChexing(c.getReserved1());
            }
            Engine engine=engservice.getById(car.getEngineid());
            if (engine!=null){
                car.setFdj(engine.getEName());
            }
        }
        for(int i=0;i<list.size();i++) {
            if(i==0) {
                list.get(i).setCheck(true);
            }else {
                list.get(i).setCheck(false);
            }
        }
        return list;
    }
    //根据客户Id查询车辆信息
    @RequestMapping("/findIds")
    public List<Carheet> findIds(@RequestBody Customer customer){
        QueryWrapper<Carheet> queryWrapper=new QueryWrapper<>();
        if (customer!=null){
            queryWrapper.like("customernum",customer.getCustomernum());
        }
        List<Carheet> list=service.list(queryWrapper);
        for (Carheet car:list){
            Carbrand brand=brandService.getById(car.getCarbrandid());
            if (brand!=null){
                car.setPp(brand.getBrandname());
            }
            Car c=carService.getById(car.getReserved5());
            if (c!=null){
                car.setChexing(c.getReserved1());
            }
            Engine engine=engservice.getById(car.getEngineid());
            if (engine!=null){
                car.setFdj(engine.getEName());
            }
        }
        for(int i=0;i<list.size();i++) {
            if(i==0) {
                list.get(i).setCheck(true);
            }else {
                list.get(i).setCheck(false);
            }
        }
        return list;
    }
    @RequestMapping("findBybramch")
    public List<Carheet> finBybramch(String customernum){
        QueryWrapper<Carheet> queryWrapper=new QueryWrapper<>();
        if (customernum!=null){
            queryWrapper.eq("customernum",customernum);
        }
        List<Carheet> list=service.list(queryWrapper);
        for(Carheet car:list){
            Carbrand brand=brandService.getById(car.getCarbrandid());
            car.setPp(brand.getBrandname());
            Car c=carService.getById(car.getReserved5());
            car.setChexing(c.getReserved1());
            Engine engine=engservice.getById(car.getEngineid());
            car.setFdj(engine.getEName());
        }
        for(int i=0;i<list.size();i++) {
            if(i==0) {
                list.get(i).setCheck(true);
            }else {
                list.get(i).setCheck(false);
            }
        }
        return list;
    }
    @RequestMapping("/deleteByplatename")
    public boolean deleteByplatename(Integer carnum){
        QueryWrapper<Carheet> queryWrapper=new QueryWrapper<>();
        if (carnum!=null){
            queryWrapper.eq("carnum",carnum);
        }
        return service.remove(queryWrapper);
    }

    @RequestMapping("/delete")
    public boolean delete(@PathVariable Integer number){
        QueryWrapper<Maintenances> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("chepai",number);
        boolean bo=maservice.remove(queryWrapper);
        if (bo){
            return service.removeById(number);
        }else {
            return false;
        }
    }
    @RequestMapping("/remove/{number}")
    public boolean remove(@PathVariable Integer number){
        QueryWrapper<Carheet> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("carnum",number);
        return service.remove(queryWrapper);
    }
    @RequestMapping("/insert")
    public boolean insert(@RequestBody Carheet car){
        return service.save(car);
    }
    @RequestMapping("/update")
    public boolean update(@RequestBody Carheet car){
        QueryWrapper<Carheet> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("carnum",car.getCarnum());
        return service.update(car,queryWrapper);
    }
    @RequestMapping("/findById/{id}")
    public Carheet findById(@PathVariable Integer id){
        Carheet car=service.getById(id);
        car.setCheck(true);
        return car;

    }
}

