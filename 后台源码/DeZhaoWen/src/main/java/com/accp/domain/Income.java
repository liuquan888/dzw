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
 * 收入种类
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Income对象", description="收入种类")
public class Income extends Model<Income> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "收入种类编号")
    @TableId(value = "in_id", type = IdType.AUTO)
    private Integer inId;

    @ApiModelProperty(value = "收入种类名称")
    private String inName;


    public static final String IN_ID = "in_id";

    public static final String IN_NAME = "in_name";

    @Override
    protected Serializable pkVal() {
        return this.inId;
    }

}
