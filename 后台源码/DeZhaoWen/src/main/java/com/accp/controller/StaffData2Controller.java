package com.accp.controller;


import com.accp.domain.*;
import com.accp.service.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 员工资料表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-25
 */
@RestController
@RequestMapping("/yuangongziliaobiao")
public class StaffData2Controller {

    @Autowired
    IStaffDataService services;
    @Autowired
    IPostListService service;
    @Autowired
    INativPlaceService jservice;
    @Autowired
    INationService mservice;
    @Autowired
    IMaritalStatusService hservice;
    @Autowired
    IEducationService xservice;
    @Autowired
    IGraduateSchoolService bservice;
    @Autowired
    IProfessionalQualificationService zservice;
    @Autowired
    IAcademicDegreeService xwservice;
    @Autowired
    IDeparmentSurfaceService buservice;
    @Autowired
    IOrganizationSurfaceService zzservice;
    @Autowired
    ICityService cservice;

    @RequestMapping("/gfind")
    public List<PostList> queryAll1(){
        return service.list();
    }
    @RequestMapping("/jfind")
    public List<NativPlace> queryAll2(){
        return jservice.list();
    }
    @RequestMapping("/mfind")
    public List<Nation> queryAll3(){
        return mservice.list();
    }
    @RequestMapping("/hfind")
    public List<MaritalStatus> queryAll4(){
        return hservice.list();
    }
    @RequestMapping("/xfind")
    public List<Education> queryAll5(){
        return xservice.list();
    }
    @RequestMapping("/bfind")
    public List<GraduateSchool> queryAll6(){
        return bservice.list();
    }
    @RequestMapping("/zfind")
    public List<ProfessionalQualification> queryAll7(){
        return zservice.list();
    }
    @RequestMapping("/xwfind")
    public List<AcademicDegree> queryAll8(){
        return xwservice.list();
    }
    @RequestMapping("/bufind")
    public List<DeparmentSurface> buFind(){
        List<DeparmentSurface> list=buservice.list();
        return list;
    }
    @RequestMapping("/yuanfind")
    public List<StaffData> yuanFind(){
        return services.list();
    }
}

