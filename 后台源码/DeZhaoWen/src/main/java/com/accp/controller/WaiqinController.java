package com.accp.controller;


import com.accp.domain.Waiqin;
import com.accp.service.impl.WaiqinServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-03-16
 */
@RestController
@RequestMapping("/waiqin")
public class WaiqinController {

    @Autowired
    WaiqinServiceImpl waiqinService;

    @GetMapping("/findwqi")
    public int findwqi(){
        return  waiqinService.count();
    }
    @PostMapping("/find")
    public List<Waiqin> find(){
        return waiqinService.list();
    }

    @PostMapping("/delete")
    public String remove(int id){
        return  waiqinService.removeById(id)?"删除成功":"删除失败";
    }

    @RequestMapping("add")
    public String add(@RequestBody Waiqin data){
        return  waiqinService.save(data)?"0000":"1111";
    }

}

