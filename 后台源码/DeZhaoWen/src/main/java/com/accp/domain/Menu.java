package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 树形菜单
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Menu对象", description="树形菜单")
public class Menu extends Model<Menu> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "菜单名称")
    private String menuname;

    @ApiModelProperty(value = "父级编号")
    private Integer parentid;

    @ApiModelProperty(value = "班组编号")
    private String teamid;


    public static final String ID = "id";

    public static final String MENUNAME = "menuname";

    public static final String PARENTID = "parentid";

    public static final String TEAMID = "teamid";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
