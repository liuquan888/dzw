package com.accp.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Coll {

    @TableField(exist = false)
    @ApiModelProperty(value = "客户")
    public Customer client;

    @TableField(exist = false)
    @ApiModelProperty(value = "车辆")
    public Carheet carInfo;

    @TableField(exist = false)
    @ApiModelProperty(value = "判断")
    private boolean check;

}
