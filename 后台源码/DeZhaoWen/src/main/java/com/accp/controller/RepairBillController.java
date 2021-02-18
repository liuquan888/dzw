package com.accp.controller;


import com.accp.domain.*;
import com.accp.service.impl.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import java.util.List;

/**
 * <p>
 * 维修单据表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@RestController
@RequestMapping("/repairBill")
public class RepairBillController {

    //维修单据Service
    @Autowired
    RepairBillServiceImpl service;

    //单据类型Service
    @Autowired
    BillstypeServiceImpl btService;

    //结算类型Service
    @Autowired
    ClearingFormServiceImpl cfService;

    //结算状态Service
    @Autowired
    SettlementStatusServiceImpl ssService;

    //单据状态Service
    @Autowired
    DocumentStatusServiceImpl dsService;

    //车牌Service
    @Autowired
    PlatenumberServiceImpl pService;

    //服务顾问Service
    @Autowired
    CounselorServiceImpl counService;

    @Autowired
    MaintenanceItemsServiceImpl miService;

    @Autowired
    GetMaterialServiceImpl gmService;
    //结算中心-查询（条件模糊查询）

    @Autowired
    ClearingServiceImpl cleService;

    @Autowired
    CarheetServiceImpl CarService;

    @Autowired
    FactoryServiceImpl fser;

    @RequestMapping("/find")
    @ResponseBody
    public List<RepairBill> find(Integer documentsType,Integer balanceState, String date1, String date2, String no, Integer jsType, String chepaiNo, String name, Integer ywType, String remark, String jiesuanRen, Integer documentsState){
        QueryWrapper qw=new QueryWrapper<RepairBill>();
        System.out.println(date1);
        System.out.println(date2);
        if (date1!=null&&date2!=null){
            qw.between("completion_time",date1,date2);
        }

        if(no!=null){
            qw.like("no",no);
        }
        if(documentsType!=null){
            qw.eq("documents_type",documentsType);
        }
        if(jsType!=null){
            qw.eq("balanceState",jsType);
        }
        if(chepaiNo!=null){
            qw.like("chepaiNo",chepaiNo);
        }
        if (jiesuanRen!=null){
            qw.like("jiesuan_ren",jiesuanRen);
        }
        if(name!=null){
            qw.like("keihu_name",name);
        }
        if(ywType!=null){
            qw.eq("yewulx",ywType);
        }
        if(documentsState!=null){
            qw.eq("documents_state",documentsState);
        }
        if(remark!=null){
            qw.like("remark",remark);
        }

        if(balanceState!=null){
            qw.eq("balance_state",balanceState);
        }

        List<RepairBill> list = service.list(qw);

        for (RepairBill rb:list){
            if(rb.getDocumentsType()!=null){
                Billstype billstype=btService.getById(rb.getDocumentsType());
                rb.setDType(billstype.getType());
            }

            if(rb.getBalanceType()!=null){
                ClearingForm cf= cfService.getById(rb.getBalanceType());
                rb.setBType(cf.getType());
            }

            if(rb.getDocumentsState()!=null){
                SettlementStatus ss= ssService.getById(rb.getDocumentsState());
                rb.setBState(ss.getType());
            }

            if(rb.getBalanceState()!=null){
                DocumentStatus ds=dsService.getById(rb.getBalanceState());
                rb.setDState(ds.getType());
            }

            if(rb.getChepaiNo()!=null){
                Platenumber p=pService.getById(rb.getChepaiNo());
                rb.setChepai(p.getPlatename());
            }

            if(rb.getCounsellor()!=null){
                Counselor c= counService.getById(rb.getCounsellor());
                rb.setCoun(c.getCounselorname());
            }
        }
        return list;
    }


    @RequestMapping("/givemoney")
    public int givemoney(String no,Double sum){
        RepairBill bill=new RepairBill();
        bill.setNo(no);
        bill.setDocumentsState(1);
        bill.setAmount(sum);
        service.updateById(bill);
        return 1;
    }

    @RequestMapping("/find2")
    public  List<Billstype> find2(){
        return btService.list();
    }

    @RequestMapping("/find3")
    public  List<MaintenanceItems> find3(){
        return miService.list();
    }

    @RequestMapping("/find4")
    public  List<GetMaterial> find4(){
        return gmService.list();
    }

    @RequestMapping("/find5")
    public  List<Clearing> find5(){
        return cleService.list();
    }

    @RequestMapping("/findDay")
    public  List<GetMaterial> findday(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式

        QueryWrapper qw=new QueryWrapper<GetMaterial>();

        qw.eq("lingliaodate",df.format(new Date()));

        return gmService.list(qw);
    }

    @RequestMapping("/findCar")
    public  List<Carheet> findcar(){
        return CarService.list();
    }

    @RequestMapping("/findF")
    public List<Factory> findF(){ return fser.list(); }
}

