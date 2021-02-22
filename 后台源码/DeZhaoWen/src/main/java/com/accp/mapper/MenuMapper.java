package com.accp.mapper;

import com.accp.domain.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 树形菜单 Mapper 接口
 * </p>
 *
 * @author quanl
 * @since 2021-02-22
 */
public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> findByParentId(Integer id);
}
