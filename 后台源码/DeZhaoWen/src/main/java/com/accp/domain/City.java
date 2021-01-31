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
 * 城市表
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="City对象", description="城市表")
public class City extends Model<City> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "城市id")
    private Integer qcityid;

    @ApiModelProperty(value = "城市姓名")
    private String qcityname;

    @ApiModelProperty(value = "城市id")
    private Integer cityid;


    public static final String QCITYID = "qcityid";

    public static final String QCITYNAME = "qcityname";

    public static final String CITYID = "cityid";

    @Override
    protected Serializable pkVal() {
        return this.qcityid;
    }

}
