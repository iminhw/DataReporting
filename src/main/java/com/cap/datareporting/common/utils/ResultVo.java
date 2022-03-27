package com.cap.datareporting.common.utils;

import lombok.Data;

/**
 * 响应数据(结果)最外层对象
 * @author minhw
 */
@Data
public class ResultVo<T> {

    /** 状态码 */
    private Integer status;

    /** 提示信息 */
    private String message;

    /** 响应数据 */
    private T data;

    private String other;
}
