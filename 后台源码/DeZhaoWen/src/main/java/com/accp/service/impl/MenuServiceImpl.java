package com.accp.service.impl;

import com.accp.domain.Menu;
import com.accp.mapper.MenuMapper;
import com.accp.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 树形菜单 服务实现类
 * </p>
 *
 * @author quanl
 * @since 2021-02-22
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    @Autowired
    MenuMapper menuMapper;

    public List<Menu> findByParentId(){
        List<Menu> byParentId = menuMapper.findByParentId(0);

        return byParentId;
    }

    public List<Menu> findNoByParentId(){
        List<Menu> list=menuMapper.findNoByParentId(0);
        return list;
    }

    public Menu findTeamIdDesc(){
        return menuMapper.findTeamIdDesc();
    }
}
