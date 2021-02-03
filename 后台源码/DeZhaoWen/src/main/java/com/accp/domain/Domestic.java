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
 * 进口国产
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Domestic对象", description="进口国产")
public class Domestic extends Model<Domestic> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "进口国产序号")
    @TableId(value = "d_id", type = IdType.AUTO)
    private Integer dId;

    @ApiModelProperty(value = "进口国产名称")
    private String dName;


    public static final String D_ID = "d_id";

    public static final String D_NAME = "d_name";

    @Override
    protected Serializable pkVal() {
        return this.dId;
    }

}
