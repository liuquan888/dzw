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
 * 施工班次
 * </p>
 *
 * @author quanl
 * @since 2021-02-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Sgbc对象", description="施工班次")
public class Sgbc extends Model<Sgbc> {

    private static final long serialVersionUID=1L;

    @TableId("xuhid")
    @ApiModelProperty(value = "班次序号")
    private Integer xuhid;

    @ApiModelProperty(value = "施工班次")
    private String banc;


    public static final String XUHID = "xuhid";

    public static final String BANC = "banc";

    @Override
    protected Serializable pkVal() {
        return this.xuhid;
    }

}
