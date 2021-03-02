package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
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
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Suppilermenu对象", description="供货商菜单")
public class Suppilermenu extends Model<Suppilermenu> {

    private static final long serialVersionUID=1L;

    @TableId(type = IdType.ASSIGN_ID)
    @JsonProperty("sId")
    @ApiModelProperty(value = "供货商菜单编号")
    private Integer sId;

    @JsonProperty("sName")
    @ApiModelProperty(value = "供货商菜单名称")
    private String sName;

    @JsonProperty("sParent")
    @ApiModelProperty(value = "父级供货商菜单编号")
    private Integer sParent;

    @JsonProperty("sTag")
    @ApiModelProperty(value = "菜单标识")
    private String sTag;

    @JsonProperty("suppilermenus")
    @TableField(exist = false)
    private List<Suppilermenu> suppilermenus;


    public static final String S_ID = "s_id";

    public static final String S_NAME = "s_name";

    public static final String S_PARENT = "s_parent";

    public static final String S_TAG = "s_tag";

    @Override
    protected Serializable pkVal() {
        return this.sId;
    }

}
