package com.cheneycore.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@ApiModel(value = "User实体", description = "用户参数实体")
@Data
public class User {
    @ApiModelProperty(required = true, notes = "用户")
    @NotBlank(message = "登用户不能为空")
    private String loginName;

    @ApiModelProperty(required = false, notes = "密码")
    @NotBlank(message = "密码不能为空")
    private String loginPwd;

    @ApiModelProperty(required = false, notes = "操作时间")
    private String loginTime;
}
