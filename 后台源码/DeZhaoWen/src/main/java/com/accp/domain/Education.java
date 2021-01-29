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
 * 学历表
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Education对象", description="学历表")
public class Education extends Model<Education> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "学历编号")
    private Integer educationid;

    @ApiModelProperty(value = "学历名称")
    private String name;


    public static final String EDUCATIONID = "educationid";

    public static final String NAME = "name";

    @Override
    protected Serializable pkVal() {
        return this.educationid;
    }

}
