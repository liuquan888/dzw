package com.accp.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 技工星级表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Mechanicstar对象", description="技工星级表")
public class Mechanicstar extends Model<Mechanicstar> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "编码")
    private String code;

    @ApiModelProperty(value = "星级")
    private String star;

    @ApiModelProperty(value = "等级")
    private String grade;

    @ApiModelProperty(value = "提成权重")
    @TableField("Commissionweight")
    private String Commissionweight;


    public static final String CODE = "code";

    public static final String STAR = "star";

    public static final String GRADE = "grade";

    public static final String COMMISSIONWEIGHT = "Commissionweight";

    @Override
    protected Serializable pkVal() {
        return this.code;
    }

}
