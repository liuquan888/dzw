package com.accp.domain;

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
 * 工作中的车辆
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Workcar对象", description="工作中的车辆")
public class Workcar extends Model<Workcar> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "车辆id")
    private Integer id;

    @ApiModelProperty(value = "单据状态")
    private String danjuzt;

    @ApiModelProperty(value = "业务类型")
    private String ywlx;

    @ApiModelProperty(value = "车牌号")
    private Integer chepaih;

    @ApiModelProperty(value = "手机")
    private String phone;

    @ApiModelProperty(value = "会员卡号")
    private String huiykh;

    @ApiModelProperty(value = "维修单号")
    private String wxdh;

    @ApiModelProperty(value = "单据类型")
    private String djlx;

    @ApiModelProperty(value = "开单时间")
    private LocalDate kddate;

    @ApiModelProperty(value = "预计完工")
    private LocalDate yujwg;

    @ApiModelProperty(value = "完工时间")
    private LocalDate wgdate;

    @ApiModelProperty(value = "结算时间")
    private LocalDate jsdate;

    @ApiModelProperty(value = "预估时间")
    private Double ygjine;

    @ApiModelProperty(value = "服务顾问")
    private String fwugw;

    @ApiModelProperty(value = "接车人")
    private String jiecr;

    @ApiModelProperty(value = "预留字段")
    private String reserved1;

    @ApiModelProperty(value = "预留字段")
    private String reserved2;

    @ApiModelProperty(value = "预留字段")
    private String reserved3;


    public static final String ID = "id";

    public static final String DANJUZT = "danjuzt";

    public static final String YWLX = "ywlx";

    public static final String CHEPAIH = "chepaih";

    public static final String PHONE = "phone";

    public static final String HUIYKH = "huiykh";

    public static final String WXDH = "wxdh";

    public static final String DJLX = "djlx";

    public static final String KDDATE = "kddate";

    public static final String YUJWG = "yujwg";

    public static final String WGDATE = "wgdate";

    public static final String JSDATE = "jsdate";

    public static final String YGJINE = "ygjine";

    public static final String FWUGW = "fwugw";

    public static final String JIECR = "jiecr";

    public static final String RESERVED1 = "reserved1";

    public static final String RESERVED2 = "reserved2";

    public static final String RESERVED3 = "reserved3";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
