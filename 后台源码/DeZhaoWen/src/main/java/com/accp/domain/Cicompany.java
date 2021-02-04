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
 * 商业保险公司
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Cicompany对象", description="商业保险公司")
public class Cicompany extends Model<Cicompany> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "商业保险公司id")
    private Integer cicompanyid;

    @ApiModelProperty(value = "商业保险公司")
    private String cicompany;


    public static final String CICOMPANYID = "cicompanyid";

    public static final String CICOMPANY = "cicompany";

    @Override
    protected Serializable pkVal() {
        return this.cicompanyid;
    }

}
