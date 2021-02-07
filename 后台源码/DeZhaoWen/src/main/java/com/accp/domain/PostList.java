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
 * 岗位表
 * </p>
 *
 * @author quanl
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="PostList对象", description="岗位表")
public class PostList extends Model<PostList> {

    private static final long serialVersionUID=1L;

    @TableId("gid")
    @ApiModelProperty(value = "岗位编码")
    private Integer gid;

    @ApiModelProperty(value = "岗位名称")
    private String gname;


    public static final String GID = "gid";

    public static final String GNAME = "gname";

    @Override
    protected Serializable pkVal() {
        return this.gid;
    }

}
