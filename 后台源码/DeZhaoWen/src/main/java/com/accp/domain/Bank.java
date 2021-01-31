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
 * 银行表
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Bank对象", description="银行表")
public class Bank extends Model<Bank> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "银行编号")
    @TableId(value = "bankid", type = IdType.AUTO)
    private Integer bankid;

    @ApiModelProperty(value = "银行名称")
    private String bankname;


    public static final String BANKID = "bankid";

    public static final String BANKNAME = "bankname";

    @Override
    protected Serializable pkVal() {
        return this.bankid;
    }

}
