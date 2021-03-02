package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 供货商
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Suppiler对象", description="供货商")
public class Suppiler extends Model<Suppiler> {

    private static final long serialVersionUID=1L;

    //设置主键  
    @TableId(type = IdType.ASSIGN_ID)
    @JsonProperty("pId")
    @ApiModelProperty(value = "供货商编号")
    private String pId;

    @JsonProperty("pName")
    @ApiModelProperty(value = "供货商名称")
    private String pName;

    @JsonProperty("pAddress")
    @ApiModelProperty(value = "供货商地址")
    private String pAddress;

    @JsonProperty("pCase")
    @ApiModelProperty(value = "经营情况")
    private String pCase;

    @JsonProperty("pUrl")
    @ApiModelProperty(value = "网址")
    private String pUrl;

    @JsonProperty("pBank")
    @ApiModelProperty(value = "开户行")
    private Integer pBank;

    @JsonProperty("pBankaccount")
    @ApiModelProperty(value = "银行账号")
    private String pBankaccount;

    @JsonProperty("paId")
    @ApiModelProperty(value = "付款方式")
    private Integer paId;

    @JsonProperty("raId")
    @ApiModelProperty(value = "厂商等级")
    private Integer raId;

    @JsonProperty("pBrand")
    @ApiModelProperty(value = "经营品牌")
    private String pBrand;

    @JsonProperty("pLinkman")
    @ApiModelProperty(value = "联系人")
    private String pLinkman;

    @JsonProperty("pPhone")
    @ApiModelProperty(value = "电话")
    private String pPhone;

    @JsonProperty("pMobile")
    @ApiModelProperty(value = "手机")
    private String pMobile;

    @JsonProperty("pEmail")
    @ApiModelProperty(value = "Email")
    private String pEmail;

    @JsonProperty("pDays")
    @ApiModelProperty(value = "账期")
    private String pDays;

    @JsonProperty("pRemark")
    @ApiModelProperty(value = "备注")
    private String pRemark;

    @JsonProperty("sid")
    @ApiModelProperty(value = "供货商菜单编号	Suppiler表--p_id列")
    private Integer sid;

    @JsonProperty("reserved1")
    @ApiModelProperty(value = "预留字段")
    private String reserved1;

    @JsonProperty("reserved2")
    @ApiModelProperty(value = "预留字段")
    private String reserved2;

    @JsonProperty("reserved3")
    @ApiModelProperty(value = "预留字段")
    private String reserved3;

    @JsonProperty("reserved4")
    @ApiModelProperty(value = "预留字段")
    private String reserved4;

    @JsonProperty("reserved5")
    @ApiModelProperty(value = "预留字段")
    private String reserved5;

    @TableField(exist = false)
    private Suppilermenu suppilermenu;

    public static final String P_ID = "p_id";

    public static final String P_NAME = "p_name";

    public static final String P_ADDRESS = "p_address";

    public static final String P_CASE = "p_case";

    public static final String P_URL = "p_url";

    public static final String P_BANK = "p_bank";

    public static final String P_BANKACCOUNT = "p_bankaccount";

    public static final String PA_ID = "pa_id";

    public static final String RA_ID = "ra_id";

    public static final String P_BRAND = "p_brand";

    public static final String P_LINKMAN = "p_linkman";

    public static final String P_PHONE = "p_phone";

    public static final String P_MOBILE = "p_mobile";

    public static final String P_EMAIL = "p_email";

    public static final String P_DAYS = "p_days";

    public static final String P_REMARK = "p_remark";

    public static final String SID = "sid";

    public static final String RESERVED1 = "reserved1";

    public static final String RESERVED2 = "reserved2";

    public static final String RESERVED3 = "reserved3";

    public static final String RESERVED4 = "reserved4";

    public static final String RESERVED5 = "reserved5";

    @Override
    protected Serializable pkVal() {
        return this.pId;
    }

}
