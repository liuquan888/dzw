package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 车型照片
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Image对象", description="车型照片")
public class Image extends Model<Image> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "照片序号")
    @TableId(value = "i_id", type = IdType.AUTO)
    private Integer iId;

    @ApiModelProperty(value = "照片路径")
    private String iImg;

    @ApiModelProperty(value = "车型编号")
    private Integer cId;


    public static final String I_ID = "i_id";

    public static final String I_IMG = "i_img";

    public static final String C_ID = "c_id";

    @Override
    protected Serializable pkVal() {
        return this.iId;
    }

}
