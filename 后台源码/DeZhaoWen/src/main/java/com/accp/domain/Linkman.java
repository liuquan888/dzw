package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 联系人

 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Linkman对象", description="联系人")
public class Linkman extends Model<Linkman> {

    private static final long serialVersionUID=1L;

    @JsonProperty("lId")
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "供应商联系人编号")
    private Integer lId;

    @JsonProperty("lPost")
    @ApiModelProperty(value = "供应商联系人职位")
    private String lPost;

    @JsonProperty("lName")
    @ApiModelProperty(value = "供应商联系人姓名")
    private String lName;

    @JsonProperty("lPhone")
    @ApiModelProperty(value = "供应商联系人电话")
    private String lPhone;

    @JsonProperty("lMobile")
    @ApiModelProperty(value = "供应商联系人手机")
    private String lMobile;

    @JsonProperty("lEmile")
    @ApiModelProperty(value = "供应商联系人Emile")
    private String lEmile;

    @JsonProperty("pId")
    @ApiModelProperty(value = "供应商编号")
    private String pId;

    @ApiModelProperty(value = "预留字段")
    private String reserved1;

    @ApiModelProperty(value = "预留字段")
    private String reserved2;

    @ApiModelProperty(value = "预留字段")
    private String reserved3;


    public static final String L_ID = "l_id";

    public static final String L_POST = "l_post";

    public static final String L_NAME = "l_name";

    public static final String L_PHONE = "l_phone";

    public static final String L_MOBILE = "l_mobile";

    public static final String L_EMILE = "l_emile";

    public static final String P_ID = "p_id";

    public static final String RESERVED1 = "reserved1";

    public static final String RESERVED2 = "reserved2";

    public static final String RESERVED3 = "reserved3";

    @Override
    protected Serializable pkVal() {
        return this.lId;
    }

}
