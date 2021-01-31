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
 * 门店分类表
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="StoreClassificarion对象", description="门店分类表")
public class StoreClassificarion extends Model<StoreClassificarion> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "序号id")
    private Integer mlid;

    @ApiModelProperty(value = "门店分类姓名")
    private String mlname;


    public static final String MLID = "mlid";

    public static final String MLNAME = "mlname";

    @Override
    protected Serializable pkVal() {
        return this.mlid;
    }

}
