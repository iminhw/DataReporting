package com.cap.datareporting.validator;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @program: DataReporting
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-29 00:18
 **/
@Data
public class SysDictValid implements Serializable {
    @NotEmpty(message = "字典标识不能为空")
    private String name;
    @NotEmpty(message = "字典标题不能为空")
    private String title;
    @NotNull(message = "字典类型不能为空")
    private Byte type;
    @NotEmpty(message = "字典值不能为空")
    private String value;
}
