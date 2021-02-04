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
 * 车型表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Car对象", description="车型表")
public class Car extends Model<Car> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "车型编号")
    @TableId(value = "c_id", type = IdType.AUTO)
    private Integer cId;

    @ApiModelProperty(value = "车型编码")
    private String cCoder;

    @ApiModelProperty(value = "App展示")
    private Integer cShow;

    @ApiModelProperty(value = "参考价格")
    private Float cRefeprice;

    @ApiModelProperty(value = "车辆年款")
    private Float cVehicle;

    @ApiModelProperty(value = "载重")
    private String cPower;

    @ApiModelProperty(value = "燃油标号")
    private String cFuel;

    @ApiModelProperty(value = "载重")
    private String cLoad;

    @ApiModelProperty(value = "发动机品牌编号")
    private Integer eId;

    @ApiModelProperty(value = "进口国产序号")
    private Integer dId;

    @ApiModelProperty(value = "车型品牌编号")
    private Integer bId;

    @ApiModelProperty(value = "索赔厂，供货商编号")
    private String pId;

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


    public static final String C_ID = "c_id";

    public static final String C_CODER = "c_coder";

    public static final String C_SHOW = "c_show";

    public static final String C_REFEPRICE = "c_refeprice";

    public static final String C_VEHICLE = "c_vehicle";

    public static final String C_POWER = "c_power";

    public static final String C_FUEL = "c_fuel";

    public static final String C_LOAD = "c_load";

    public static final String E_ID = "e_id";

    public static final String D_ID = "d_id";

    public static final String B_ID = "b_id";

    public static final String P_ID = "p_id";

    public static final String RESERVED1 = "reserved1";

    public static final String RESERVED2 = "reserved2";

    public static final String RESERVED3 = "reserved3";

    public static final String RESERVED4 = "reserved4";

    public static final String RESERVED5 = "reserved5";

    @Override
    protected Serializable pkVal() {
        return this.cId;
    }

}
