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
 * 供应商图片
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ImgSuppiler对象", description="供应商图片")
public class ImgSuppiler extends Model<ImgSuppiler> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "供应商照片编号")
    private String iId;

    @ApiModelProperty(value = "照片路径")
    private String iImgsrc;

    @ApiModelProperty(value = "供应商编号")
    private String pId;


    public static final String I_ID = "i_id";

    public static final String I_IMGSRC = "i_imgsrc";

    public static final String P_ID = "p_id";

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
