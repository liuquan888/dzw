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
 * 技工提成比例
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Mechaniccommission对象", description="技工提成比例")
public class Mechaniccommission extends Model<Mechaniccommission> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "分类编码")
    private Integer typeid;

    @ApiModelProperty(value = "分类名称")
    private String typename;

    @ApiModelProperty(value = "站内白天")
    private Double dayinthestation;

    @ApiModelProperty(value = "站内晚上")
    private Double nightinthestation;

    @ApiModelProperty(value = "站外白天")
    private Double dayoutthestation;

    @ApiModelProperty(value = "站外晚上")
    private Double nightoutthestation;

    @ApiModelProperty(value = "预留字段")
    private String reserved1;

    @ApiModelProperty(value = "预留字段")
    private String reserved2;

    @ApiModelProperty(value = "预留字段")
    private String reserved3;


    public static final String TYPEID = "typeid";

    public static final String TYPENAME = "typename";

    public static final String DAYINTHESTATION = "dayinthestation";

    public static final String NIGHTINTHESTATION = "nightinthestation";

    public static final String DAYOUTTHESTATION = "dayoutthestation";

    public static final String NIGHTOUTTHESTATION = "nightoutthestation";

    public static final String RESERVED1 = "reserved1";

    public static final String RESERVED2 = "reserved2";

    public static final String RESERVED3 = "reserved3";

    @Override
    protected Serializable pkVal() {
        return this.typeid;
    }

}
