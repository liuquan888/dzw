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
 * 车辆归属表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Caraffiliation对象", description="车辆归属表")
public class Caraffiliation extends Model<Caraffiliation> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "车辆归属id")
    private Integer caraffiliationid;

    @ApiModelProperty(value = "车辆归属")
    private String caraffiliation;


    public static final String CARAFFILIATIONID = "caraffiliationid";

    public static final String CARAFFILIATION = "caraffiliation";

    @Override
    protected Serializable pkVal() {
        return this.caraffiliationid;
    }

}
