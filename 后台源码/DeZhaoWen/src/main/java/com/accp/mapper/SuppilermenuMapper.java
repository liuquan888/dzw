package com.accp.mapper;

import com.accp.domain.MenuMerchandise;
import com.accp.domain.Suppilermenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 供货商菜单 Mapper 接口
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
public interface SuppilermenuMapper extends BaseMapper<Suppilermenu> {
    public List<Suppilermenu> findMenuByRoleId(@Param("sParent") Integer sParent);
}
