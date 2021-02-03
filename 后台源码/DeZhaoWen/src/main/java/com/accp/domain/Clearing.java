package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 结算信息表
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Clearing对象", description="结算信息表")
public class Clearing extends Model<Clearing> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "结算单id")
    @TableId(value = "clearingid", type = IdType.AUTO)
    private Integer clearingid;

    @ApiModelProperty(value = "结算状态")
    private String jieszt;

    @ApiModelProperty(value = "合计金额")
    private Double hjje;

    @ApiModelProperty(value = "材料费")
    private Double clf;

    @ApiModelProperty(value = "工时费")
    private Double goshf;

    @ApiModelProperty(value = "结算时间")
    private LocalDate jiesdate;

    @ApiModelProperty(value = "结算人")
    private String jiesr;

    @ApiModelProperty(value = "现金")
    private Double xj;

    @ApiModelProperty(value = "银行卡")
    private Double yhk;

    @ApiModelProperty(value = "票据")
    private Double piaoju;

    @ApiModelProperty(value = "挂账金额")
    private Double guazhang;

    @ApiModelProperty(value = "冲储值卡")
    private Double xuka;

    @ApiModelProperty(value = "冲定金")
    private Double dj;

    @ApiModelProperty(value = "收税金")
    private Double shuij;

    @ApiModelProperty(value = "抵用券")
    private Double diyong;

    @ApiModelProperty(value = "抹尾数")
    private Double mws;

    @ApiModelProperty(value = "内部帐")
    private Double lbuz;

    @ApiModelProperty(value = "积分抵扣")
    private Double jfdk;

    @ApiModelProperty(value = "到账盈亏")
    private Double dzyk;

    @ApiModelProperty(value = "发票种类")
    private String fpzl;

    @ApiModelProperty(value = "发票号")
    private String fph;

    @ApiModelProperty(value = "发票金额")
    private Double fpje;

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


    public static final String CLEARINGID = "clearingid";

    public static final String JIESZT = "jieszt";

    public static final String HJJE = "hjje";

    public static final String CLF = "clf";

    public static final String GOSHF = "goshf";

    public static final String JIESDATE = "jiesdate";

    public static final String JIESR = "jiesr";

    public static final String XJ = "xj";

    public static final String YHK = "yhk";

    public static final String PIAOJU = "piaoju";

    public static final String GUAZHANG = "guazhang";

    public static final String XUKA = "xuka";

    public static final String DJ = "dj";

    public static final String SHUIJ = "shuij";

    public static final String DIYONG = "diyong";

    public static final String MWS = "mws";

    public static final String LBUZ = "lbuz";

    public static final String JFDK = "jfdk";

    public static final String DZYK = "dzyk";

    public static final String FPZL = "fpzl";

    public static final String FPH = "fph";

    public static final String FPJE = "fpje";

    public static final String RESERVED1 = "reserved1";

    public static final String RESERVED2 = "reserved2";

    public static final String RESERVED3 = "reserved3";

    public static final String RESERVED4 = "reserved4";

    public static final String RESERVED5 = "reserved5";

    @Override
    protected Serializable pkVal() {
        return this.clearingid;
    }

}
