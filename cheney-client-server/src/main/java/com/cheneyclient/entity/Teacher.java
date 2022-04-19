package com.cheneyclient.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "教师主表-> TAB_TEACHER", description = "教师实体表")
@NoArgsConstructor// 创建无参的构造方法
@AllArgsConstructor// 创建满参的构造方法
@Accessors(chain = true)// 使用链式方法
@Data// 重写toString方法等方法
@TableName("tab_teacher")// 对应表名
public class Teacher implements Serializable {

    // 主键必须有TableId注解
    @ApiModelProperty("唯一编号")
    @TableId(value = "pk_teacher_id", type = IdType.AUTO)
    private Integer teacherId;

    @ApiModelProperty(value = "教师名称", required = true)
    @NotBlank(message = "教师名称不能为空")
    @TableField("teacher_name")
    private String teacherName;

    @ApiModelProperty("性别")
    @TableField("teacher_sex")
    private String teacherSex;

    @ApiModelProperty("薪水")
    @TableField("teacher_salary")
    private Double teacherSalary;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)// 插入时自动填充
    private Date createTime;

    @ApiModelProperty("修改时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)// 插入和修改时自动填充
    private Date updateTime;

    @ApiModelProperty("删除标识：默认0是未删除, 1是已删除")
    @TableField(value = "visibility", fill = FieldFill.INSERT)
    @TableLogic(value = "0", delval = "1")// 指定字段为逻辑删除字段, 默认0是未删除, 1是已删除
    private Integer visibility;

}
