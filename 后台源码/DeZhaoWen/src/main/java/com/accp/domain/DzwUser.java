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
 * 用户表
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DzwUser对象", description="用户表")
public class DzwUser extends Model<DzwUser> {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户唯一编号")
    private Integer userId;

    @ApiModelProperty(value = "用户昵称")
    private String userName;

    @ApiModelProperty(value = "登录账号")
    private String userLogin;

    @ApiModelProperty(value = "登录密码")
    private String userPwd;

    @ApiModelProperty(value = "真实姓名")
    private String userRealname;

    @ApiModelProperty(value = "用户性别，00：代表女，11：代表男，03：代表未知")
    private String userSex;

    @ApiModelProperty(value = "手机号")
    private String userPhone;

    @ApiModelProperty(value = "邮箱")
    private String userEamil;

    @ApiModelProperty(value = "地址")
    private String userAddress;

    @ApiModelProperty(value = "用户状态，0000：代表有效，0001：代表无效，0002：代表伪删除")
    private String status;

    @ApiModelProperty(value = "创建时间")
    private LocalDate createDate;

    @ApiModelProperty(value = "最近更新时间")
    private LocalDate updateDate;

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


    public static final String USER_ID = "user_id";

    public static final String USER_NAME = "user_name";

    public static final String USER_LOGIN = "user_login";

    public static final String USER_PWD = "user_pwd";

    public static final String USER_REALNAME = "user_realname";

    public static final String USER_SEX = "user_sex";

    public static final String USER_PHONE = "user_phone";

    public static final String USER_EAMIL = "user_eamil";

    public static final String USER_ADDRESS = "user_address";

    public static final String STATUS = "status";

    public static final String CREATE_DATE = "create_date";

    public static final String UPDATE_DATE = "update_date";

    public static final String RESERVED1 = "reserved1";

    public static final String RESERVED2 = "reserved2";

    public static final String RESERVED3 = "reserved3";

    public static final String RESERVED4 = "reserved4";

    public static final String RESERVED5 = "reserved5";

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
