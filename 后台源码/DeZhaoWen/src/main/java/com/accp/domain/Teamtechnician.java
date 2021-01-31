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
 * 
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Teamtechnician对象", description="")
public class Teamtechnician extends Model<Teamtechnician> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "班组编号")
    private Integer teamid;

    @ApiModelProperty(value = "技工编号")
    private String technicianid;

    @ApiModelProperty(value = "技工姓名")
    private String technicianidname;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "手机")
    private String phone;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "出生日期")
    private String birthday;

    @ApiModelProperty(value = "组长")
    private String headman;

    @ApiModelProperty(value = "登录名")
    private String loginname;

    @ApiModelProperty(value = "身份证号")
    private String idnumber;

    @ApiModelProperty(value = "户口地址")
    private String residenceaddress;

    @ApiModelProperty(value = "开户银行id")
    private Integer bankid;

    @ApiModelProperty(value = "银行账号")
    private String bankaccount;

    @ApiModelProperty(value = "等级编号")
    private String code;

    @ApiModelProperty(value = "维修工种")
    private String type;

    @ApiModelProperty(value = "维修工种")
    private String maintenancetype;

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

    public static final String TEAMID = "teamid";

    public static final String TECHNICIANID = "technicianid";

    public static final String TECHNICIANIDNAME = "technicianidname";

    public static final String SEX = "sex";

    public static final String PHONE = "phone";

    public static final String ADDRESS = "address";

    public static final String BIRTHDAY = "birthday";

    public static final String HEADMAN = "headman";

    public static final String LOGINNAME = "loginname";

    public static final String IDNUMBER = "idnumber";

    public static final String RESIDENCEADDRESS = "residenceaddress";

    public static final String BANKID = "bankid";

    public static final String BANKACCOUNT = "bankaccount";

    public static final String CODE = "code";

    public static final String TYPE = "type";

    public static final String MAINTENANCETYPE = "maintenancetype";

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
