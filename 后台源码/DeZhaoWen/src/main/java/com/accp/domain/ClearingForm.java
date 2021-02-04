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
 * 结算方式表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ClearingForm对象", description="结算方式表")
public class ClearingForm extends Model<ClearingForm> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "结算方式编号")
    private Integer id;

    @ApiModelProperty(value = "结算方式名称")
    private String type;


    public static final String ID = "id";

    public static final String TYPE = "type";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
