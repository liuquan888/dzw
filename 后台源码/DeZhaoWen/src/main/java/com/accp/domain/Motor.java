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
 * 发动机表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Motor对象", description="发动机表")
public class Motor extends Model<Motor> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "发动机编号")
    private Integer moId;

    @ApiModelProperty(value = "发动机名称")
    private String moName;

    @ApiModelProperty(value = "发动机品牌编号	Engine表--e_id列")
    private Integer eId;


    public static final String MO_ID = "mo_id";

    public static final String MO_NAME = "mo_name";

    public static final String E_ID = "e_id";

    @Override
    protected Serializable pkVal() {
        return this.moId;
    }

}
