package com.accp.controller;


import com.accp.domain.Car;
import com.accp.domain.MenuMerchandise;
import com.accp.domain.Merchandise;
import com.accp.domain.Suppiler;
import com.accp.mapper.MenuMerchandiseMapper;
import com.accp.mapper.MerchandiseMapper;
import com.accp.service.impl.MenuMerchandiseServiceImpl;
import com.accp.service.impl.MerchandiseServiceImpl;
import com.accp.service.impl.SuppilerServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/findmer/{menuId}/{con1}/{con2}")
    public List<Merchandise> findmer(@PathVariable Integer menuId,@PathVariable String con1,@PathVariable String con2){
        System.out.print(con1+"------------");
        System.out.print(con2);

        try {
            QueryWrapper<Merchandise> merqw=new QueryWrapper<>();
            if(!con1.equals("0")){
                merqw.and(wrapper -> wrapper.like("me_id",con1)
                        .or()
                        .like("me_name", con1)
                        .or()
                        .like("me_adaptable",con1)
                );
            }
            if (menuId!=0){
                merqw.eq("menu_id",menuId);
            }
            merqw.eq("reserved4",0);
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
    public List<MenuMerchandise> finddi(){
        return menuMerchandiseMapper.findMenuByRoleId(0);
    }

    @GetMapping("/findsupp")
    public List<Suppiler> findsupp(){
        try {
            return suppilerService.list();
        }catch (Exception exception){
            System.out.print("查询厂商出错了");
        }
        return null;
    }

    @PostMapping("/addmer")
    public String addmer(Merchandise merchandise){
        try {
            merchandise.setReserved4("0");
            QueryWrapper merqw=new QueryWrapper<Merchandise>();
            merqw.eq("me_id",merchandise.getMeId());
            if(merchandiseService.list(merqw).size()>0){
                return "000001";
            }
            return merchandiseService.save(merchandise)?"000000":"-1";
        }catch (Exception exception){
            System.out.print("500");
        }
        return "";
    }
    @PostMapping("/updatemer")
    public String updatemer(Merchandise merchandise){
        try {
            return merchandiseService.updateById(merchandise)?"000000":"-1";
        }catch (Exception exception){
            return "500";
        }
    }

    @GetMapping("/removemer/{meId}")
    public String removemer(@PathVariable Integer meId){
        try {
            Merchandise merchandise=merchandiseService.getById(meId);
            merchandise.setReserved4("1");
            return merchandiseService.updateById(merchandise)?"000000":"-1";
        }catch (Exception exception){
            return "500";
        }
    }

}

