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
 * 车型品牌
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Brand对象", description="车型品牌")
public class Brand extends Model<Brand> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "车型品牌编号")
    private Integer bId;

    @ApiModelProperty(value = "车型品牌名称")
    private String bName;

    @ApiModelProperty(value = "品牌首字母")
    private String bInital;


    public static final String B_ID = "b_id";

    public static final String B_NAME = "b_name";

    public static final String B_INITAL = "b_inital";

    @Override
    protected Serializable pkVal() {
        return this.bId;
    }

}
