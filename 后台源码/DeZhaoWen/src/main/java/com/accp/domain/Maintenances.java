package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 历史维修
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Maintenances对象", description="历史维修")
public class Maintenances extends Model<Maintenances> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "维修id")
    @TableId(value = "maintainid", type = IdType.AUTO)
    private Integer maintainid;

    @ApiModelProperty(value = "单据类型")
    private String danju;

    @ApiModelProperty(value = "销售单号")
    private String xiaos;

    @ApiModelProperty(value = "车牌号	外键关联车资料表carheet-vehicleid列")
    private Integer chepai;

    @ApiModelProperty(value = "进厂时间")
    private LocalDate jincdate;

    @ApiModelProperty(value = "完工时间")
    private LocalDate wangongdate;

    @ApiModelProperty(value = "结算时间")
    private LocalDate jiesdate;

    @ApiModelProperty(value = "结算金额")
    private Double jiesmone;

    @ApiModelProperty(value = "预留字段")
    private String reserved1;

    @ApiModelProperty(value = "预留字段")
    private String reserved2;

    @ApiModelProperty(value = "预留字段")
    private String reserved3;


    public static final String MAINTAINID = "maintainid";

    public static final String DANJU = "danju";

    public static final String XIAOS = "xiaos";

    public static final String CHEPAI = "chepai";

    public static final String JINCDATE = "jincdate";

    public static final String WANGONGDATE = "wangongdate";

    public static final String JIESDATE = "jiesdate";

    public static final String JIESMONE = "jiesmone";

    public static final String RESERVED1 = "reserved1";

    public static final String RESERVED2 = "reserved2";

    public static final String RESERVED3 = "reserved3";

    @Override
    protected Serializable pkVal() {
        return this.maintainid;
    }

}
