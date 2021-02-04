package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 客户表
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Customer对象", description="客户表")
public class Customer extends Model<Customer> {

    private static final long serialVersionUID=1L;

    @TableId(value = "customernum")
    @ApiModelProperty(value = "客户编码")
    private String customernum;

    @ApiModelProperty(value = "客户名称")
    private String customername;

    @ApiModelProperty(value = "详细地址")
    private String customeraddress;

    @ApiModelProperty(value = "联系人")
    private String linkman;

    @ApiModelProperty(value = "手机")
    private String phone;

    @ApiModelProperty(value = "客户生日")
    private String birthday;

    @ApiModelProperty(value = "客户类别id")
    private Integer customertypeid;

    @ApiModelProperty(value = "会员卡号")
    private String customernumber;

    @ApiModelProperty(value = "入会日期")
    private String jointime;

    @ApiModelProperty(value = "会员到期")
    private String outtime;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "建档日期")
    private String filing;

    @ApiModelProperty(value = "服务顾问id")
    private Integer counselorid;

    @ApiModelProperty(value = "账期")
    private Integer paytime;

    @ApiModelProperty(value = "挂账额度")
    private Integer payment;

    @ApiModelProperty(value = "累计积分")
    private Integer integral;

    @ApiModelProperty(value = "定金金额")
    private Float earnest;

    @ApiModelProperty(value = "纳税人识别号")
    private String paytest;

    @ApiModelProperty(value = "注册电话")
    private String registerphone;

    @ApiModelProperty(value = "开户银行")
    private Integer desportbank;

    @ApiModelProperty(value = "银行账号")
    private String bankaccount;

    @ApiModelProperty(value = "注册地址")
    private String registeraddress;

    @ApiModelProperty(value = "其他一")
    private String otherone;

    @ApiModelProperty(value = "其他二")
    private String othertwo;

    @ApiModelProperty(value = "其他三")
    private String otherthree;

    @ApiModelProperty(value = "其他四")
    private String otherfour;

    @ApiModelProperty(value = "相关证照")
    private String photo;

    @ApiModelProperty(value = "会员卡余额")
    private Float vipprice;

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


    public static final String CUSTOMERNUM = "customernum";

    public static final String CUSTOMERNAME = "customername";

    public static final String CUSTOMERADDRESS = "customeraddress";

    public static final String LINKMAN = "linkman";

    public static final String PHONE = "phone";

    public static final String BIRTHDAY = "birthday";

    public static final String CUSTOMERTYPEID = "customertypeid";

    public static final String CUSTOMERNUMBER = "customernumber";

    public static final String JOINTIME = "jointime";

    public static final String OUTTIME = "outtime";

    public static final String REMARK = "remark";

    public static final String FILING = "filing";

    public static final String COUNSELORID = "counselorid";

    public static final String PAYTIME = "paytime";

    public static final String PAYMENT = "payment";

    public static final String INTEGRAL = "integral";

    public static final String EARNEST = "earnest";

    public static final String PAYTEST = "paytest";

    public static final String REGISTERPHONE = "registerphone";

    public static final String DESPORTBANK = "desportbank";

    public static final String BANKACCOUNT = "bankaccount";

    public static final String REGISTERADDRESS = "registeraddress";

    public static final String OTHERONE = "otherone";

    public static final String OTHERTWO = "othertwo";

    public static final String OTHERTHREE = "otherthree";

    public static final String OTHERFOUR = "otherfour";

    public static final String PHOTO = "photo";

    public static final String VIPPRICE = "vipprice";

    public static final String RESERVED1 = "reserved1";

    public static final String RESERVED2 = "reserved2";

    public static final String RESERVED3 = "reserved3";

    public static final String RESERVED4 = "reserved4";

    public static final String RESERVED5 = "reserved5";

    @Override
    protected Serializable pkVal() {
        return this.customernum;
    }

}
