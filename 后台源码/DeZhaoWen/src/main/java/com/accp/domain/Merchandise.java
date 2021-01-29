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
 * 菜单信息图片
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Merchandise对象", description="菜单信息图片")
public class Merchandise extends Model<Merchandise> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "商品信息编号")
    private String meId;

    @ApiModelProperty(value = "登记门店")
    private String meCheck;

    @ApiModelProperty(value = "商品名称")
    private String meName;

    @ApiModelProperty(value = "商品品牌")
    private String meBrand;

    @ApiModelProperty(value = "商品使用车型")
    private String meAdaptable;

    @ApiModelProperty(value = "数量单位")
    private String meUnit;

    @ApiModelProperty(value = "收入分类")
    private String meIncome;

    @ApiModelProperty(value = "原厂副厂")
    private String meMill;

    @ApiModelProperty(value = "商品等级")
    private String meGrade;

    @ApiModelProperty(value = "商品产地")
    private String mePlace;

    @ApiModelProperty(value = "原厂编码")
    private String meCoding;

    @ApiModelProperty(value = "条形码")
    private String meCode;

    @ApiModelProperty(value = "包装规格")
    private String meBack;

    @ApiModelProperty(value = "体积")
    private String meBulk;

    @ApiModelProperty(value = "毛重")
    private String meGross;

    @ApiModelProperty(value = "净重")
    private String meSuttle;

    @ApiModelProperty(value = "进货价")
    private String meCost;

    @ApiModelProperty(value = "互换码")
    private String meSwitch;

    @ApiModelProperty(value = "标准价")
    private Float meNormalprice;

    @ApiModelProperty(value = "会员价")
    private Float meMemberprice;

    @ApiModelProperty(value = "Vip价")
    private Float meVipprice;

    @ApiModelProperty(value = "协议价")
    private Float meDetaprice;

    @ApiModelProperty(value = "索赔价")
    private Float meClaimprice;

    @ApiModelProperty(value = "是否展示")
    private Integer meShow;

    @ApiModelProperty(value = "保险价")
    private Float meSafetyprice;

    @ApiModelProperty(value = "商品大类	 menu_merchandise表--menu列")
    private Integer menuId;

    @ApiModelProperty(value = "厂商，供货商编号	Suppiler表--p_id列")
    private String pId;

    @ApiModelProperty(value = "预留字段")
    private String reserved1;

    @ApiModelProperty(value = "预留字段")
    private String reserved2;

    @ApiModelProperty(value = "预留字段")
    private String reserved3;

    @ApiModelProperty(value = "预留字段")
    private String reserved4;

    @ApiModelProperty(value = "预留字段")
    private String reserved5;


    public static final String ME_ID = "me_id";

    public static final String ME_CHECK = "me_check";

    public static final String ME_NAME = "me_name";

    public static final String ME_BRAND = "me_brand";

    public static final String ME_ADAPTABLE = "me_adaptable";

    public static final String ME_UNIT = "me_unit";

    public static final String ME_INCOME = "me_income";

    public static final String ME_MILL = "me_mill";

    public static final String ME_GRADE = "me_grade";

    public static final String ME_PLACE = "me_place";

    public static final String ME_CODING = "me_coding";

    public static final String ME_CODE = "me_code";

    public static final String ME_BACK = "me_back";

    public static final String ME_BULK = "me_bulk";

    public static final String ME_GROSS = "me_gross";

    public static final String ME_SUTTLE = "me_suttle";

    public static final String ME_COST = "me_cost";

    public static final String ME_SWITCH = "me_switch";

    public static final String ME_NORMALPRICE = "me_normalprice";

    public static final String ME_MEMBERPRICE = "me_memberprice";

    public static final String ME_VIPPRICE = "me_vipprice";

    public static final String ME_DETAPRICE = "me_detaprice";

    public static final String ME_CLAIMPRICE = "me_claimprice";

    public static final String ME_SHOW = "me_show";

    public static final String ME_SAFETYPRICE = "me_safetyprice";

    public static final String MENU_ID = "menu_id";

    public static final String P_ID = "p_id";

    public static final String RESERVED1 = "reserved1";

    public static final String RESERVED2 = "reserved2";

    public static final String RESERVED3 = "reserved3";

    public static final String RESERVED4 = "reserved4";

    public static final String RESERVED5 = "reserved5";

    @Override
    protected Serializable pkVal() {
        return this.meId;
    }

}
