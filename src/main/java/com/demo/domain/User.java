package com.demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "user",description = "用户信息")
public class User  implements Serializable{

//    @ApiModelProperty(name = "id",value = "id",required = true)
    private Long id;

    @ApiModelProperty(name = "userName",value = "用户名",required = true)
    private String userName;
    @ApiModelProperty(name = "password",value = "密码",required = true)
    private String password;

    private String salt;
    @ApiModelProperty(name = "comment",value = "内容",required = true)
    private String comment;

    private Date createTime;

    private Date lastModifyTime;
    @ApiModelProperty(name = "mobile",value = "电话号码",required = true)
    private String mobile;

}
