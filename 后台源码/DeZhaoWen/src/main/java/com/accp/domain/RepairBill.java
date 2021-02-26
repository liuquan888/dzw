package com.accp.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 维修单据表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="RepairBill对象", description="维修单据表")
public class RepairBill extends Model<RepairBill> {

    private static final long serialVersionUID=1L;

    @TableId(value = "no")
    @ApiModelProperty(value = "销售单号")
    private String no;



    @ApiModelProperty(value = "单据类型表外键id")
    private Integer documentsType;

    @TableField(exist=false)
    @ApiModelProperty(value = "单据类型")
    private String dType;

    @ApiModelProperty(value = "结算方式表外键id")
    private Integer balanceType;

    @TableField(exist=false)
    @ApiModelProperty(value = "结算方式")
    private String bType;

    @ApiModelProperty(value = "单据状态表外键id")
    private Integer documentsState;

    @TableField(exist=false)
    @ApiModelProperty(value = "单据状态")
    private String dState;

    @ApiModelProperty(value = "结算状态表外键id")
    private Integer balanceState;

    @TableField(exist=false)
    @ApiModelProperty(value = "结算状态")
    private String bState;

    @ApiModelProperty(value = "结算时间")
    private LocalDateTime jiesuanTime;

    @ApiModelProperty(value = "结算人")
    private String jiesuanRen;

    @ApiModelProperty(value = "结算金额")
    private Double amount;

    @ApiModelProperty(value = "业务类型")
    private String yewulx;

    @ApiModelProperty(value = "客户名称")
    private String keihuName;

    @ApiModelProperty(value = "车牌号")
    private Integer chepaiNo;

    @TableField(exist=false)
    @ApiModelProperty(value = "车牌")
    private String chepai;

    @ApiModelProperty(value = "车型")
    private String chexin;

    @ApiModelProperty(value = "车架号")
    private String chejiaoNo;

    @ApiModelProperty(value = "联系电话")
    private String phone;

    @ApiModelProperty(value = "保险公司")
    private String bxCompany;

    @ApiModelProperty(value = "赔款公司")
    private String pkCompany;

    @ApiModelProperty(value = "对方车牌")
    private String duifanchepai;

    @ApiModelProperty(value = "服务顾问，外键顾问表id")
    private Integer counsellor;

    @TableField(exist=false)
    @ApiModelProperty(value = "服务顾问")
    private String coun;

    @ApiModelProperty(value = "完工时间")
    private LocalDateTime completionTime;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "发动机号，发动机表外键id")
    private Integer motorId;

    @ApiModelProperty(value = "车主id,客户表外键")
    private Integer customerId;

    @ApiModelProperty(value = "驾驶员")
    private String jiashiyuan;

    @ApiModelProperty(value = "进场里程")
    private String jclichen;

    @ApiModelProperty(value = "进场油量")
    private String jcyoulian;

    @ApiModelProperty(value = "上次里程")
    private String shancilichen;

    @ApiModelProperty(value = "进场时间")
    private LocalDateTime jctime;

    @ApiModelProperty(value = "施工班次")
    private String shigonbanci;

    @ApiModelProperty(value = "接车人")
    private String jiecher;

    @ApiModelProperty(value = "预计完工")
    private LocalDateTime yujitime;

    @ApiModelProperty(value = "上次进场时间")
    private LocalDateTime sctime;

    @ApiModelProperty(value = "预估金额")
    private Double yugujine;

    @ApiModelProperty(value = "保修陈述")
    private String chenshu;

    @ApiModelProperty(value = "客户ID")
    private String reserved1;

    @ApiModelProperty(value = "预留字段")
    private String reserved2;

    @ApiModelProperty(value = "预留字段")
    private String reserved3;

    @ApiModelProperty(value = "预留字段")
    private String reserved4;

    @ApiModelProperty(value = "预留字段")
    private String reserved5;


    public static final String NO = "no";

    public static final String DOCUMENTS_TYPE = "documents_type";

    public static final String BALANCE_TYPE = "balance_type";

    public static final String DOCUMENTS_STATE = "documents_state";

    public static final String BALANCE_STATE = "balance_state";

    public static final String JIESUAN_TIME = "jiesuan_time";

    public static final String JIESUAN_REN = "jiesuan_ren";

    public static final String AMOUNT = "amount";

    public static final String YEWULX = "yewulx";

    public static final String KEIHU_NAME = "keihu_name";

    public static final String CHEPAI_NO = "chepai_no";

    public static final String CHEXIN = "chexin";

    public static final String CHEJIAO_NO = "chejiao_no";

    public static final String PHONE = "phone";

    public static final String BX_COMPANY = "bx_company";

    public static final String PK_COMPANY = "pk_company";

    public static final String DUIFANCHEPAI = "duifanchepai";

    public static final String COUNSELLOR = "counsellor";

    public static final String COMPLETION_TIME = "completion_time";

    public static final String REMARK = "remark";

    public static final String MOTOR_ID = "motor_id";

    public static final String CUSTOMER_ID = "customer_id";

    public static final String JIASHIYUAN = "jiashiyuan";

    public static final String JCLICHEN = "jclichen";

    public static final String JCYOULIAN = "jcyoulian";

    public static final String SHANCILICHEN = "shancilichen";

    public static final String JCTIME = "jctime";

    public static final String SHIGONBANCI = "shigonbanci";

    public static final String JIECHER = "jiecher";

    public static final String YUJITIME = "yujitime";

    public static final String SCTIME = "sctime";

    public static final String YUGUJINE = "yugujine";

    public static final String CHENSHU = "chenshu";

    public static final String RESERVED1 = "reserved1";

    public static final String RESERVED2 = "reserved2";

    public static final String RESERVED3 = "reserved3";

    public static final String RESERVED4 = "reserved4";

    public static final String RESERVED5 = "reserved5";

    @Override
    protected Serializable pkVal() {
        return this.no;
    }


}
