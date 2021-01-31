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
 * 燃油表
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Oiltype对象", description="燃油表")
public class Oiltype extends Model<Oiltype> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "燃油类别id")
    @TableId(value = "oiltypeid", type = IdType.AUTO)
    private Integer oiltypeid;

    @ApiModelProperty(value = "燃油类别")
    private String oiltype;


    public static final String OILTYPEID = "oiltypeid";

    public static final String OILTYPE = "oiltype";

    @Override
    protected Serializable pkVal() {
        return this.oiltypeid;
    }

}
