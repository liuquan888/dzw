package com.accp.controller;


import com.accp.domain.DzwUser;
import com.accp.service.impl.DzwUserServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.Principal;
import java.util.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/dzwUser")
public class DzwUserController{
    @Autowired
    DzwUserServiceImpl duser;

    @RequestMapping("/find")
    public DzwUser find(DzwUser user,HttpSession session){
        QueryWrapper<DzwUser> query=new QueryWrapper<>();
        query.lambda().eq(DzwUser::getUserPwd,user.getUserPwd()).eq(DzwUser::getUserLogin,user.getUserLogin());
        List<DzwUser> li=duser.list(query);
        if(li.size()>0){
            for(DzwUser us:li){
                if(us!=null){
                    session.setAttribute("user",li);
                }
            }
        }
        return li.get(0);
    }
}

