package com.cap.datareporting.validator;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @program: DataReporting
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-29 00:20
 **/
@Data
public class SysUserValid implements Serializable {
    @NotEmpty(message = "身份证号码为空")
    @Size(min = 15, message = "身份证号码错误")
    private String username;
    @NotEmpty(message = "用户昵称不能为空")
    @Size(min = 2, message = "用户昵称：请输入至少2个字符")
    private String nickname;
    @NotEmpty(message = "考生号不能为空")
    @Size(min = 14,max = 14,message = "请输入14为考生号")
    private String ksh;
}