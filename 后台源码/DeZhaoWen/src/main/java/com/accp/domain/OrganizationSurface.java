package com.accp.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.List;

/**
 * <p>
 * 组织机构定义表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OrganizationSurface对象", description="组织机构定义表")
public class OrganizationSurface extends Model<OrganizationSurface> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "子级")
    private List<OrganizationSurface> children;

    @ApiModelProperty(value = "机构id")
    private Integer zid;

    @ApiModelProperty(value = "机构姓名")
    private String zname;

    @ApiModelProperty(value = "上级门店")
    private String msname;

    @ApiModelProperty(value = "售价权重")
    private String mshou;

    @ApiModelProperty(value = "门店分类id")
    private Integer mdianid;

    @ApiModelProperty(value = "最大许可数")
    private String mzuishu;

    @ApiModelProperty(value = "调拨价类")
    private String mtiao;

    @ApiModelProperty(value = "城市id")
    private Integer mcityid;

    @ApiModelProperty(value = "开票单位")
    private String mkai;

    @ApiModelProperty(value = "地址")
    private String maddress;

    @ApiModelProperty(value = "纳税人识别号")
    private String mshui;

    @ApiModelProperty(value = "电话")
    private String mphone;

    @ApiModelProperty(value = "联系人")
    private String mlname;

    @ApiModelProperty(value = "开户银行")
    private Integer mhang;

    @ApiModelProperty(value = "银行账号")
    private String mzhang;

    @ApiModelProperty(value = "横装门店id")
    private Integer mgouid;

    @ApiModelProperty(value = "入户开单/审核分开")
    private String mru;

    @ApiModelProperty(value = "停用")
    private String mting;

    @ApiModelProperty(value = "机构id外键")
    private Integer zids;

    @ApiModelProperty(value = "员工表id外键")
    private Integer zyid;

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


    public static final String ZID = "zid";

    public static final String ZNAME = "zname";

    public static final String MSNAME = "msname";

    public static final String MSHOU = "mshou";

    public static final String MDIANID = "mdianid";

    public static final String MZUISHU = "mzuishu";

    public static final String MTIAO = "mtiao";

    public static final String MCITYID = "mcityid";

    public static final String MKAI = "mkai";

    public static final String MADDRESS = "maddress";

    public static final String MSHUI = "mshui";

    public static final String MPHONE = "mphone";

    public static final String MLNAME = "mlname";

    public static final String MHANG = "mhang";

    public static final String MZHANG = "mzhang";

    public static final String MGOUID = "mgouid";

    public static final String MRU = "mru";

    public static final String MTING = "mting";

    public static final String ZIDS = "zids";

    public static final String ZYID = "zyid";

    public static final String RESERVED1 = "reserved1";

    public static final String RESERVED2 = "reserved2";

    public static final String RESERVED3 = "reserved3";

    public static final String RESERVED4 = "reserved4";

    public static final String RESERVED5 = "reserved5";

    @Override
    protected Serializable pkVal() {
        return this.zid;
    }

}
