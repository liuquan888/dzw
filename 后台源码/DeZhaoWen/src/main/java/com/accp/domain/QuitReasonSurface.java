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
 * 离职原因表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="QuitReasonSurface对象", description="离职原因表")
public class QuitReasonSurface extends Model<QuitReasonSurface> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "离职日期")
    private String ytime;

    @ApiModelProperty(value = "离职原因")
    private String yreason;

    @ApiModelProperty(value = "员工编号")
    private Integer yid;


    public static final String YTIME = "ytime";

    public static final String YREASON = "yreason";

    public static final String YID = "yid";

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
