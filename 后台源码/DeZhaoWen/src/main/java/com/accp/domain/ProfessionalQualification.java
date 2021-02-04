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
 * 专业资格表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ProfessionalQualification对象", description="专业资格表")
public class ProfessionalQualification extends Model<ProfessionalQualification> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "序号")
    private Integer specialtynid;

    @ApiModelProperty(value = "专业")
    private String name;


    public static final String SPECIALTYNID = "specialtynid";

    public static final String NAME = "name";

    @Override
    protected Serializable pkVal() {
        return this.specialtynid;
    }

}
