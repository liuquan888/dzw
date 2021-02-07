package com.accp.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 维修单据表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/repairBill")
public class RepairBillController {

<<<<<<< HEAD
=======
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
    public List<RepairBill> find(String date1, String date2, String no, Integer jsType, String chepaiNo, String name, Integer ywType, String remark, String jiesuanRen, Integer documentsState){
        QueryWrapper qw=new QueryWrapper<RepairBill>();
        if (date1!=null&&date2!=null){
            qw.between("completionTime",date1,date2);
        }

        if(no!=null){
            qw.like("no",no);
        }
        if(jsType!=null){
            qw.eq("balanceState",jsType);
        }
        if(chepaiNo!=null){
            qw.like("chepaiNo",chepaiNo);
        }
        System.out.println(jiesuanRen);
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
            qw.eq("documentsState",documentsState);
        }
        if(remark!=null){
            qw.like("remark",remark);
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

//            System.out.println(rb.getChepaiNo());
//            Platenumber p= pService.getById(rb.getChepaiNo());
//            System.out.println(p.getPlatename());
//            rb.setCp(p.getPlatename());
        }
        return list;
    }


>>>>>>> 1602f9564542f755e444c629a7c1495a983617a3
}

