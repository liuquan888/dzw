package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单商品资料表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="MenuMerchandise对象", description="菜单商品资料表")
public class MenuMerchandise extends Model<MenuMerchandise> {

    private static final long serialVersionUID=1L;
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "菜单商品信息编号")
    private Integer menuId;

    @ApiModelProperty(value = "菜单商品信息名称")
    private String menuName;

    @ApiModelProperty(value = "父级商品菜单编号")
    private Integer menuParent;

    @ApiModelProperty(value = "菜单标识")
    private String menuTag;

    @TableField(exist = false)
    private List<MenuMerchandise> menuMerchandises;


    public static final String MENU_ID = "menu_id";

    public static final String MENU_NAME = "menu_name";

    public static final String MENU_PARENT = "menu_parent";

    public static final String MENU_TAG = "menu_tag";

    @Override
    protected Serializable pkVal() {
        return this.menuId;
    }

}
