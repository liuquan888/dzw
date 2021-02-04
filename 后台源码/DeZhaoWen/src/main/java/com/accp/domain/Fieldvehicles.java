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
 * 外勤车辆表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Fieldvehicles对象", description="外勤车辆表")
public class Fieldvehicles extends Model<Fieldvehicles> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "车牌号")
    private String licenseplate;

    @ApiModelProperty(value = "品牌")
    private String brand;

    @ApiModelProperty(value = "车型")
    private String model;

    @ApiModelProperty(value = "当前里程")
    private String currentmileage;

    @ApiModelProperty(value = "班组编号")
    private String teamid;

    @ApiModelProperty(value = "预留字段")
    private String reserved1;

    @ApiModelProperty(value = "预留字段")
    private String reserved2;

    @ApiModelProperty(value = "预留字段")
    private String reserved3;


    public static final String ID = "id";

    public static final String LICENSEPLATE = "licenseplate";

    public static final String BRAND = "brand";

    public static final String MODEL = "model";

    public static final String CURRENTMILEAGE = "currentmileage";

    public static final String TEAMID = "teamid";

    public static final String RESERVED1 = "reserved1";

    public static final String RESERVED2 = "reserved2";

    public static final String RESERVED3 = "reserved3";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
