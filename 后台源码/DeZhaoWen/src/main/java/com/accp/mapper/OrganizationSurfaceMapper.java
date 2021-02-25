package com.accp.mapper;

import com.accp.domain.OrganizationSurface;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

/**
 * <p>
 * 组织机构定义表 Mapper 接口
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
public interface OrganizationSurfaceMapper extends BaseMapper<OrganizationSurface> {

    List<OrganizationSurface> find (Integer zid);

}
