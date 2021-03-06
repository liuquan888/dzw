package com.accp.controller;


import com.accp.domain.*;
import com.accp.service.impl.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 车型品牌 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    BrandServiceImpl brandService;
    @Autowired
    CarServiceImpl carService;
    @Autowired
    EngineServiceImpl engineService;
    @Autowired
    SuppilerServiceImpl suppilerService;
    @Autowired
    DomesticServiceImpl domesticService;


    //查询所有查询
    @GetMapping("/findall")
    public List<Brand> list(){
        return brandService.list();
    }

    //根据品牌查询车型
    @GetMapping("/findbyidcar/{bid}")
    public List<Car> carList(@PathVariable Integer bid){
        QueryWrapper qw=new QueryWrapper<Car>();
        qw.eq("b_id",bid);
        List<Car> list=carService.list(qw);
        for (Car car:list) {
            car.setEngine(engineService.getById(car.getEId()));
            QueryWrapper suppqw=new QueryWrapper<Suppiler>();
            suppqw.eq("p_id",car.getPId());
            Suppiler suppiler= (Suppiler) suppilerService.list(suppqw).get(0);
            car.setSuppiler(suppiler);
        }
        return list;
    }

    //新增品牌
    @PostMapping("/addbrand")
    public String addbrand(Brand brand){
        try {
            brandService.save(brand);
        }catch (Exception ex){
            return "编号不能重复";
        }
        return "000000";
    }

    //删除品牌
    @GetMapping("/removebrand/{bid}")
    public String removebrand(@PathVariable Integer bid){
        try {
            QueryWrapper carqw=new QueryWrapper<Car>();
            QueryWrapper brandqw=new QueryWrapper<Brand>();
            carqw.eq("b_id",bid);
            brandqw.eq("b_id",bid);
            carService.remove(carqw);
            brandService.remove(brandqw);
        }catch (Exception ex){
            return "500";
        }
        return "000000";
    }

    //修改品牌
    @PostMapping("/updatebrand")
    public String updatebrand(Brand brand){
        try {
            QueryWrapper brandqw=new QueryWrapper<Brand>();
            brandqw.eq("b_id",brand.getBId());
            brandService.update(brand,brandqw);
        }catch (Exception ex){
            return "500";
        }
        return "-1";
    }

    //模糊查询品牌
    @GetMapping("/branddim/{branddimtext}")
    public List<Brand> branddim(@PathVariable String branddimtext){
        try {
            if (branddimtext.equals("56d56f6e56d65e85ads8562ar52da96q57")){
                return brandService.list();
            }

            if(branddimtext!=null){
                QueryWrapper<Brand> brandqw=new QueryWrapper();
                //判断是否为整数
                boolean bo = NumberUtils.isNumber(branddimtext);
                if(bo){
                    int bid=Integer.valueOf(branddimtext);
                    brandqw.and(wrapper -> wrapper.like("b_id",bid)
                            .or()
                            .like("b_name", branddimtext)
                            .or()
                            .like("b_inital",branddimtext)
                    );
                }else{
                    brandqw.and(wrapper -> wrapper
                            .like("b_name", branddimtext)
                            .or()
                            .like("b_inital",branddimtext)
                    );
                }
                List<Brand> list=brandService.list(brandqw);
                return list;
            }

        }catch (Exception ex){
            System.out.print("出错了！");
        }
        return brandService.list();
    }


    @GetMapping("/cardim/{cardimtext}/{bid}")
    public List<Car> cardim(@PathVariable String cardimtext,@PathVariable Integer bid){
        try {
            if(cardimtext.equals("975e65r45a4454a4d52s8a452d57")){
                return carList(bid);
            }
            QueryWrapper<Car> carqw=new QueryWrapper();
            carqw.eq("b_id",bid);
            carqw.and(wrapper -> wrapper
                    .eq("c_coder", cardimtext)
                    .or()
                    .like("reserved1",cardimtext)
            );
            List<Car> list=carService.list(carqw);
            for (Car car:list) {
                car.setEngine(engineService.getById(car.getEId()));
                QueryWrapper suppqw=new QueryWrapper<Suppiler>();
                suppqw.eq("p_id",car.getPId());
                Suppiler suppiler= (Suppiler) suppilerService.list(suppqw).get(0);
                car.setSuppiler(suppiler);
            }
            return list;
        }catch (Exception ex){
            System.out.print("查了个寂寞");
        }
        return carList(bid);
    }

    @GetMapping("/removecar/{cid}")
    public String removecar(@PathVariable Integer cid){
        try {
            if (carService.removeById(cid)){
                return "000000";
            }
            return "-1";
        }catch (Exception ex){
            return "500";
        }
    }

    @GetMapping("/findmade")
    public List<Domestic> findmade(){
        try {
            return domesticService.list();
        }catch (Exception ex){
            System.out.print("查询进口国产出错了！");
        }
        return null;
    }

    @GetMapping("/findclaim")
    public List<Suppiler> findclaim(){
        try {
            return suppilerService.list();
        }catch (Exception ex){
            System.out.print("查询索赔商出错了！");
        }
        return null;
    }

    @GetMapping("/findengine")
    public List<Engine> findengine(){
        try {
            return engineService.list();
        }catch (Exception ex){
            System.out.print("查询发动机品牌出错了！");
        }
        return null;
    }

    @PostMapping("/addcar")
    public String addcar(Car car){
        try {
            QueryWrapper carqw=new QueryWrapper<Car>();
            carqw.eq("c_coder",car.getCCoder());
            if(carService.list(carqw).size()>0){
                return "车型ID不能重复";
            }
            if (carService.save(car)){
                return "000000";
            }
        }catch (Exception ex){
            return "500";
        }
        return "-1";
    }

    @PostMapping("/updatecar")
    public String updatecar(Car car){
        try {
            QueryWrapper carqw=new QueryWrapper<Car>();
            carqw.eq("c_coder",car.getCCoder());
            carqw.ne("c_id",car.getCId());
            if(carService.list(carqw).size()>0){
                return "000001";
            }
            return carService.updateById(car)?"000000":"-1";
        }catch (Exception ex){
            return "500";
        }
    }
}

