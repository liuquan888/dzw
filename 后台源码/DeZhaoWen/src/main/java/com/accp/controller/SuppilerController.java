package com.accp.controller;


import com.accp.domain.Linkman;
import com.accp.domain.Merchandise;
import com.accp.domain.Suppiler;
import com.accp.domain.Suppilermenu;
import com.accp.mapper.SuppilermenuMapper;
import com.accp.service.impl.LinkmanServiceImpl;
import com.accp.service.impl.SuppilerServiceImpl;
import com.accp.service.impl.SuppilermenuServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 供货商 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/suppiler")
public class SuppilerController {
    @Resource
    SuppilermenuMapper suppilermenuMapper;
    @Autowired
    SuppilermenuServiceImpl suppilermenuService;
    @Autowired
    SuppilerServiceImpl suppilerService;
    @Autowired
    LinkmanServiceImpl linkmanService;

    //无限递归
    @GetMapping("/suppmenu")
    public List<Suppilermenu> suppmenu(){
        return suppilermenuMapper.findMenuByRoleId(0);
    }

    @GetMapping("/findsupp/{sid}/{dimtext}")
    public List<Suppiler> findsupp(@PathVariable Integer sid,@PathVariable String dimtext){
        try {
            System.out.print(dimtext+"-----");
            QueryWrapper<Suppiler> suppilerQueryWrapper=new QueryWrapper<>();

            if(!dimtext.equals("5d12ds5a445wq12f")){
                suppilerQueryWrapper.and(wrapper -> wrapper.like("p_name",dimtext)
                        .or()
                        .like("p_linkman", dimtext)
                        .or()
                        .like("p_mobile",dimtext)
                );
            }
            
            if(sid!=0&&sid!=null){
                suppilerQueryWrapper.eq("sid",sid);
            }

            suppilerQueryWrapper.eq("reserved3","0");

            List<Suppiler> list=suppilerService.list(suppilerQueryWrapper);
            for (Suppiler suppiler:list){
                suppiler.setSuppilermenu(suppilermenuService.getById(suppiler.getSid()));
            }
            return list;
        }catch (Exception exception){
            System.out.print("查了个寂寞");
        }
        return null;
    }

    @GetMapping("/findlinkman/{pId}")
    public List<Linkman> findlinkman(@PathVariable String pId){
        try {
            QueryWrapper<Linkman> linkmanQueryWrapper=new QueryWrapper<>();
            linkmanQueryWrapper.eq("p_id",pId);
            List<Linkman> list=linkmanService.list(linkmanQueryWrapper);
            return list;
        }catch (Exception exception){
            System.out.print("查询联系人出错了！");
        }
        return null;
    }

    @PostMapping("/suppadd")
    public String suppadd(Suppiler suppiler){
        try {
            suppiler.setReserved3("0");
            QueryWrapper suppqw=new QueryWrapper<Suppiler>();
            suppqw.eq("p_id",suppiler.getPId());
            if(suppilerService.list(suppqw).size()>0){
                return "000001";
            }
            return suppilerService.save(suppiler)?"000000":"-1";
        }catch (Exception exception){
            return "500";
        }
    }

    @PostMapping("/suppupdate")
    public String suppupdate(Suppiler suppiler){
        try {
            return suppilerService.updateById(suppiler)?"000000":"-1";
        }catch (Exception exception){
            return "500";
        }
    }

    @GetMapping("/suppremove/{pId}")
    public String suppremove(@PathVariable String pId){
        try {
            Suppiler suppiler=suppilerService.getById(pId);
            suppiler.setReserved3("1");
            return suppilerService.updateById(suppiler)?"000000":"-1";
        }catch (Exception exception){
            return "500";
        }
    }

    @PostMapping("/linkmanadd")
    public String linkmanadd(Linkman linkman){
        try {
            return linkmanService.save(linkman)?"000000":"-1";
        }catch (Exception exception){
            return "500";
        }
    }

    @PostMapping("/linkmanupdate")
    public String linkmanupdate(Linkman linkman){
        try {
            return linkmanService.updateById(linkman)?"000000":"-1";
        }catch (Exception exception){
            return "500";
        }
    }

    @GetMapping("/linkmanremove/{lId}")
    public String linkmanremove(@PathVariable Integer lId){
        try {
            return linkmanService.removeById(lId)?"000000":"-1";
        }catch (Exception exception){
            return "500";
        }
    }

}

