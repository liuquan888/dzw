package com.accp.controller;


import com.accp.domain.Carheet;
import com.accp.domain.Platenumber;
import com.accp.domain.Workcar;
import com.accp.service.impl.CarheetServiceImpl;
import com.accp.service.impl.PlatenumberServiceImpl;
import com.accp.service.impl.WorkcarServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 工作中的车辆 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/workcar")
public class WorkcarController {

    @Autowired
    WorkcarServiceImpl work;

    @Autowired
    PlatenumberServiceImpl plte;

    @Autowired
    CarheetServiceImpl carh;

    @GetMapping("/findworkdim/{workdimtext}")
    public List<Workcar> branddim(@PathVariable String workdimtext){
        try {
            if (workdimtext.equals("56d56f6e56d65e85ads8562ar52da96q57")){
                return this.carList();
            }

            if(workdimtext!=null){
                QueryWrapper<Workcar> brandqw=new QueryWrapper();
                brandqw.and(wrapper -> wrapper.like("chepaih",workdimtext)
                        .or()
                        .like("phone", workdimtext)
                        .or()
                        .like("reserved1",workdimtext)
                );
                List<Workcar> list=work.list(brandqw);
                for (Workcar w:list) {
                    QueryWrapper plqw=new QueryWrapper<Platenumber>();
                    plqw.eq("plateid",w.getChepaih());
                    Platenumber p=(Platenumber) plte.list(plqw).get(0);
                    w.setPlatenumber(p);
                }
                return list;
            }

        }catch (Exception ex){
            System.out.print("出错了！");
        }
        return this.carList();
    }



    @GetMapping("/findworks")
    public List<Workcar> carList(){
        List<Workcar> list=work.list();
        for (Workcar w:list) {
            QueryWrapper plqw=new QueryWrapper<Platenumber>();
            plqw.eq("plateid",w.getChepaih());
            Platenumber p=(Platenumber) plte.list(plqw).get(0);
            w.setPlatenumber(p);
        }
        return list;
    }

    @GetMapping("/findworkdims/{chepai}")
    public Carheet CarList(@PathVariable String chepai){
        QueryWrapper q=new QueryWrapper<Carheet>();
        if(chepai!=null){

            q.eq("platename",chepai);

        }else {

        }
        return (Carheet) carh.list(q).get(0);
    }


}

