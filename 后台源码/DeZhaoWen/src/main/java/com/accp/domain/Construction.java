package com.accp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 
 * </p>
 *
 * @author quanl
 * @since 2021-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Construction对象", description="")
public class Construction extends Model<Construction> {

    private static final long serialVersionUID=1L;

    @TableId(value = "constructionid", type = IdType.AUTO)
    private Integer constructionid;

    private String constructian;


    public static final String CONSTRUCTIONID = "constructionid";

    public static final String CONSTRUCTIAN = "constructian";

    @Override
    protected Serializable pkVal() {
        return this.constructionid;
    }

}
