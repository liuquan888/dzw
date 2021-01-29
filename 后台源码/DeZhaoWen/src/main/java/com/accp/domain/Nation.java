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
 * 民族表
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Nation对象", description="民族表")
public class Nation extends Model<Nation> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "序号")
    private Integer nationid;

    @ApiModelProperty(value = "民族")
    private String name;


    public static final String NATIONID = "nationid";

    public static final String NAME = "name";

    @Override
    protected Serializable pkVal() {
        return this.nationid;
    }

}
