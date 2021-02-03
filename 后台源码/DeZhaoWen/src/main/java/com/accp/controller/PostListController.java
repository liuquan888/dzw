package com.accp.controller;


import com.accp.domain.PostList;
import com.accp.service.impl.PostListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 岗位表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@RestController
@RequestMapping("/postList")
public class PostListController {

    @Autowired
    PostListServiceImpl plservice;

    @RequestMapping("/find")
    public List<PostList> queryAll(){
       return plservice.list();
    }

}

