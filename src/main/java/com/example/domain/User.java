package com.example.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "user",description = "entity")
public class User {

//    @ApiModelProperty(name = "id",value = "id",required = true)
    private Integer id;

    @ApiModelProperty(name = "name",value = "name",required = true)
    private String name;
    @ApiModelProperty(name = "age",value = "age",required = true)
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
