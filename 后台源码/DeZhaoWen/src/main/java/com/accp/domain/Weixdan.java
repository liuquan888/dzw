package com.accp.domain;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * 
 * </p>
 *
 * @author quanl
 * @since 2021-02-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Weixdan对象", description="")
public class Weixdan extends Model<Weixdan> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "维修单号")
    private String weixdanh;

    @ApiModelProperty(value = "车牌号码")
    private String chepaih;

    @ApiModelProperty(value = "车架号")
    private String chejiahao;

    @ApiModelProperty(value = "车辆型号")
    private String cheliangxh;

    @ApiModelProperty(value = "车辆品牌")
    private String clpp;

    @ApiModelProperty(value = "发动机号")
    private String fdjh;

    @ApiModelProperty(value = "发动机品牌")
    private Integer fdjpp;

    @TableField(exist=false)
    private String blangName;

    @ApiModelProperty(value = "服务顾问")
    private String fuwugw;

    @ApiModelProperty(value = "车主姓名")
    private String czname;

    @ApiModelProperty(value = "驾驶员")
    private String jsy;

    @ApiModelProperty(value = "联系电话")
    private String lxphone;

    @ApiModelProperty(value = "进厂里程")
    private String jclc;

    @ApiModelProperty(value = "进厂油量")
    private Integer jcyl;

    @TableField(exist=false)
    private String jingc;

    @ApiModelProperty(value = "上次里程")
    private String sclc;

    @ApiModelProperty(value = "进厂时间")
    private LocalDate jcsj;

    @ApiModelProperty(value = "业务类别")
    private Integer ywlb;

    @TableField(exist=false)
    private String yewuleib;

    @ApiModelProperty(value = "施工班次")
    private Integer sgbc;

    @TableField(exist=false)
    private String sgigbc;

    @ApiModelProperty(value = "接车人")
    private String jcr;

    @ApiModelProperty(value = "预计完工")
    private LocalDate yjwg;

    @ApiModelProperty(value = "结算方式")
    private String jiesfs;

    @ApiModelProperty(value = "赔款公司")
    private String pkgs;

    @ApiModelProperty(value = "完工时间")
    private LocalDate wgsj;

    @ApiModelProperty(value = "上次进厂")
    private LocalDate scjc;

    @ApiModelProperty(value = "预估金额")
    private Double ygje;

    @ApiModelProperty(value = "接待备注")
    private String jdbz;

    @ApiModelProperty(value = "保修陈述")
    private String cxms;


    public static final String WEIXDANH = "weixdanh";

    public static final String CHEPAIH = "chepaih";

    public static final String CHEJIAHAO = "chejiahao";

    public static final String CHELIANGXH = "cheliangxh";

    public static final String CLPP = "clpp";

    public static final String FDJH = "fdjh";

    public static final String FDJPP = "fdjpp";

    public static final String FUWUGW = "fuwugw";

    public static final String CZNAME = "czname";

    public static final String JSY = "jsy";

    public static final String LXPHONE = "lxphone";

    public static final String JCLC = "jclc";

    public static final String JCYL = "jcyl";

    public static final String SCLC = "sclc";

    public static final String JCSJ = "jcsj";

    public static final String YWLB = "ywlb";

    public static final String SGBC = "sgbc";

    public static final String JCR = "jcr";

    public static final String YJWG = "yjwg";

    public static final String JIESFS = "jiesfs";

    public static final String PKGS = "pkgs";

    public static final String WGSJ = "wgsj";

    public static final String SCJC = "scjc";

    public static final String YGJE = "ygje";

    public static final String JDBZ = "jdbz";

    public static final String CXMS = "cxms";

    @Override
    protected Serializable pkVal() {
        return this.weixdanh;
    }

}
