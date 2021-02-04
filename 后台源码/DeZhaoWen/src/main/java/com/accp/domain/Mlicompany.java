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
 * 交强险保险公司表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Mlicompany对象", description="交强险保险公司表")
public class Mlicompany extends Model<Mlicompany> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "交强险保险公司id")
    private Integer mlicompanyid;

    @ApiModelProperty(value = "交强险保险公司")
    private String mlicompany;


    public static final String MLICOMPANYID = "mlicompanyid";

    public static final String MLICOMPANY = "mlicompany";

    @Override
    protected Serializable pkVal() {
        return this.mlicompanyid;
    }

}
