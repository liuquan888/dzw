package com.accp.controller;


import com.accp.domain.Carheet;
import com.accp.domain.Maintenance;
import com.accp.domain.MaintenanceItems;
import com.accp.domain.Workcar;
import com.accp.service.impl.MaintenanceItemsServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import net.sf.jsqlparser.schema.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 维修项目表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/maintenanceItems")
public class MaintenanceItemsController {

    @Autowired
    MaintenanceItemsServiceImpl mainren;

    @GetMapping("/findten")
    public List<MaintenanceItems> show(){

        return mainren.list();
    }

    @PostMapping("/addwx")
    public String add(MaintenanceItems mainte){

        return mainren.save(mainte)?"000":"-1";
    }

    @PostMapping("/removebh")
    public String remove(@RequestBody List<String> list) {
        try {
            QueryWrapper<MaintenanceItems> brandqw = new QueryWrapper();
            for (String s : list) {
                brandqw.eq("xmbh", s);
                mainren.remove(brandqw);
            }
            return "删除成功";
        }catch (Exception exception){
            return "00003";
        }


    }

    @GetMapping("/findbyxms/{checks}")
    public MaintenanceItems findmain(@PathVariable String checks) {
        QueryWrapper<MaintenanceItems> brandqw=new QueryWrapper();
        brandqw.eq("xmbh",checks);
        return  (MaintenanceItems) mainren.list(brandqw).get(0);
    }

    @PostMapping("/updateby")
    public String findmain(MaintenanceItems mainten) {
        QueryWrapper<MaintenanceItems> brandqw=new QueryWrapper();
        brandqw.eq("xmbh",mainten.getXmbh());
        return mainren.updateById(mainten)?"修改成功":"修改失败";
    }
}

