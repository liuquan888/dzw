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
 * 单据状态表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DocumentStatus对象", description="单据状态表")
public class DocumentStatus extends Model<DocumentStatus> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "单据状态id")
    private Integer id;

    @ApiModelProperty(value = "单据状态名称")
    private String type;


    public static final String ID = "id";

    public static final String TYPE = "type";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
