package com.cap.datareporting.component.shiro;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: blog01
 * @description: shiro 异常自定义 403
 * @author: MinHw or mz
 * @create: 2022-03-12 10:47
 **/
public class ShiroException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        /**如果是shiro无权操作，因为shiro 在操作auno等一部分不进行转发至无权限url */
        if (ex instanceof UnauthorizedException) {
            ModelAndView mv = new ModelAndView("error/403");
            return mv;
        }
        ex.printStackTrace();
        /** 打印异常 ex.printStackTrace();*/
        ModelAndView mv = new ModelAndView("error/403");
        mv.addObject("exception", ex.toString().replaceAll("\n", "<br/>"));
        return mv;
    }
}
