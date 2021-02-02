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

    //查询适用于条件查询
    @RequestMapping("/find")
    @ResponseBody
    public List<RepairBill> find(Date date1, Date date2, String no, Integer jsType, String chepaiNo, String name, Integer ywType, String remark, Integer counsellor, Integer documentsState){
        QueryWrapper qw=new QueryWrapper<RepairBill>();
        System.out.println(date1);
        System.out.println(date2);
        if (date1!=null&&date2!=null){
            qw.between("completionTime",date1,date2);
        }

        if(no!=null){
            qw.lt("no",no);
        }
        if(jsType!=null){
            qw.lt("balanceState",jsType);
        }
        if(chepaiNo!=null){
            qw.lt("chepaiNo",chepaiNo);
        }
        if (counsellor!=null){
            qw.lt("counsellor",counsellor);
        }
        if(name!=null){
            qw.lt("keihuName",name);
        }
        if(ywType!=null){
            qw.lt("yewulx",ywType);
        }
        if(documentsState!=null){
            qw.lt("documentsState",documentsState);
        }
        if(remark!=null){
            qw.lt("remark",remark);
        }

        List<RepairBill> list = service.list(qw);
        for (RepairBill rb:list){
            Billstype billstype=btService.getById(rb.getDocumentsType());
            rb.setDType(billstype.getType());

            ClearingForm cf= cfService.getById(rb.getBalanceType());
            rb.setBType(cf.getType());

            SettlementStatus ss= ssService.getById(rb.getDocumentsState());
            rb.setBState(ss.getType());

            DocumentStatus ds=dsService.getById(rb.getBalanceState());
            rb.setDState(ds.getType());

//            System.out.println(rb.getChepaiNo());
//            Platenumber p= pService.getById(rb.getChepaiNo());
//            System.out.println(p.getPlatename());
//            rb.setCp(p.getPlatename());
        }
        return list;
    }


}

