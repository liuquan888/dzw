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
 * 支付方式表
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Pattern对象", description="支付方式表")
public class Pattern extends Model<Pattern> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "发动机品牌编号")
    @TableId(value = "pa_id", type = IdType.AUTO)
    private Integer paId;

    @ApiModelProperty(value = "发动机品牌编码")
    private String paCoder;

    @ApiModelProperty(value = "发动机品牌名称")
    private String paName;


    public static final String PA_ID = "pa_id";

    public static final String PA_CODER = "pa_coder";

    public static final String PA_NAME = "pa_name";

    @Override
    protected Serializable pkVal() {
        return this.paId;
    }

}
