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
 * 车辆资料表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Carheet对象", description="车辆资料表")
public class Carheet extends Model<Carheet> {

    private static final long serialVersionUID=1L;

    @TableField(exist = false)
    @ApiModelProperty(value = "判断")
    private boolean check;

    @ApiModelProperty(value = "车辆号码")
    private Integer carnum;

    @ApiModelProperty(value = "车牌号")
    private String platename;

    @ApiModelProperty(value = "车辆品牌id")
    private String carbrandid;

    @TableField(exist = false)
    @ApiModelProperty(value = "车辆品牌")
    private String pp;

    @ApiModelProperty(value = "驾驶员")
    private String driver;

    @ApiModelProperty(value = "驾驶员电话")
    private String driverphone;

    @ApiModelProperty(value = "出生日期")
    private String birthday;

    @ApiModelProperty(value = "车辆归属id")
    private Integer caraffiliationid;

    @TableField(exist = false)
    @ApiModelProperty(value = "车辆归属")
    private String gs;

    @ApiModelProperty(value = "驾驶员地址")
    private String driveraddress;

    @ApiModelProperty(value = "驾证到期")
    private String drivingouttime;

    @ApiModelProperty(value = "车驾号")
    private String framnum;

    @ApiModelProperty(value = "发动机号")
    private String enginenum;

    @ApiModelProperty(value = "发动机id")
    private Integer engineid;

    @TableField(exist = false)
    @ApiModelProperty(value = "发动机")
    private String fdj;

    @ApiModelProperty(value = "车辆年款")
    private String carnyear;

    @ApiModelProperty(value = "里程")
    private String mileage;

    @ApiModelProperty(value = "载重")
    @TableField(value = "`load`")
    private String load;

    @ApiModelProperty(value = "车系")
    private String carseries;

    @ApiModelProperty(value = "购买日期")
    private String buytime;

    @TableField(exist = false)
    @ApiModelProperty(value = "购买1")
    private String gm1;

    @TableField(exist = false)
    @ApiModelProperty(value = "购买2")
    private String gm2;

    @ApiModelProperty(value = "上牌日期")
    private String uptime;

    @TableField(exist = false)
    @ApiModelProperty(value = "上牌1")
    private String sp1;

    @TableField(exist = false)
    @ApiModelProperty(value = "上牌2")
    private String sp2;

    @ApiModelProperty(value = "车险到期")
    private String carouttime;

    @ApiModelProperty(value = "交强险保险公司id")
    private String mlicompanyid;

    @ApiModelProperty(value = "交强险到期")
    private String mliouttime;

    @TableField(exist = false)
    @ApiModelProperty(value = "交强1")
    private String jq1;

    @TableField(exist = false)
    @ApiModelProperty(value = "交强2")
    private String jq2;

    @ApiModelProperty(value = "商业险保险公司id")
    private String cicompanyid;

    @ApiModelProperty(value = "商业险到期")
    private String ciouttime;

    @TableField(exist = false)
    @ApiModelProperty(value = "商业1")
    private String sy1;

    @TableField(exist = false)
    @ApiModelProperty(value = "商业2")
    private String sy2;

    @ApiModelProperty(value = "在我投保车")
    private String mytoucar;

    @ApiModelProperty(value = "二维日期")
    private String twotime;

    @ApiModelProperty(value = "燃油类别id")
    private Integer oiltypeid;

    @ApiModelProperty(value = "下次保养里程")
    private String nextmileage;

    @ApiModelProperty(value = "下次保养日期")
    private String nextupkeeptime;

    @ApiModelProperty(value = "会员码")
    private String membernum;

    @ApiModelProperty(value = "客户编码")
    private String customernum;

    @TableField(exist = false)
    @ApiModelProperty(value = "客户")
    private Customer kh;

    @ApiModelProperty(value = "保险公司")
    private String reserved1;

    @ApiModelProperty(value = "预留字段")
    private String reserved2;

    @ApiModelProperty(value = "预留字段")
    private String reserved3;

    @ApiModelProperty(value = "预留字段")
    private Integer reserved4;

    @ApiModelProperty(value = "车型ID")
    private String reserved5;

    @TableField(exist = false)
    @ApiModelProperty(value = "车型")
    private String chexing;

    public static final String CARNUM = "carnum";

    public static final String PLATENAME = "platename";

    public static final String CARBRANDID = "carbrandid";

    public static final String DRIVER = "driver";

    public static final String DRIVERPHONE = "driverphone";

    public static final String BIRTHDAY = "birthday";

    public static final String CARAFFILIATIONID = "caraffiliationid";

    public static final String DRIVERADDRESS = "driveraddress";

    public static final String DRIVINGOUTTIME = "drivingouttime";

    public static final String FRAMNUM = "framnum";

    public static final String ENGINENUM = "enginenum";

    public static final String ENGINEID = "engineid";

    public static final String CARNYEAR = "carnyear";

    public static final String MILEAGE = "mileage";

    public static final String LOAD = "load";

    public static final String CARSERIES = "carseries";

    public static final String BUYTIME = "buytime";

    public static final String UPTIME = "uptime";

    public static final String CAROUTTIME = "carouttime";

    public static final String MLICOMPANYID = "mlicompanyid";

    public static final String MLIOUTTIME = "mliouttime";

    public static final String CICOMPANYID = "cicompanyid";

    public static final String CIOUTTIME = "ciouttime";

    public static final String MYTOUCAR = "mytoucar";

    public static final String TWOTIME = "twotime";

    public static final String OILTYPEID = "oiltypeid";

    public static final String NEXTMILEAGE = "nextmileage";

    public static final String NEXTUPKEEPTIME = "nextupkeeptime";

    public static final String MEMBERNUM = "membernum";

    public static final String CUSTOMERNUM = "customernum";

    public static final String RESERVED1 = "reserved1";

    public static final String RESERVED2 = "reserved2";

    public static final String RESERVED3 = "reserved3";

    public static final String RESERVED4 = "reserved4";

    public static final String RESERVED5 = "reserved5";

    @Override
    protected Serializable pkVal() {
        return this.carnum;
    }

}

