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
 * 角色与用户中间表
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="RoleUser对象", description="角色与用户中间表")
public class RoleUser extends Model<RoleUser> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "角色表id，外键")
    private Integer rid;

    @ApiModelProperty(value = "用户表id，外键")
    private Integer uid;


    public static final String RID = "rid";

    public static final String UID = "uid";

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
