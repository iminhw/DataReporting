package com.cap.datareporting.validator;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @program: DataReporting
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-29 00:14
 **/
@Data
public class SysRoleValid implements Serializable {
    @NotEmpty(message = "角色编号不能为空")
    private String name;
    @NotEmpty(message = "角色名称不能为空")
    private String title;
}
