package com.cheneycore.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "ResultVO-> VO", description = "通用对象返回")
@Data
public class ResultVO<T> {

    @ApiModelProperty(required = true, notes = "返回数据")
    private T content;

    @ApiModelProperty(required = true, notes = "返回成功与否", example = "true")
    private boolean succeed = true;

    @ApiModelProperty(required = true, notes = "结果码", example = "200")
    private int code = 0;

    @ApiModelProperty(required = true, notes = "返回信息说明", example = "SUCCESS")
    private String msg;

    public ResultVO(T content) {
        this.content = content;
    }

    public ResultVO(boolean succeed, int code, String msg, T content) {
        this.succeed = succeed;
        this.code = code;
        this.msg = msg;
        this.content = content;
    }

    public ResultVO(boolean succeed, int code, String msg) {
        this.succeed = succeed;
        this.code = code;
        this.msg = msg;
    }

    public ResultVO() {

    }

    public static <T> ResultVO<T> success(T content) {
        return new ResultVO<T>(content);
    }

    public static ResultVO success() {
        return new ResultVO();
    }

    public static ResultVO fail(int code, String msg) {
        return new ResultVO(false, code, msg);
    }

    public static ResultVO fail(String msg) {
        return new ResultVO(false, -1, msg);
    }

    public static ResultVO fail() {
        return fail("fail");
    }
}


