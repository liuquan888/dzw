package com.accp.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 顾问表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Counselor对象", description="顾问表")
public class Counselor extends Model<Counselor> {

    private static final long serialVersionUID=1L;

    @TableId(value = "counselorid")
    @ApiModelProperty(value = "顾问Id")
    private Integer counselorid;

    @ApiModelProperty(value = "顾问名称")
    private String counselorname;

    @ApiModelProperty(value = "顾问电话")
    private String counselorphone;

    @ApiModelProperty(value = "部门名称")
    private String bramch;

    @ApiModelProperty(value = "工号")
    private String jobnum;

    @ApiModelProperty(value = "厂id")
    private Integer factoryid;

    @ApiModelProperty(value = "预留字段")
    private String reserved1;

    @ApiModelProperty(value = "预留字段")
    private String reserved2;

    @ApiModelProperty(value = "预留字段")
    private String reserved3;


    public static final String COUNSELORID = "counselorid";

    public static final String COUNSELORNAME = "counselorname";

    public static final String COUNSELORPHONE = "counselorphone";

    public static final String BRAMCH = "bramch";

    public static final String JOBNUM = "jobnum";

    public static final String FACTORYID = "factoryid";

    public static final String RESERVED1 = "reserved1";

    public static final String RESERVED2 = "reserved2";

    public static final String RESERVED3 = "reserved3";

    @Override
    protected Serializable pkVal() {
        return this.counselorid;
    }

}
