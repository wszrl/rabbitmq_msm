package com.zrl.rabbitmq_msm.Bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/*
 *@autho  zhengruilong
 *@date 2020-03-16
 */

@Entity
@Table(name = "message")
@ApiModel(description = "person",value = "p")
public class Person {
    //自增
    @Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
    @ApiModelProperty(name = "id")
    private int id;
    @ApiModelProperty(name = "手机户主名字")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @ApiModelProperty(name = "手机号")
    private String tel;
    private String code;

}
