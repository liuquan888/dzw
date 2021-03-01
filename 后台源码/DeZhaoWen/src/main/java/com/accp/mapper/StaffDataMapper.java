package com.accp.mapper;

import com.accp.domain.StaffData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 员工资料表 Mapper 接口
 * </p>
 *
 * @author quanl
 * @since 2021-02-25
 */
public interface StaffDataMapper extends BaseMapper<StaffData> {
    boolean lizhih(@Param("id") Integer id);
    boolean lizhixz(StaffData stu);
}
