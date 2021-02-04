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
 * 婚姻状态表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="MaritalStatus对象", description="婚姻状态表")
public class MaritalStatus extends Model<MaritalStatus> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "序号")
    private Integer marriageid;

    @ApiModelProperty(value = "婚姻状况")
    private String name;


    public static final String MARRIAGEID = "marriageid";

    public static final String NAME = "name";

    @Override
    protected Serializable pkVal() {
        return this.marriageid;
    }

}
