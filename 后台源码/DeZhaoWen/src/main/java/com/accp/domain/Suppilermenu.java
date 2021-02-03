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
 * 供货商菜单
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Suppilermenu对象", description="供货商菜单")
public class Suppilermenu extends Model<Suppilermenu> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "供货商菜单编号")
    private Integer sId;

    @ApiModelProperty(value = "供货商菜单名称")
    private String sName;

    @ApiModelProperty(value = "父级供货商菜单编号")
    private Integer sParent;

    @ApiModelProperty(value = "菜单标识")
    private String sTag;


    public static final String S_ID = "s_id";

    public static final String S_NAME = "s_name";

    public static final String S_PARENT = "s_parent";

    public static final String S_TAG = "s_tag";

    @Override
    protected Serializable pkVal() {
        return this.sId;
    }

}
