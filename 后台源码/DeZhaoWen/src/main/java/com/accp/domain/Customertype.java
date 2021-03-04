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
 * 客户类别
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Customertype对象", description="客户类别")
public class Customertype extends Model<Customertype> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "客户类别id")
    private Integer customerid;

    @TableField(exist = false)
    @ApiModelProperty(value = "判断")
    private boolean check;

    @ApiModelProperty(value = "客户类别")
    private String customertypeid;


    public static final String CUSTOMERID = "customerid";

    public static final String CUSTOMERTYPEID = "customertypeid";

    @Override
    protected Serializable pkVal() {
        return this.customerid;
    }

}
