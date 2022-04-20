package com.cheneycore.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "ResultVO-> VO", description = "通用响应参数构造")
@Data
public class ResultVO<T> {

    @ApiModelProperty(required = true, notes = "返回数据")
    private T content;

    @ApiModelProperty(required = true, notes = "结果码(0-提示/指定的异常/已知错误,200-OK,201-Created,401-Unauthorized,403-Forbidden,404-Not Found)", example = "200")
    private int code = 200;

    @ApiModelProperty(required = true, notes = "返回信息说明", example = "SUCCESS")
    private String message;

    public ResultVO(T content) {
        this.content = content;
    }

    public ResultVO(int code, String message, T content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    public ResultVO(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public ResultVO() {
    }

    public static <T> ResultVO<T> success(T content) {
        return new ResultVO<T>(content);
    }

    public static ResultVO success() {
        return new ResultVO();
    }

    public static ResultVO exception(String message) {
        return new ResultVO(0, message);
    }

    public static ResultVO fail(int code, String message) {
        return new ResultVO(code, message);
    }

}


