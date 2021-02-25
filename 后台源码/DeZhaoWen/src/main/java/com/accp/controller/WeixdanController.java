package com.accp.controller;


import com.accp.domain.*;
import com.accp.service.impl.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
}

