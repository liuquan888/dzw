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
 * 保养表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Upkeep对象", description="保养表")
public class Upkeep extends Model<Upkeep> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "保养id")
    private Integer upkeepid;

    @ApiModelProperty(value = "车辆号码")
    private Integer carnum;

    @ApiModelProperty(value = "保养名称")
    private String upkeepname;

    @ApiModelProperty(value = "计划日期")
    private String plantime;

    @ApiModelProperty(value = "计划里程")
    private String planmileage;

    @ApiModelProperty(value = "实际日期")
    private String facttime;

    @ApiModelProperty(value = "实际里程")
    private String factmileage;

    @ApiModelProperty(value = "预留字段")
    private String reserved1;

    @ApiModelProperty(value = "预留字段")
    private String reserved2;

    @ApiModelProperty(value = "预留字段")
    private String reserved3;


    public static final String UPKEEPID = "upkeepid";

    public static final String CARNUM = "carnum";

    public static final String UPKEEPNAME = "upkeepname";

    public static final String PLANTIME = "plantime";

    public static final String PLANMILEAGE = "planmileage";

    public static final String FACTTIME = "facttime";

    public static final String FACTMILEAGE = "factmileage";

    public static final String RESERVED1 = "reserved1";

    public static final String RESERVED2 = "reserved2";

    public static final String RESERVED3 = "reserved3";

    @Override
    protected Serializable pkVal() {
        return this.upkeepid;
    }

}
