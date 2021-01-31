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
 * 用户公司定义表
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserCompany对象", description="用户公司定义表")
public class UserCompany extends Model<UserCompany> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户公司id")
    private Integer did;

    @ApiModelProperty(value = "单位名称")
    private String dname;

    @ApiModelProperty(value = "单位地址")
    private String daddress;

    @ApiModelProperty(value = "单位简称")
    private String djian;

    @ApiModelProperty(value = "业务电话")
    private String dphoney;

    @ApiModelProperty(value = "投诉电话")
    private String dphonej;

    @ApiModelProperty(value = "网址")
    private String dwaddress;

    @ApiModelProperty(value = "Email")
    private String email;

    @ApiModelProperty(value = "开户银行")
    private Integer dhang;

    @ApiModelProperty(value = "银行账号")
    private String dhangz;

    @ApiModelProperty(value = "短信账号")
    private String dhangd;

    @ApiModelProperty(value = "短信密码")
    private String dmi;

    @ApiModelProperty(value = "商品编号位数")
    private String dshangs;

    @ApiModelProperty(value = "初始加价率")
    private String dchu;

    @ApiModelProperty(value = "商品税率")
    private String dslv;

    @ApiModelProperty(value = "销售金额满")
    private String dxiao;

    @ApiModelProperty(value = "折合税分")
    private String dzhe;

    @ApiModelProperty(value = "积分/元")
    private String djifen;

    @ApiModelProperty(value = "维修看板行数")
    private String dwei;

    @ApiModelProperty(value = "三包申报超期(天)")
    private String dsan;

    @ApiModelProperty(value = "车辆年审提醒(天)")
    private String dche;

    @ApiModelProperty(value = "账号超期提醒(天)")
    private String dzhang;

    @ApiModelProperty(value = "班组备件超期(天)")
    private String dban;

    @ApiModelProperty(value = "配件库超龄提醒(天)")
    private String dpei;

    @ApiModelProperty(value = "站内晚上系数")
    private String dneiw;

    @ApiModelProperty(value = "站外白天系数")
    private String dwaib;

    @ApiModelProperty(value = "站外晚上系数")
    private String dwaiw;

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


    public static final String DID = "did";

    public static final String DNAME = "dname";

    public static final String DADDRESS = "daddress";

    public static final String DJIAN = "djian";

    public static final String DPHONEY = "dphoney";

    public static final String DPHONEJ = "dphonej";

    public static final String DWADDRESS = "dwaddress";

    public static final String EMAIL = "email";

    public static final String DHANG = "dhang";

    public static final String DHANGZ = "dhangz";

    public static final String DHANGD = "dhangd";

    public static final String DMI = "dmi";

    public static final String DSHANGS = "dshangs";

    public static final String DCHU = "dchu";

    public static final String DSLV = "dslv";

    public static final String DXIAO = "dxiao";

    public static final String DZHE = "dzhe";

    public static final String DJIFEN = "djifen";

    public static final String DWEI = "dwei";

    public static final String DSAN = "dsan";

    public static final String DCHE = "dche";

    public static final String DZHANG = "dzhang";

    public static final String DBAN = "dban";

    public static final String DPEI = "dpei";

    public static final String DNEIW = "dneiw";

    public static final String DWAIB = "dwaib";

    public static final String DWAIW = "dwaiw";

    public static final String RESERVED1 = "reserved1";

    public static final String RESERVED2 = "reserved2";

    public static final String RESERVED3 = "reserved3";

    public static final String RESERVED4 = "reserved4";

    public static final String RESERVED5 = "reserved5";

    @Override
    protected Serializable pkVal() {
        return this.did;
    }

}
