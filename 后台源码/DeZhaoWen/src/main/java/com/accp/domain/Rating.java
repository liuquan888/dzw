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
 * 商品等级
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Rating对象", description="商品等级")
public class Rating extends Model<Rating> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "商品等级编号")
    @TableId(value = "ra_id", type = IdType.AUTO)
    private Integer raId;

    @ApiModelProperty(value = "商品等级编码")
    private String raCoder;

    @ApiModelProperty(value = "商品等级")
    private String raName;


    public static final String RA_ID = "ra_id";

    public static final String RA_CODER = "ra_coder";

    public static final String RA_NAME = "ra_name";

    @Override
    protected Serializable pkVal() {
        return this.raId;
    }

}
