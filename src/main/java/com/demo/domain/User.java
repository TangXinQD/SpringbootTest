package com.demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "user",description = "entity")
public class User  implements Serializable{

//    @ApiModelProperty(name = "id",value = "id",required = true)
    private Long id;

    @ApiModelProperty(name = "userName",value = "userName",required = true)
    private String userName;
    @ApiModelProperty(name = "password",value = "password",required = true)
    private String password;

    private String salt;
    @ApiModelProperty(name = "comment",value = "comment",required = true)
    private String comment;

    private Date createTime;

    private Date lastModifyTime;
    @ApiModelProperty(name = "mobile",value = "mobile",required = true)
    private String mobile;

}
