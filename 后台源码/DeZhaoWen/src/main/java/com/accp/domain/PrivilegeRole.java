package com.accp.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限与角色中间表
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="PrivilegeRole对象", description="权限与角色中间表")
public class PrivilegeRole extends Model<PrivilegeRole> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "权限表id，外键")
    private Integer pid;

    @ApiModelProperty(value = "角色表id，外键")
    private Integer rid;


    public static final String PID = "pid";

    public static final String RID = "rid";

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
