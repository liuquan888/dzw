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



    //根据驾驶员姓名查询
    @RequestMapping("/queryCarInformationByCondition")
    public List<Carheet> queryCarInformationByCondition(String condition){
        QueryWrapper<Carheet> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("driver",condition);
        List<Carheet> lastlist=service.list(queryWrapper);
        return lastlist;
    }
    @RequestMapping("updateByplatename")
    public boolean updateByplatename(Carheet car){
        QueryWrapper<Carheet> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("platename",car.getPlatename());
        return service.update(queryWrapper);
    }
    //根据条件查询
    @RequestMapping("/selectCarInformationByCondition")
    public List<Carheet> selectCarInformationByCondition(@RequestBody Coll coll){
        checkObjectIsNullUtils checkUtils= new checkObjectIsNullUtils();
        List<Carheet> list=service.list();
        List<Carheet> firstlist=new ArrayList<Carheet>();
        List<Carheet> qwelist=new ArrayList<Carheet>();
        List<Carheet> lastlist=new ArrayList<Carheet>();
        if(coll==null) {
            lastlist=list;
        }else {
            boolean flag1=checkUtils.objCheckIsNull(coll.getCarInfo());
            boolean flag2=checkUtils.objCheckIsNull(coll.getClient());
            System.out.println(flag1+"+"+flag2);
            if(flag1==true&&flag2==true) {
                lastlist=list;
            }else if(flag1==true&&flag2==false) {
                QueryWrapper<Customer> queryWrapper=new QueryWrapper<>();
                if(coll.getClient().getCustomernum()!=null&&coll.getClient().getCustomernum().length()>0) {
                    queryWrapper.eq("customernum",coll.getClient().getCustomernum());
                }
                if(coll.getClient().getCustomername()!=null&&coll.getClient().getCustomername().length()>0) {
                    queryWrapper.like("customername",coll.getClient().getCustomername());
                }
                if(coll.getClient().getCustomertypeid()!=null&&coll.getClient().getCustomertypeid()>0) {
                    queryWrapper.eq("customertypeid",coll.getClient().getCustomertypeid());
                }
                if(coll.getClient().getLinkman()!=null&&coll.getClient().getLinkman().length()>0) {
                    queryWrapper.like("linkman",coll.getClient().getLinkman());
                }
                if(coll.getClient().getPhone()!=null&&coll.getClient().getPhone().length()>0) {
                    queryWrapper.eq("phone",coll.getClient().getPhone());
                }
                if(coll.getClient().getCustomeraddress()!=null&&coll.getClient().getCustomeraddress().length()>0) {
                    queryWrapper.eq("customeraddress",coll.getClient().getCustomeraddress());
                }
                if(coll.getClient().getRemark()!=null&&coll.getClient().getRemark().length()>0) {
                    queryWrapper.eq("remark",coll.getClient().getRemark());
                }
                if(coll.getClient().getBirthday()!=null) {
                    queryWrapper.eq("birthday()",coll.getClient().getBirthday());
                }
                if(coll.getClient().getCounselorid()!=null&&coll.getClient().getCounselorid()>0) {
                    queryWrapper.eq("counselorid()",coll.getClient().getCounselorid());
                }
                if(coll.getClient().getReserved4()!=null&&coll.getClient().getReserved4().length()>0) {
                    queryWrapper.eq("reserved4",coll.getClient().getReserved4());
                }
                if(coll.getClient().getReserved1()!=null&&coll.getClient().getReserved1().length()>0) {
                    queryWrapper.eq("reserved1",coll.getClient().getReserved1());
                }
                if(coll.getClient().getReserved2()!=null&&coll.getClient().getReserved2().length()>0) {
                    queryWrapper.eq("reserved2",coll.getClient().getReserved2());
                }
                if(coll.getClient().getReserved3()!=null&&coll.getClient().getReserved3().length()>0) {
                    queryWrapper.eq("reserved3",coll.getClient().getReserved3());
                }
                List<Customer> clientList=cuservice.list(queryWrapper);
                for(int a=0;a<list.size();a++) {
                    for(int b=0;b<clientList.size();b++) {
                        if(list.get(a).getCustomernum().equals(clientList.get(b).getCustomernum())) {
                            firstlist.add(list.get(a));
                            break;
                        }
                    }
                }
                lastlist=firstlist;
            }else if(flag1==false&&flag2==true) {
                QueryWrapper<Carheet> queryWrapper=new QueryWrapper<>();
                if(coll.getCarInfo().getPlatename()!=null&&coll.getCarInfo().getPlatename().length()>0) {
                    queryWrapper.eq("carnum()",coll.getCarInfo().getCarnum());
                }
                if(coll.getCarInfo().getCarbrandid()!=null) {
                    queryWrapper.eq("carbrandid()",coll.getCarInfo().getCarbrandid());
                }

                if(coll.getCarInfo().getFramnum()!=null&&coll.getCarInfo().getFramnum().length()>0) {
                    queryWrapper.eq("framnum",coll.getCarInfo().getFramnum());
                }
                if(coll.getCarInfo().getEnginenum()!=null&&coll.getCarInfo().getEnginenum().length()>0) {
                   queryWrapper.eq("enginenum",coll.getCarInfo().getEnginenum());
                }

                if(coll.getCarInfo().getEngineid()!=null&&coll.getCarInfo().getEngineid()>0) {
                    queryWrapper.eq("engineid",coll.getCarInfo().getEngineid());
                }
                if(coll.getCarInfo().getDriver()!=null) {
                    queryWrapper.eq("driver",coll.getCarInfo().getDriver());
                }
                if(coll.getCarInfo().getDriverphone()!=null&&coll.getCarInfo().getDriverphone().length()>0) {
                    queryWrapper.eq("driverphone", coll.getCarInfo().getDriverphone());
                }
                List<Carheet> carinfolist=service.list(queryWrapper);
                for(int a=0;a<list.size();a++) {
                    for(int b=0;b<carinfolist.size();b++) {
                        if(list.get(a).getCarnum().equals(carinfolist.get(b).getCarnum())) {
                            firstlist.add(list.get(a));
                            break;
                        }
                    }
                }
                lastlist=firstlist;
            }else if(flag1==false&&flag2==false) {
                QueryWrapper<Customer> queryWrapper=new QueryWrapper<>();
                if(coll.getClient().getCustomernum()!=null&&coll.getClient().getCustomernum().length()>0) {
                    queryWrapper.eq("Customernum",coll.getClient().getCustomernum());
                }
                if(coll.getClient().getCustomername()!=null&&coll.getClient().getCustomername().length()>0) {
                    queryWrapper.like("Customername",coll.getClient().getCustomername());
                }
                if(coll.getClient().getCustomertypeid()!=null&&coll.getClient().getCustomertypeid()>0) {
                    queryWrapper.eq("Customertypeid",coll.getClient().getCustomertypeid());
                }
                if(coll.getClient().getLinkman()!=null&&coll.getClient().getLinkman().length()>0) {
                    queryWrapper.like("Linkman",coll.getClient().getLinkman());
                }
                if(coll.getClient().getPhone()!=null&&coll.getClient().getPhone().length()>0) {
                    queryWrapper.eq("Phone",coll.getClient().getPhone());
                }
                if(coll.getClient().getCustomeraddress()!=null&&coll.getClient().getCustomeraddress().length()>0) {
                    queryWrapper.eq("Customeraddress",coll.getClient().getCustomeraddress());
                }
                if(coll.getClient().getRemark()!=null&&coll.getClient().getRemark().length()>0) {
                    queryWrapper.eq("Remark",coll.getClient().getRemark());
                }
                if(coll.getClient().getBirthday()!=null) {
                    queryWrapper.eq("Birthday()",coll.getClient().getBirthday());
                }
                if(coll.getClient().getCounselorid()!=null&&coll.getClient().getCounselorid()>0) {
                    queryWrapper.eq("Counselorid()",coll.getClient().getCounselorid());
                }
                if(coll.getClient().getReserved4()!=null&&coll.getClient().getReserved4().length()>0) {
                    queryWrapper.eq("Reserved4",coll.getClient().getReserved4());
                }
                if(coll.getClient().getReserved1()!=null&&coll.getClient().getReserved1().length()>0) {
                    queryWrapper.eq("Reserved1",coll.getClient().getReserved1());
                }
                if(coll.getClient().getReserved2()!=null&&coll.getClient().getReserved2().length()>0) {
                    queryWrapper.eq("Reserved2",coll.getClient().getReserved2());
                }
                if(coll.getClient().getReserved3()!=null&&coll.getClient().getReserved3().length()>0) {
                    queryWrapper.eq("getReserved3",coll.getClient().getReserved3());
                }
                List<Customer> clientList=cuservice.list(queryWrapper);
                for(int a=0;a<list.size();a++) {
                    for(int b=0;b<clientList.size();b++) {
                        if(list.get(a).getCustomernum().equals(clientList.get(b).getCustomernum())) {
                            firstlist.add(list.get(a));
                            break;
                        }
                    }
                }
                QueryWrapper<Carheet> queryWrapper1=new QueryWrapper<>();
                if(coll.getCarInfo().getPlatename()!=null&&coll.getCarInfo().getPlatename().length()>0) {
                    queryWrapper1.eq("Carnum()",coll.getCarInfo().getCarnum());
                }
                if(coll.getCarInfo().getCarbrandid()!=null) {
                    queryWrapper1.eq("Carbrandid()",coll.getCarInfo().getCarbrandid());
                }

                if(coll.getCarInfo().getFramnum()!=null&&coll.getCarInfo().getFramnum().length()>0) {
                    queryWrapper1.eq("Framnum",coll.getCarInfo().getFramnum());
                }
                if(coll.getCarInfo().getEnginenum()!=null&&coll.getCarInfo().getEnginenum().length()>0) {
                    queryWrapper1.eq("Enginenum",coll.getCarInfo().getEnginenum());
                }
                if(coll.getCarInfo().getReserved1()!=null&&coll.getCarInfo().getReserved1().length()>0) {
                    queryWrapper1.eq("Reserved1",coll.getCarInfo().getReserved1());
                }
                if(coll.getCarInfo().getEngineid()!=null&&coll.getCarInfo().getEngineid()>0) {
                    queryWrapper1.eq("Engineid",coll.getCarInfo().getEngineid());
                }
                if(coll.getCarInfo().getDriver()!=null) {
                    queryWrapper1.eq("Driver",coll.getCarInfo().getDriver());
                }
                if(coll.getCarInfo().getDriverphone()!=null&&coll.getCarInfo().getDriverphone().length()>0) {
                    queryWrapper1.eq("Driverphone", coll.getCarInfo().getDriverphone());
                }
                List<Carheet> carinfolist=service.list(queryWrapper1);
                for(int a=0;a<firstlist.size();a++) {
                    for(int b=0;b<carinfolist.size();b++) {
                        if(firstlist.get(a).getCarnum().equals(carinfolist.get(b).getCarnum())) {
                            qwelist.add(firstlist.get(a));
                            break;
                        }
                    }
                }
                lastlist=qwelist;
            }
        }
        return lastlist;
    }
    //查询所有
    @RequestMapping("/selectAllCarInfo")
    public List<Carheet> selectAllCarInfo(){
        List<Carheet> list=service.list();
        return list;
    }
    @RequestMapping("/findId")
    public List<Carheet> findId(String number){
        QueryWrapper<Carheet> queryWrapper=new QueryWrapper<>();
        if (number!=null){
            queryWrapper.like("platename",number);
        }
        List<Carheet> list=service.list(queryWrapper);
        return list;
    }
    //根据客户Id查询车辆信息
    @RequestMapping("/findIds")
    public Carheet findIds(String customernum){
        QueryWrapper<Carheet> queryWrapper=new QueryWrapper<>();
        if (customernum!=null){
            queryWrapper.like("platename",customernum);
        }
        List<Carheet> list=service.list(queryWrapper);
        return list.get(0);
    }
    @RequestMapping("findBybramch")
    public List<Carheet> finBybramch(String customernum){
        QueryWrapper<Carheet> queryWrapper=new QueryWrapper<>();
        if (customernum!=null){
            queryWrapper.eq("customernum",customernum);
        }
        return service.list(queryWrapper);
    }
    @RequestMapping("/deleteByplatename")
    public boolean deleteByplatename(String platename){
        QueryWrapper<Carheet> queryWrapper=new QueryWrapper<>();
        if (platename!=null){
            queryWrapper.eq("platename",platename);
        }
        return service.remove(queryWrapper);
    }
    @RequestMapping("/find")
    public List<Carheet> find(Carheet car){
        QueryWrapper<Carheet> queryWrapper=new QueryWrapper<>();
        if (car.getKh()!=null){
            if (car.getKh().getCustomernum()!=null){
                QueryWrapper<Customer> cuWrapper=new QueryWrapper<>();
                cuWrapper.eq("customernum",car.getKh().getCustomernum());
                List<Customer> cus=cuservice.list(cuWrapper);
                for (Customer cu:cus){
                    queryWrapper.eq("customernum",cu.getCustomernum());
                }
            }
            if (car.getKh().getCustomername()!=null){
                QueryWrapper<Customer> cuWrapper1=new QueryWrapper<>();
                cuWrapper1.like("customername",car.getKh().getCustomername());
                List<Customer> cus=cuservice.list(cuWrapper1);
                for (Customer cu:cus){
                    queryWrapper.eq("customernum",cu.getCustomernum());
                }
            }
            if (car.getKh().getCustomertypeid()!=null){
                QueryWrapper<Customer> cuWrapper2=new QueryWrapper<>();
                cuWrapper2.eq("customertypeid",car.getKh().getCustomertypeid());
                List<Customer> cus=cuservice.list(cuWrapper2);
                for (Customer cu:cus){
                    queryWrapper.eq("customernum",cu.getCustomernum());
                }
            }
            if (car.getKh().getLinkman()!=null){
                QueryWrapper<Customer> cuWrapper2=new QueryWrapper<>();
                cuWrapper2.like("linkman",car.getKh().getLinkman());
                List<Customer> cus=cuservice.list(cuWrapper2);
                for (Customer cu:cus){
                    queryWrapper.eq("customernum",cu.getCustomernum());
                }
            }
            if (car.getKh().getPhone()!=null){
                QueryWrapper<Customer> cuWrapper2=new QueryWrapper<>();
                cuWrapper2.like("phone",car.getKh().getPhone());
                List<Customer> cus=cuservice.list(cuWrapper2);
                for (Customer cu:cus){
                    queryWrapper.eq("customernum",cu.getCustomernum());
                }
            }
            if (car.getKh().getCustomeraddress()!=null){
                QueryWrapper<Customer> cuWrapper2=new QueryWrapper<>();
                cuWrapper2.like("customeraddress",car.getKh().getCustomeraddress());
                List<Customer> cus=cuservice.list(cuWrapper2);
                for (Customer cu:cus){
                    queryWrapper.eq("customernum",cu.getCustomernum());
                }
            }
            if (car.getKh().getRemark()!=null){
                QueryWrapper<Customer> cuWrapper2=new QueryWrapper<>();
                cuWrapper2.like("remark",car.getKh().getRemark());
                List<Customer> cus=cuservice.list(cuWrapper2);
                for (Customer cu:cus){
                    queryWrapper.eq("customernum",cu.getCustomernum());
                }
            }
            if (car.getKh().getCustomernumber()!=null){
                QueryWrapper<Customer> cuWrapper2=new QueryWrapper<>();
                cuWrapper2.like("customernumber",car.getKh().getCustomernumber());
                List<Customer> cus=cuservice.list(cuWrapper2);
                for (Customer cu:cus){
                    queryWrapper.eq("customernum",cu.getCustomernum());
                }
            }
            if (car.getKh().getBirthday()!=null){
                QueryWrapper<Customer> cuWrapper2=new QueryWrapper<>();
                cuWrapper2.like("birthday",car.getKh().getBirthday());
                List<Customer> cus=cuservice.list(cuWrapper2);
                for (Customer cu:cus){
                    queryWrapper.eq("customernum",cu.getCustomernum());
                }
            }
            if (car.getKh().getCounselorid()!=null){
                QueryWrapper<Customer> cuWrapper2=new QueryWrapper<>();
                cuWrapper2.like("counselorid",car.getKh().getCounselorid());
                List<Customer> cus=cuservice.list(cuWrapper2);
                for (Customer cu:cus){
                    queryWrapper.eq("customernum",cu.getCustomernum());
                }
            }
            if (car.getKh().getJe1()!=null&&car.getKh().getJe2()!=null){
                QueryWrapper<Customer> cuWrapper2=new QueryWrapper<>();
                cuWrapper2.between("earnest",car.getKh().getJe1(),car.getKh().getJe2());
                List<Customer> cus=cuservice.list(cuWrapper2);
                for (Customer cu:cus){
                    queryWrapper.eq("customernum",cu.getCustomernum());
                }
            }
            if (car.getKh().getYe1()!=null&&car.getKh().getYe2()!=null){
                QueryWrapper<Customer> cuWrapper2=new QueryWrapper<>();
                cuWrapper2.between("vipprice",car.getKh().getYe1(),car.getKh().getYe2());
                List<Customer> cus=cuservice.list(cuWrapper2);
                for (Customer cu:cus){
                    queryWrapper.eq("customernum",cu.getCustomernum());
                }
            }
            if(car.getKh().getJf1()!=null&&car.getKh().getJf2()!=null){
                QueryWrapper<Customer> cuWrapper2=new QueryWrapper<>();
                cuWrapper2.between("integral",car.getKh().getJf1(),car.getKh().getJf2());
                List<Customer> cus=cuservice.list(cuWrapper2);
                for (Customer cu:cus){
                    queryWrapper.eq("customernum",cu.getCustomernum());
                }
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

        if (car.getJq1()!=null&&car.getJq2()!=null){
           queryWrapper.between("mliouttime",car.getJq1(),car.getJq2());
        }
        if (car.getSy1()!=null&&car.getSy2()!=null){
            queryWrapper.between("ciouttime",car.getSy1(),car.getSy2());
        }
        if (car.getSp1()!=null&&car.getSp2()!=null){
            queryWrapper.between("uptime",car.getSp1(),car.getSp2());
        }
        if (car.getGm1()!=null&&car.getGm2()!=null){
            queryWrapper.between("buytime",car.getGm1(),car.getGm2());
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

