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
 * 学位表
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="AcademicDegree对象", description="学位表")
public class AcademicDegree extends Model<AcademicDegree> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "学位序号")
    private Integer collegeid;

    @ApiModelProperty(value = "学位名称")
    private String name;


    public static final String COLLEGEID = "collegeid";

    public static final String NAME = "name";

    @Override
    protected Serializable pkVal() {
        return this.collegeid;
    }

}
