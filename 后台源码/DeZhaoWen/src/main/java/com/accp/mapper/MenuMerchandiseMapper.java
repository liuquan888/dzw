package com.accp.mapper;

import com.accp.domain.MenuMerchandise;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单商品资料表 Mapper 接口
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
public interface MenuMerchandiseMapper extends BaseMapper<MenuMerchandise> {
    public List<MenuMerchandise> findMenuByRoleId(@Param("menuParent") Integer menuParent);
}
