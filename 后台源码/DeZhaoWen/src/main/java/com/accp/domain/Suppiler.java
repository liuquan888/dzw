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
 * 供货商
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Suppiler对象", description="供货商")
public class Suppiler extends Model<Suppiler> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "供货商编号")
    private String pId;

    @ApiModelProperty(value = "供货商名称")
    private String pName;

    @ApiModelProperty(value = "供货商地址")
    private String pAddress;

    @ApiModelProperty(value = "经营情况")
    private String pCase;

    @ApiModelProperty(value = "网址")
    private String pUrl;

    @ApiModelProperty(value = "开户行")
    private Integer pBank;

    @ApiModelProperty(value = "银行账号")
    private String pBankaccount;

    @ApiModelProperty(value = "付款方式")
    private Integer paId;

    @ApiModelProperty(value = "厂商等级")
    private Integer raId;

    @ApiModelProperty(value = "经营品牌")
    private String pBrand;

    @ApiModelProperty(value = "联系人")
    private String pLinkman;

    @ApiModelProperty(value = "电话")
    private String pPhone;

    @ApiModelProperty(value = "手机")
    private String pMobile;

    @ApiModelProperty(value = "Email")
    private String pEmail;

    @ApiModelProperty(value = "账期")
    private String pDays;

    @ApiModelProperty(value = "备注")
    private String pRemark;

    @ApiModelProperty(value = "供货商菜单编号	Suppiler表--p_id列")
    private Integer sid;

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
