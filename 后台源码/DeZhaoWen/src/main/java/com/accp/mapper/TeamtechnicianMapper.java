package com.accp.mapper;

import com.accp.domain.Teamtechnician;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
public interface TeamtechnicianMapper extends BaseMapper<Teamtechnician> {
    List<Teamtechnician> findByTeamId(Integer teamid);

    List<Teamtechnician> findByAll(String name);

    boolean clearPwd(Integer id);

    List<Teamtechnician> findAll();
}
