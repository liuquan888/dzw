package com.accp.domain;

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
 * 油量
 * </p>
 *
 * @author quanl
 * @since 2021-02-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Jcyl对象", description="油量")
public class Jcyl extends Model<Jcyl> {

    private static final long serialVersionUID=1L;

    @TableId("ylid")
    @ApiModelProperty(value = "油量序号")
    private Integer ylid;

    @ApiModelProperty(value = "油量")
    private String yl;


    public static final String YLID = "ylid";

    public static final String YL = "yl";

    @Override
    protected Serializable pkVal() {
        return this.ylid;
    }

}
