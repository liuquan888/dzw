package com.accp.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 历史维修表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Maintenance对象", description="历史维修表")
public class Maintenance extends Model<Maintenance> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "维修进程编号")
    private Integer mId;

    @ApiModelProperty(value = "维修进程项目名")
    private String mName;

    @ApiModelProperty(value = "维修进程备注")
    private String mNote;

    @ApiModelProperty(value = "维修进程种类")
    private String mType;

    @ApiModelProperty(value = "维修进程标准价")
    private Float mNormalprice;

    @ApiModelProperty(value = "维修进程会员价")
    private Float mMemberprice;

    @ApiModelProperty(value = "维修进程vip价")
    private Float mVipprice;

    @ApiModelProperty(value = "维修进程协议价")
    private Float mDetaprice;

    @ApiModelProperty(value = "维修进程索赔价")
    private Float mClaimprice;

    @ApiModelProperty(value = "维修进程索赔价")
    private Float mSafetyprice;

    @ApiModelProperty(value = "收入种类编号")
    private Integer inId;

    @ApiModelProperty(value = "车型品牌编号")
    private Integer bId;

    @ApiModelProperty(value = "发动机品牌编号")
    private Integer eId;

    @ApiModelProperty(value = "维修项目编号")
    private Integer serId;

    @ApiModelProperty(value = "预留字段")
    private String reserved1;

    @ApiModelProperty(value = "预留字段")
    private String reserved2;

    @ApiModelProperty(value = "预留字段")
    private String reserved3;

    @ApiModelProperty(value = "预留字段")
    private String reserved4;

    @ApiModelProperty(value = "预留字段")
    private String reserved5;

    @TableField(exist = false)
    private Service service;

    @TableField(exist = false)
    private Income income;


    public static final String M_ID = "m_id";

    public static final String M_NAME = "m_name";

    public static final String M_NOTE = "m_note";

    public static final String M_TYPE = "m_type";

    public static final String M_NORMALPRICE = "m_normalprice";

    public static final String M_MEMBERPRICE = "m_memberprice";

    public static final String M_VIPPRICE = "m_vipprice";

    public static final String M_DETAPRICE = "m_detaprice";

    public static final String M_CLAIMPRICE = "m_claimprice";

    public static final String M_SAFETYPRICE = "m_safetyprice";

    public static final String IN_ID = "in_id";

    public static final String B_ID = "b_id";

    public static final String E_ID = "e_id";

    public static final String SER_ID = "ser_id";

    public static final String RESERVED1 = "reserved1";

    public static final String RESERVED2 = "reserved2";

    public static final String RESERVED3 = "reserved3";

    public static final String RESERVED4 = "reserved4";

    public static final String RESERVED5 = "reserved5";

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
