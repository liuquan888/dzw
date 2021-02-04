package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DzwPrivilege对象", description="权限表")
public class DzwPrivilege extends Model<DzwPrivilege> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "唯一编号")
    @TableId(value = "pvgid", type = IdType.AUTO)
    private Integer pvgid;

    @ApiModelProperty(value = "权限名称")
    private String pvgName;

    @ApiModelProperty(value = "权限验证")
    private String pvgVerify;

    @ApiModelProperty(value = "类别，0是父级菜单，1是子级菜单，2是功能")
    private Integer pvgType;

    @ApiModelProperty(value = "路径（是菜单才拥有）")
    private String pvgPath;

    @ApiModelProperty(value = "父级编号")
    private Integer pid;

    @ApiModelProperty(value = "预留字段")
    private String reserved1;

    @ApiModelProperty(value = "预留字段")
    private String reserved2;

    @ApiModelProperty(value = "预留字段")
    private String reserved3;


    public static final String PVGID = "pvgid";

    public static final String PVG_NAME = "pvg_name";

    public static final String PVG_VERIFY = "pvg_verify";

    public static final String PVG_TYPE = "pvg_type";

    public static final String PVG_PATH = "pvg_path";

    public static final String PID = "pid";

    public static final String RESERVED1 = "reserved1";

    public static final String RESERVED2 = "reserved2";

    public static final String RESERVED3 = "reserved3";

    @Override
    protected Serializable pkVal() {
        return this.pvgid;
    }

}
