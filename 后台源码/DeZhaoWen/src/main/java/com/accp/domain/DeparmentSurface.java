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
 * 部门表
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DeparmentSurface对象", description="部门表")
public class DeparmentSurface extends Model<DeparmentSurface> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "部门编号")
    private Integer bid;

    @ApiModelProperty(value = "部门名称")
    private String bname;

    @ApiModelProperty(value = "部门分类")
    private Integer blei;


    public static final String BID = "bid";

    public static final String BNAME = "bname";

    public static final String BLEI = "blei";

    @Override
    protected Serializable pkVal() {
        return this.bid;
    }

}
