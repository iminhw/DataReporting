package com.cap.datareporting.utils;

import lombok.Data;

/**
 * 响应数据(结果)最外层对象
 * @author minhw
 * @date 2018/10/15
 */
@Data
public class ResultEntity<T> {

    /** 状态码 */
    private Integer status;

    /** 提示信息 */
    private String msg;

    /** 响应数据 */
    private T data;
}
