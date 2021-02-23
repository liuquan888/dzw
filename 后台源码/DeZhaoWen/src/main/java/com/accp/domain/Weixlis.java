package com.accp.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 维修历史
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Weixlis对象", description="维修历史")
public class Weixlis extends Model<Weixlis> {

    @TableField(exist = false)
    private Businessclass businessclass;

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "维修单号")
    private String wxdh;

    @ApiModelProperty(value = "接车时间")
    private LocalDate jcsj;

    @ApiModelProperty(value = "业务类型")
    private Integer ywlx;

    @ApiModelProperty(value = "完工时间")
    private LocalDate wgsj;

    @ApiModelProperty(value = "客户名称")
    private String khname;

    @ApiModelProperty(value = "车牌号")
    private String cph;

    @ApiModelProperty(value = "手机")
    private String shoji;

    @ApiModelProperty(value = "会员卡号")
    private String hykh;

    @ApiModelProperty(value = "结算时间")
    private LocalDate jsdate;

    @ApiModelProperty(value = "消费金额")
    private Double xfje;

    @ApiModelProperty(value = "预留字段")
    private String reserved1;

    @ApiModelProperty(value = "预留字段")
    private String reserved2;

    @ApiModelProperty(value = "预留字段")
    private String reserved3;


    public static final String WXDH = "wxdh";

    public static final String JCSJ = "jcsj";

    public static final String YWLX = "ywlx";

    public static final String WGSJ = "wgsj";

    public static final String KHNAME = "khname";

    public static final String CPH = "cph";

    public static final String SHOJI = "shoji";

    public static final String HYKH = "hykh";

    public static final String JSDATE = "jsdate";

    public static final String XFJE = "xfje";

    public static final String RESERVED1 = "reserved1";

    public static final String RESERVED2 = "reserved2";

    public static final String RESERVED3 = "reserved3";

    @Override
    protected Serializable pkVal() {
        return this.wxdh;
    }

}
