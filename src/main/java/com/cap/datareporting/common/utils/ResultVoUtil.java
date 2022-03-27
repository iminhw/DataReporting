package com.cap.datareporting.common.utils;

import com.cap.datareporting.common.enums.ResultEnum;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 响应数据(结果)最外层对象工具
 * @author minhw
 * @date 2018/10/15
 */
public class ResultVoUtil {

    public static ResultVo SAVE_SUCCESS = success("保存成功");
    public static ResultVo SAVE_ERROR = success("保存失败");

    /**
     * 操作成功
     * @param code
     * @param msg
     * @param object
     * @param other
     * @return
     */
    public static ResultVo success(Integer code, String msg, Object object, String other){
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setMessage(msg);
        resultVo.setStatus(code);
        resultVo.setData(object);
        resultVo.setOther(other);
        return resultVo;
    }

    /**
     *
     * @param code
     * @param msg
     * @param object
     * @return
     */
    public static ResultVo success(Integer code, String msg, Object object){
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setMessage(msg);
        resultVo.setStatus(code);
        resultVo.setData(object);
        return resultVo;
    }

    public static ResultVo success(Integer code, String msg){
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setMessage(msg);
        resultVo.setStatus(code);
        return resultVo;
    }

    /**
     * 操作成功 (默认状态
     * @param msg 提示信息
     * @param object 对象
     */
    public static ResultVo success(String msg, Object object, String other){
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setMessage(msg);
        resultVo.setStatus(ResultEnum.SUCCESS.getStatus());
        resultVo.setData(object);
        resultVo.setOther(other);
        return resultVo;
    }


    /**
     * 操作成功 (默认状态
     * @param msg 提示信息
     * @param object 对象
     */
    public static ResultVo success(String msg, Object object){
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setMessage(msg);
        resultVo.setStatus(ResultEnum.SUCCESS.getStatus());
        resultVo.setData(object);
        return resultVo;
    }

    /**
     * 操作成功，使用默认的提示信息
     * @param object 对象
     */
    public static ResultVo success(Object object){
        String message = ResultEnum.SUCCESS.getMessage();
        return success(message, object);
    }

    /**
     * 操作成功，返回提示信息和状态，不返回数据
     */
    public static ResultVo success(Integer code, String msg, String other){
        Object object = null;
        return success(code, msg, object, other);
    }

    /**
     * 操作成功，返回提示信息，不返回数据
     */
    public static ResultVo success(String msg){
        Object object = null;
        return success(msg, object);
    }

    /**
     * 操作成功，不返回数据
     */
    public static ResultVo success(){
        return success(null);
    }

    /**
     * 操作有误
     * @param code
     * @param msg
     * @param other
     * @return
     */
    public static ResultVo error(Integer code, String msg, String other){
        ResultVo resultVo = new ResultVo();
        resultVo.setMessage(msg);
        resultVo.setStatus(code);
        resultVo.setOther(other);
        return resultVo;
    }

    /**
     * 操作有误
     * @param code 错误码
     * @param msg 提示信息
     */
    public static ResultVo error(Integer code, String msg){
        ResultVo resultVo = new ResultVo();
        resultVo.setMessage(msg);
        resultVo.setStatus(code);
        return resultVo;
    }

    /**
     * 操作有误，使用默认 400 错误码
     * @param msg 提示信息
     */
    public static ResultVo error(String msg){
        Integer code = ResultEnum.ERROR.getStatus();
        return error(code, msg);
    }

    /**
     * 操作有误，只返回默认错误状态码
     */
    public static ResultVo error(){
        return error(null);
    }

}
