package com.accp.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 维修项目表
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="MaintenanceItems对象", description="维修项目表")
public class MaintenanceItems extends Model<MaintenanceItems> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "维修单号")
    private String wxdh;

    @ApiModelProperty(value = "接车时间")
    private LocalDate jcsj;

    @ApiModelProperty(value = "完工时间")
    private LocalDate wgsj;

    @ApiModelProperty(value = "结算时间")
    private LocalDate jsdate;

    @ApiModelProperty(value = "项目编码")
    private String xmbh;

    @ApiModelProperty(value = "项目名称")
    private String xmname;

    @ApiModelProperty(value = "价类")
    private String jialei;

    @ApiModelProperty(value = "结算公时")
    private Double jiesgs;

    @ApiModelProperty(value = "工时金额")
    private Double gshije;

    @ApiModelProperty(value = "作业人员")
    private String zuoyery;

    @ApiModelProperty(value = "故障描述")
    private String gzms;

    @ApiModelProperty(value = "故障确认")
    private String gzqr;

    @ApiModelProperty(value = "工单号")
    private String gdh;

    @ApiModelProperty(value = "工位")
    private String gwei;

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


    public static final String WXDH = "wxdh";

    public static final String JCSJ = "jcsj";

    public static final String WGSJ = "wgsj";

    public static final String JSDATE = "jsdate";

    public static final String XMBH = "xmbh";

    public static final String XMNAME = "xmname";

    public static final String JIALEI = "jialei";

    public static final String JIESGS = "jiesgs";

    public static final String GSHIJE = "gshije";

    public static final String ZUOYERY = "zuoyery";

    public static final String GZMS = "gzms";

    public static final String GZQR = "gzqr";

    public static final String GDH = "gdh";

    public static final String GWEI = "gwei";

    public static final String RESERVED1 = "reserved1";

    public static final String RESERVED2 = "reserved2";

    public static final String RESERVED3 = "reserved3";

    public static final String RESERVED4 = "reserved4";

    public static final String RESERVED5 = "reserved5";

    @Override
    protected Serializable pkVal() {
        return this.wxdh;
    }

}
