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
 * 籍贯表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="NativPlace对象", description="籍贯表")
public class NativPlace extends Model<NativPlace> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "序号")
    private Integer jnativplaceid;

    @ApiModelProperty(value = "籍贯")
    private String jname;


    public static final String JNATIVPLACEID = "jnativplaceid";

    public static final String JNAME = "jname";

    @Override
    protected Serializable pkVal() {
        return this.jnativplaceid;
    }

}
