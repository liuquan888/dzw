package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 维修项目菜单
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Service对象", description="维修项目菜单")
public class Service extends Model<Service> {

    private static final long serialVersionUID=1L;

    //设置主键
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "维修项目编号")
    private Integer serId;

    @ApiModelProperty(value = "维修项目名称")
    private String serName;

    @ApiModelProperty(value = "父级项目编号")
    private Integer serParent;

    @ApiModelProperty(value = "维修项目图片")
    private String serImg;

    @ApiModelProperty(value = "维修标识")
    private String serTag;

    @ApiModelProperty(value = "预留字段")
    private String reserved1;

    @ApiModelProperty(value = "预留字段")
    private String reserved2;

    @ApiModelProperty(value = "预留字段")
    private String reserved3;

    @TableField(exist = false)
    private List<Service> services;

    @TableField(exist = false)
    private Service service;

    public static final String SER_ID = "ser_id";

    public static final String SER_NAME = "ser_name";

    public static final String SER_PARENT = "ser_parent";

    public static final String SER_IMG = "ser_img";

    public static final String SER_TAG = "ser_tag";

    public static final String RESERVED1 = "reserved1";

    public static final String RESERVED2 = "reserved2";

    public static final String RESERVED3 = "reserved3";

    @Override
    protected Serializable pkVal() {
        return this.serId;
    }

}
