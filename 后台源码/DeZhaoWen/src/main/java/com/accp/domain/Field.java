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
 * 
 * </p>
 *
 * @author quanl
 * @since 2021-02-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Field对象", description="")
public class Field extends Model<Field> {

    private static final long serialVersionUID=1L;

    private Integer id;

    private Integer width;

    private String name;

    private String zname;

    private String display;


    public static final String ID = "id";

    public static final String WIDTH = "width";

    public static final String NAME = "name";

    public static final String ZNAME = "zname";

    public static final String DISPLAY = "display";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
