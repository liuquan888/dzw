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
 * 省市区和用户表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Relevance对象", description="省市区和用户表")
public class Relevance extends Model<Relevance> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    private Integer correlationid;

    @ApiModelProperty(value = "客户编码")
    private String customernum;

    @ApiModelProperty(value = "区id")
    private Integer qcityid;


    public static final String CORRELATIONID = "correlationid";

    public static final String CUSTOMERNUM = "customernum";

    public static final String QCITYID = "qcityid";

    @Override
    protected Serializable pkVal() {
        return this.correlationid;
    }

}
