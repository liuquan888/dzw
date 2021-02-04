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
 * 车牌表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Platenumber对象", description="车牌表")
public class Platenumber extends Model<Platenumber> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "车牌id")
    private Integer plateid;

    @ApiModelProperty(value = "车牌名")
    private String platename;


    public static final String PLATEID = "plateid";

    public static final String PLATENAME = "platename";

    @Override
    protected Serializable pkVal() {
        return this.plateid;
    }

}
