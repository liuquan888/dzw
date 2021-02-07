package com.accp.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 客户类别 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/customertype")
public class CustomertypeController {
    @Autowired
    CustomertypeServiceImpl service;
    @RequestMapping("/findAll")
    public List<Customertype> findAll(){
        return service.list();
    }
    @RequestMapping("/insert")
    public boolean insert(Customertype cus){
        return service.save(cus);
    }
    @RequestMapping("/update")
    public boolean update(Customertype cus){
        return service.updateById(cus);
    }
    @RequestMapping("/delete/{code}")
    public boolean delete(int id){
        return service.removeById(id);
    }
}

