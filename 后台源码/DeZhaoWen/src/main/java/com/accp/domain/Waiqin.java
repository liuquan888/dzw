package com.accp.domain;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2021-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Waiqin对象", description="")
public class Waiqin extends Model<Waiqin> {

    private static final long serialVersionUID=1L;

    private String id;

    private String name;

    private String phone;

    private String chepai;

    private String guzhang;

    private String adname;

    private Float cost;

    private Float distance;

    @TableField(exist = false)
    private String desc;


    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String PHONE = "phone";

    public static final String CHEPAI = "chepai";

    public static final String GUZHANG = "guzhang";

    public static final String ADNAME = "adname";

    public static final String COST = "cost";

    public static final String DISTANCE = "distance";

    public static final String DESC = "desc";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
