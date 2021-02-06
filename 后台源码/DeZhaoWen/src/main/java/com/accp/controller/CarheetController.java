package com.accp.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 车辆资料表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@RestController
@RequestMapping("/carheet")
public class CarheetController {
    @Autowired
    CarheetServiceImpl service;
    public List<Carheet> findAll(){
        return service.list();
    }
    public List<Carheet> findLike(Carheet car){

    }
}

