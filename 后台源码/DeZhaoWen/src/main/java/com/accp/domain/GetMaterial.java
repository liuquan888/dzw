package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 领料情况表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="GetMaterial对象", description="领料情况表")
public class GetMaterial extends Model<GetMaterial> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "车辆id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "类别")
    private String lb;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "领料日期")
    private LocalDate lingliaodate;

    @ApiModelProperty(value = "领料人")
    private String lingliaor;

    @ApiModelProperty(value = "物料编号")
    private String wuliao;

    @ApiModelProperty(value = "物料名称")
    private String wuliaoname;

    @ApiModelProperty(value = "单位")
    private String dwei;

    @ApiModelProperty(value = "价类")
    private String jialei;

    @ApiModelProperty(value = "数量")
    private String shuliao;

    @ApiModelProperty(value = "单价")
    private Double danjian;

    @ApiModelProperty(value = "金额")
    private Double jine;

    @ApiModelProperty(value = "服务顾问")
    private String fuwugw;

    @ApiModelProperty(value = "对应项目")
    private String duiy;

    @ApiModelProperty(value = "车资料id")
    private Integer cid;

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


    public static final String ID = "id";

    public static final String LB = "lb";

    public static final String LINGLIAODATE = "lingliaodate";

    public static final String LINGLIAOR = "lingliaor";

    public static final String WULIAO = "wuliao";

    public static final String WULIAONAME = "wuliaoname";

    public static final String DWEI = "dwei";

    public static final String JIALEI = "jialei";

    public static final String SHULIAO = "shuliao";

    public static final String DANJIAN = "danjian";

    public static final String JINE = "jine";

    public static final String FUWUGW = "fuwugw";

    public static final String DUIY = "duiy";

    public static final String CID = "cid";

    public static final String RESERVED1 = "reserved1";

    public static final String RESERVED2 = "reserved2";

    public static final String RESERVED3 = "reserved3";

    public static final String RESERVED4 = "reserved4";

    public static final String RESERVED5 = "reserved5";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
