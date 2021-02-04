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
 * 工厂表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Factory对象", description="工厂表")
public class Factory extends Model<Factory> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "厂id")
    private Integer factory;

    @ApiModelProperty(value = "厂名")
    private String factoryname;


    public static final String FACTORY = "factory";

    public static final String FACTORYNAME = "factoryname";

    @Override
    protected Serializable pkVal() {
        return this.factory;
    }

}
