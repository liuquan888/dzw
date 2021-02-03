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
 * 编制表
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Organization对象", description="编制表")
public class Organization extends Model<Organization> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "序号")
    private Integer organizationid;

    @ApiModelProperty(value = "编制")
    private String name;


    public static final String ORGANIZATIONID = "organizationid";

    public static final String NAME = "name";

    @Override
    protected Serializable pkVal() {
        return this.organizationid;
    }

}
