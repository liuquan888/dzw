package com.accp.mapper;

import com.accp.domain.DeparmentSurface;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
public interface DeparmentSurfaceMapper extends BaseMapper<DeparmentSurface> {
    List<DeparmentSurface> bu();
    List<DeparmentSurface> bu1();
    List<DeparmentSurface> bu2(@Param("id") Integer id);
}
