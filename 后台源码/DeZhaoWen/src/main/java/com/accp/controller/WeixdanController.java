package com.accp.controller;


import com.accp.domain.*;
import com.accp.service.impl.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-22
 */
@RestController
@RequestMapping("/weixdan")
public class WeixdanController {

    @Autowired
    WeixdanServiceImpl weixd;

    @Autowired
    MaintenanceItemsServiceImpl mainte;

    @Autowired
    PatternServiceImpl patte;

    @Autowired
    JcylServiceImpl jcy;

    @Autowired
    BusinessclassServiceImpl busine;

    @Autowired
    SgbcServiceImpl sgb;

    @Autowired
    FactoryServiceImpl fas;

    @Autowired
    DeparmentSurfaceServiceImpl depas;

    @Autowired
    CounselorServiceImpl cou;

    //维修单据Service
    @Autowired
    RepairBillServiceImpl service;

    //车牌Service
    @Autowired
    PlatenumberServiceImpl pService;

    //单据类型service
    @Autowired
    BillstypeServiceImpl bill;

    @Autowired
    CustomerServiceImpl cusi;

    @GetMapping("/findww/{weixdanhao}")
     public Weixdan weix(@PathVariable String weixdanhao){
         QueryWrapper q=new QueryWrapper<Weixdan>();
         if(weixdanhao!=""){
             q.eq("weixdanh",weixdanhao);
         }
        Weixdan w= (Weixdan) weixd.list(q).get(0);
        Pattern pattern=patte.getById(w.getFdjpp());
        w.setBlangName(pattern.getPaName());
        Jcyl  jcyl=jcy.getById(w.getJcyl());
        w.setJingc(jcyl.getYl());
        Businessclass buis=busine.getById(w.getYwlb());
        w.setYewuleib(buis.getBusinessleb());
        Sgbc sg=sgb.getById(w.getSgbc());
        w.setSgigbc(sg.getBanc());
        return w;
     }

     @GetMapping("/findchang")
    public List<Factory> show(){
        return fas.list();
     }

    @GetMapping("/findbums")
    public List<DeparmentSurface> shows(){
        return depas.list();
    }

    @GetMapping("/findwws/{bname}")
    public List<Counselor> findbm(@PathVariable String bname){
        if(bname.equals("sss")){
            return cou.list();
        }
        QueryWrapper<Counselor> query = new QueryWrapper<>();
        query.lambda().eq(Counselor::getBramch,bname);
        return cou.list(query);
    }



    @RequestMapping("/find")
    @ResponseBody
    public List<RepairBill> find(String date1, String date2,Integer chepaiNo,String chejiao_no,String reserved3,String chenshu){
        QueryWrapper qw=new QueryWrapper<RepairBill>();
        if (date1!=null&&date2!=null){
            qw.between("completion_time",date1,date2);
        }
        if(chepaiNo!=null){
            qw.like("chepai",chepaiNo);
        }
        if(chejiao_no!=null){
            qw.like("chejiao_no",chejiao_no);
        }
        if(chenshu!=null){
            qw.like("chenshu",chenshu);
        }
        if(reserved3!=null){
            qw.like("reserved3",reserved3);
        }
        List<RepairBill> list = service.list(qw);
        for (RepairBill rb:list){
            if(rb.getChepaiNo()!=null){
                Platenumber p=pService.getById(rb.getChepaiNo());
                rb.setChepai(p.getPlatename());
            }
            if(rb.getDocumentsType()!=null){
                Billstype b=bill.getById(rb.getDocumentsType());
                rb.setDState(b.getType());
            }
            if(rb.getCustomerId()!=null){
                Customer c=cusi.getById(rb.getCustomerId());
                rb.setChezhuxm(c.getCustomername());
            }

        }
        return list;
    }







}

