package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 车辆品牌
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Carbrand对象", description="车辆品牌")
public class Carbrand extends Model<Carbrand> {

    private static final long serialVersionUID=1L;

    @TableField(exist = false)
    @ApiModelProperty(value = "判断")
    private boolean check=false;

    @TableId(value = "carcoding")
    @ApiModelProperty(value = "车辆编码")
    private String carcoding;

    @ApiModelProperty(value = "品牌名称")
    private String brandname;

    @ApiModelProperty(value = "首字母")
    private String initial;


    public static final String CARCODING = "carcoding";

    public static final String BRANDNAME = "brandname";

    public static final String INITIAL = "initial";

    @Override
    protected Serializable pkVal() {
        return this.carcoding;
    }

}
