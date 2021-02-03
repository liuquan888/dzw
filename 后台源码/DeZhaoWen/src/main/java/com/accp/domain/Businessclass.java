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
 * 业务类别表
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Businessclass对象", description="业务类别表")
public class Businessclass extends Model<Businessclass> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "业务类别编号")
    @TableId(value = "businessid", type = IdType.AUTO)
    private Integer businessid;

    @ApiModelProperty(value = "业务类别名称")
    private String businessleb;


    public static final String BUSINESSID = "businessid";

    public static final String BUSINESSLEB = "businessleb";

    @Override
    protected Serializable pkVal() {
        return this.businessid;
    }

}
