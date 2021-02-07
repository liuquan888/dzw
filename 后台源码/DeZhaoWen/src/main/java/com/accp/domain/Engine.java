package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
<<<<<<< HEAD
=======
import com.baomidou.mybatisplus.annotation.TableId;
>>>>>>> 1602f9564542f755e444c629a7c1495a983617a3
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 发动机表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Engine对象", description="发动机表")
public class Engine extends Model<Engine> {

    private static final long serialVersionUID=1L;

    @TableId(type= IdType.AUTO)
    @ApiModelProperty(value = "发动机品牌编号")
    @TableId(value = "e_id", type = IdType.AUTO)
    private Integer eId;

    @ApiModelProperty(value = "发动机品牌编码")
    private String eCoder;

    @ApiModelProperty(value = "发动机品牌名称")
    private String eName;


    public static final String E_ID = "e_id";

    public static final String E_CODER = "e_coder";

    public static final String E_NAME = "e_name";

    @Override
    protected Serializable pkVal() {
        return this.eId;
    }

}
