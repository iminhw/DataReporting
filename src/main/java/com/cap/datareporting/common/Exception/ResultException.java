package com.cap.datareporting.common.Exception;

import com.cap.datareporting.common.enums.ResultEnum;
import com.cap.datareporting.common.enums.ResultInterface;
import lombok.Getter;

/**
 * 自定义异常对象
 */
@Getter
public class ResultException extends RuntimeException {

    private Integer status;

    /**
     * 统一异常处理
     * @param resultEnum 状态枚举
     */
    public ResultException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.status = resultEnum.getStatus();
    }

    /**
     * 统一异常处理
     * @param resultEnum 枚举类型，需要实现结果枚举接口
     */
    public ResultException(ResultInterface resultEnum) {
        super(resultEnum.getMessage());
        this.status = resultEnum.getStatus();
    }

    /**
     * 统一异常处理
     * @param status 状态码
     * @param message 提示信息
     */
    public ResultException(Integer status, String message) {
        super(message);
        this.status = status;
    }

}
