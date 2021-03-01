package com.accp.mapper;

import com.accp.domain.Fieldvehicles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 外勤车辆表 Mapper 接口
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
public interface FieldvehiclesMapper extends BaseMapper<Fieldvehicles> {
    List<Fieldvehicles> findByTeamId(Integer teamid);

    List<Fieldvehicles> findAll();
}
