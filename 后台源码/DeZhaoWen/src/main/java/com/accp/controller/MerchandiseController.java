package com.accp.controller;


import com.accp.domain.MenuMerchandise;
import com.accp.domain.Merchandise;
import com.accp.mapper.MenuMerchandiseMapper;
import com.accp.mapper.MerchandiseMapper;
import com.accp.service.impl.MenuMerchandiseServiceImpl;
import com.accp.service.impl.MerchandiseServiceImpl;
import com.accp.service.impl.SuppilerServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 菜单信息图片 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/merchandise")
public class MerchandiseController {

    @Autowired
    MerchandiseServiceImpl merchandiseService;
    @Resource
    MenuMerchandiseMapper menuMerchandiseMapper;
    @Autowired
    SuppilerServiceImpl suppilerService;
    @Autowired
    MenuMerchandiseServiceImpl menuMerchandiseService;

    @GetMapping("/findmer/{menuId}")
    public List<Merchandise> findmer(@PathVariable Integer menuId){
        try {
            QueryWrapper<Merchandise> merqw=new QueryWrapper<>();
            if (menuId!=0){
                merqw.eq("menu_id",menuId);
            }
            List<Merchandise> merchandiseList=merchandiseService.list(merqw);
            for(Merchandise merchandise:merchandiseList){
                merchandise.setSuppiler(suppilerService.getById(merchandise.getPId()));
                merchandise.setMenuMerchandise(menuMerchandiseService.getById(merchandise.getMenuId()));
            }
            return merchandiseList;
        }catch (Exception exception){
            return null;
        }
    }

    //无限递归
    @GetMapping("/di")
    public MenuMerchandise finddi(){
        return menuMerchandiseMapper.findMenuByRoleId(0).get(0);
    }

}

