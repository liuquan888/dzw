package com.accp.controller;


import com.accp.domain.*;
import com.accp.service.impl.CarheetServiceImpl;
import com.accp.service.impl.CounselorServiceImpl;
import com.accp.service.impl.CustomerServiceImpl;
import com.accp.service.impl.CustomertypeServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 客户表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerServiceImpl Service;

    @Autowired
    CarheetServiceImpl carservice;

    @Autowired
    CustomertypeServiceImpl typeservice;

    @Autowired
    CounselorServiceImpl counservice;
    //根据客户Id查询
    @RequestMapping("/selectClientInformationByClientId")
    public Customer selectClientInformationByClientId(String clientId){
        Customer list=Service.getById(clientId);
        return list;
    }
    @RequestMapping("/findss")
    public Customer findss(String customernum){
        QueryWrapper<Customer> queryWrapper=new QueryWrapper<>();
        if (customernum!=null){
            queryWrapper.eq("customernum",customernum);
        }
        return Service.list(queryWrapper).get(0);
    }
    @RequestMapping("/selectClientInfo")
    public List<Customer> selectClientInfo(){
        List<Customer> list=Service.list();
        return list;
    }
    @RequestMapping("/insertCustomerAndCarheet")
    public boolean insertCustomerAndCarheet(Coll coll){
        boolean bo=Service.save(coll.getClient());
        if (bo){
            return carservice.save(coll.getCarInfo());
        }else {
            return false;
        }
    }
    @RequestMapping("/findAll")
    public List<Customer> findAll(Customer cu) {
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        if (cu.getCustomernum() != null) {
            queryWrapper.eq("customernum", cu.getCustomernum());
        }
        if (cu.getCustomername() != null) {
            queryWrapper.like("customername", cu.getCustomername());
        }
        if (cu.getCustomeraddress() != null) {
            queryWrapper.like("customeraddress", cu.getCustomeraddress());
        }
        if (cu.getLinkman()!=null){
            queryWrapper.like("linkman",cu.getLinkman());
        }
        if(cu.getPhone()!=null){
            queryWrapper.like("linkman",cu.getPhone());
        }
        if(cu.getBirthday()!=null){
            queryWrapper.eq("birthday",cu.getBirthday());
        }
        if(cu.getCustomertypeid()!=null){
            queryWrapper.eq("customertypeid",cu.getCustomertypeid());
        }
        if (cu.getCustomernumber()!=null){
            queryWrapper.like("customernumber",cu.getCustomernumber());
        }
        if (cu.getRh1()!=null&&cu.getRh2()!=null){
            queryWrapper.between("jointime",cu.getRh1(),cu.getRh2());
        }
        if (cu.getDq1()!=null&&cu.getDq2()!=null){
            queryWrapper.between("outtime",cu.getDq1(),cu.getDq2());
        }
        if (cu.getRemark()!=null){
            queryWrapper.like("remark",cu.getRemark());
        }
        if (cu.getCounselorid()!=null){
            queryWrapper.eq("counselorid",cu.getCounselorid());
        }
        if (cu.getJe1()!=null&&cu.getJe2()!=null){
            queryWrapper.between("earnest",cu.getJe1(),cu.getJe2());
        }
        if (cu.getYe1()!=null&&cu.getYe2()!=null){
            queryWrapper.between("vipprice",cu.getYe1(),cu.getYe2());
        }
        if(cu.getJf1()!=null&&cu.getJf2()!=null){
            queryWrapper.between("integral",cu.getJf1(),cu.getJf2());
        }
        if (cu.getCar()!=null){
            if (cu.getCar().getDriver()!=null){
                QueryWrapper<Carheet> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.like("driver",cu.getCar().getDriver());
                List<Carheet> car=carservice.list(queryWrapper1);
                for (Carheet ca:car){
                    queryWrapper.eq("customernum",ca.getCustomernum());
                }
            }
            if (cu.getCar().getPlatename()!=null){
                QueryWrapper<Carheet> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.like("platename",cu.getCar().getPlatename());
                List<Carheet> car=carservice.list(queryWrapper1);
                for (Carheet ca:car){
                    queryWrapper.eq("customernum",ca.getCustomernum());
                }
            }
            if (cu.getCar().getEnginenum()!=null){
                QueryWrapper<Carheet> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.like("enginenum",cu.getCar().getEnginenum());
                List<Carheet> car=carservice.list(queryWrapper1);
                for (Carheet ca:car){
                    queryWrapper.eq("customernum",ca.getCustomernum());
                }
            }
            if (cu.getCar().getDriverphone()!=null){
                QueryWrapper<Carheet> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.like("driverphone",cu.getCar().getDriverphone());
                List<Carheet> car=carservice.list(queryWrapper1);
                for (Carheet ca:car){
                    queryWrapper.eq("customernum",ca.getCustomernum());
                }
            }
            if (cu.getCar().getJq1()!=null&&cu.getCar().getJq2()!=null){
                QueryWrapper<Carheet> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.between("mliouttime",cu.getCar().getJq1(),cu.getCar().getJq2());
                List<Carheet> car=carservice.list(queryWrapper1);
                for (Carheet ca:car){
                    queryWrapper.eq("customernum",ca.getCustomernum());
                }
            }
            if (cu.getCar().getSy1()!=null&&cu.getCar().getSy2()!=null){
                QueryWrapper<Carheet> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.between("ciouttime",cu.getCar().getSy1(),cu.getCar().getSy2());
                List<Carheet> car=carservice.list(queryWrapper1);
                for (Carheet ca:car){
                    queryWrapper.eq("customernum",ca.getCustomernum());
                }
            }
            if (cu.getCar().getSp1()!=null&&cu.getCar().getSp2()!=null){
                QueryWrapper<Carheet> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.between("uptime",cu.getCar().getSp1(),cu.getCar().getSp2());
                List<Carheet> car=carservice.list(queryWrapper1);
                for (Carheet ca:car){
                    queryWrapper.eq("customernum",ca.getCustomernum());
                }
            }
            if (cu.getCar().getGm1()!=null&&cu.getCar().getGm2()!=null){
                QueryWrapper<Carheet> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.between("buytime",cu.getCar().getGm1(),cu.getCar().getGm2());
                List<Carheet> car=carservice.list(queryWrapper1);
                for (Carheet ca:car){
                    queryWrapper.eq("customernum",ca.getCustomernum());
                }
            }
            if (cu.getCar().getCarbrandid()!=null){
                QueryWrapper<Carheet> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.eq("carbrandid",cu.getCar().getCarbrandid());
                List<Carheet> car=carservice.list(queryWrapper1);
                for (Carheet ca:car){
                    queryWrapper.eq("customernum",ca.getCustomernum());
                }
            }
            if (cu.getCar().getFramnum()!=null){
                QueryWrapper<Carheet> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.like("framnum",cu.getCar().getCarbrandid());
                List<Carheet> car=carservice.list(queryWrapper1);
                for (Carheet ca:car){
                    queryWrapper.eq("customernum",ca.getCustomernum());
                }
            }
            if (cu.getCar().getEngineid()!=null){
                QueryWrapper<Carheet> queryWrapper1=new QueryWrapper<>();
                queryWrapper1.like("engineid",cu.getCar().getEngineid());
                List<Carheet> car=carservice.list(queryWrapper1);
                for (Carheet ca:car){
                    queryWrapper.eq("customernum",ca.getCustomernum());
                }
            }
        }
        List<Customer> list=Service.list(queryWrapper);
        for (Customer cus:list){
            if (cus.getCustomertypeid()!=null){
                Customertype type=typeservice.getById(cus.getCustomertypeid());
                cus.setLeibie(type.getCustomertypeid());
            }
            if (cus.getCounselorid()!=null) {
                Counselor cou = counservice.getById(cus.getCounselorid());
                cus.setFw(cou.getCounselorname());
            }
        }
        return list;
    }
    @RequestMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){

        QueryWrapper<Carheet> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("customernum",id);
        boolean bo=carservice.remove(queryWrapper);

        if (bo){
            boolean bool=Service.removeById(id);
            return bool;
        }else {
            return false;
        }
    }
    @RequestMapping("/insert")
    public boolean insert(Customer cus){
        boolean bool=Service.save(cus);
        if (cus.getCar()!=null&&bool){
            carservice.save(cus.getCar());
        }
        return bool;
    }
    @RequestMapping("/finds")
    public List<Customer> finds(){
        return Service.list();
    }
    @RequestMapping("/update")
    public boolean update(Customer cus){
        return Service.updateById(cus);
    }
    @RequestMapping("/findById/{id}")
    public Customer findById(@PathVariable String id){
        return Service.getById(id);
    }



     //马威书写（以下）
    @RequestMapping("/find")
    public List<Customer> find(String data1,String  data2,String customernumber,String phone,String customername,String bankaccount,String remark){
        QueryWrapper qw=new QueryWrapper<Customer>();
        if(data1!=null && data2!=null){
            qw.between("jointime",data1,data2);
        }
        if(customernumber!=null){
            qw.like("customernumber",customernumber);
        }
        if(phone!=null){
            qw.like("phone",phone);
        }
        if(customername!=null){
            qw.like("customername",customername);
        }
        if(bankaccount!=null){
            qw.like("bankaccount",bankaccount);
        }
        if(remark!=null){
            qw.like("remark",remark);
        }
        List<Customer> list=Service.list(qw);
        return list;
    }
    @RequestMapping("/pay")
    public Integer pay(String id,Integer money){
        Customer c=Service.getById(id);
        Customer customer=new Customer();
        customer.setCustomernum(id);
        customer.setVipprice(c.getVipprice()+money);
        boolean b = Service.updateById(customer);
        if(b)
            return 0000;
        else
            return 0100;
    }
}

