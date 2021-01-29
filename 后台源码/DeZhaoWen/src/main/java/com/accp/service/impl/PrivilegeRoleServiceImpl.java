package com.accp.service.impl;

import com.accp.domain.PrivilegeRole;
import com.accp.mapper.PrivilegeRoleMapper;
import com.accp.service.IPrivilegeRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限与角色中间表 服务实现类
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Service
public class PrivilegeRoleServiceImpl extends ServiceImpl<PrivilegeRoleMapper, PrivilegeRole> implements IPrivilegeRoleService {

}
