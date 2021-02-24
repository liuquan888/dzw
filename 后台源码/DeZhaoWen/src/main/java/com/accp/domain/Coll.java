package com.accp.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;

public class Coll {

    @TableField(exist = false)
    @ApiModelProperty(value = "客户")
    private Customer client;

    @TableField(exist = false)
    @ApiModelProperty(value = "车辆")
    private Carheet carInfo;

    @TableField(exist = false)
    @ApiModelProperty(value = "判断")
    private boolean check;

    public Customer getClient() {
        return client;
    }

    public void setClient(Customer client) {
        this.client = client;
    }

    public Carheet getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(Carheet carInfo) {
        this.carInfo = carInfo;
    }

    public void setCheck(boolean check){this.check=check; }

    public boolean getCheck(){return check;}

}
