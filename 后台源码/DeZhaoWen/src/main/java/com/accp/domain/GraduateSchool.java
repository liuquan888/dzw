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
 * 学校表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="GraduateSchool对象", description="学校表")
public class GraduateSchool extends Model<GraduateSchool> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "序号")
    private Integer schoolid;

    @ApiModelProperty(value = "毕业学校")
    private String name;


    public static final String SCHOOLID = "schoolid";

    public static final String NAME = "name";

    @Override
    protected Serializable pkVal() {
        return this.schoolid;
    }

}
