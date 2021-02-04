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
 * 历史回访表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="History对象", description="历史回访表")
public class History extends Model<History> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "历史回访id")
    private Integer clientid;

    @ApiModelProperty(value = "回访内容")
    private String huifnr;

    @ApiModelProperty(value = "回访时间")
    private LocalDate huifdate;

    @ApiModelProperty(value = "客户编码")
    private String kmbm;

    @ApiModelProperty(value = "客户名称")
    private String khname;

    @ApiModelProperty(value = "地址")
    private String dizhi;

    @ApiModelProperty(value = "车牌号")
    private Integer cph;

    @ApiModelProperty(value = "手机")
    private String phone;

    @ApiModelProperty(value = "电话")
    private String dh;

    @ApiModelProperty(value = "维修项目")
    private String wxxm;

    @ApiModelProperty(value = "单据类型")
    private String djlx;

    @ApiModelProperty(value = "回访效果")
    private String huifxg;

    @ApiModelProperty(value = "服务顾问")
    private String fwugw;

    @ApiModelProperty(value = "详细说明")
    private String xianx;

    @ApiModelProperty(value = "开单人")
    private String kdr;

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


    public static final String CLIENTID = "clientid";

    public static final String HUIFNR = "huifnr";

    public static final String HUIFDATE = "huifdate";

    public static final String KMBM = "kmbm";

    public static final String KHNAME = "khname";

    public static final String DIZHI = "dizhi";

    public static final String CPH = "cph";

    public static final String PHONE = "phone";

    public static final String DH = "dh";

    public static final String WXXM = "wxxm";

    public static final String DJLX = "djlx";

    public static final String HUIFXG = "huifxg";

    public static final String FWUGW = "fwugw";

    public static final String XIANX = "xianx";

    public static final String KDR = "kdr";

    public static final String RESERVED1 = "reserved1";

    public static final String RESERVED2 = "reserved2";

    public static final String RESERVED3 = "reserved3";

    public static final String RESERVED4 = "reserved4";

    public static final String RESERVED5 = "reserved5";

    @Override
    protected Serializable pkVal() {
        return this.clientid;
    }

}
