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
 * 单据类型
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Billstype对象", description="单据类型")
public class Billstype extends Model<Billstype> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "单据类型编号")
    private Integer id;

    @ApiModelProperty(value = "单据类型名称")
    private String type;


    public static final String ID = "id";

    public static final String TYPE = "type";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
