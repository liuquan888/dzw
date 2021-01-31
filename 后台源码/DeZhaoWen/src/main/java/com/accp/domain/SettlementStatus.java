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
 * 结算状态表
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SettlementStatus对象", description="结算状态表")
public class SettlementStatus extends Model<SettlementStatus> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "唯一编号")
    private Integer id;

    @ApiModelProperty(value = "状态名称")
    private String type;


    public static final String ID = "id";

    public static final String TYPE = "type";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
