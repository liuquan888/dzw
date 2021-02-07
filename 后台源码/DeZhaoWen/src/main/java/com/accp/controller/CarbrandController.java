package com.accp.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 车辆品牌 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/carbrand")
public class CarbrandController {
    @Autowired
    CarbrandServiceImpl service;
    @RequestMapping("/findAll")
    public List<Carbrand> findAll(Carbrand cb){
        QueryWrapper<Carbrand> query=new QueryWrapper<>();
        () -> query
        query.lambda().like(Carbrand::getCarcoding,val:cb.get)
        List<Carbrand> list=service.
    }
}

