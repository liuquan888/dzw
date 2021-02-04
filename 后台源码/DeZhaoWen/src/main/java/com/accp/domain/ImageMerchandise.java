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
 * 商品信息图片
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ImageMerchandise对象", description="商品信息图片")
public class ImageMerchandise extends Model<ImageMerchandise> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "商品照片编号")
    private String iId;

    @ApiModelProperty(value = "照片路径")
    private String iImgsrc;

    @ApiModelProperty(value = "商品编号")
    private String meId;


    public static final String I_ID = "i_id";

    public static final String I_IMGSRC = "i_imgsrc";

    public static final String ME_ID = "me_id";

    @Override
    protected Serializable pkVal() {
        return this.iId;
    }

}
