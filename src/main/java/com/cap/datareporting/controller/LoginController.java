package com.cap.datareporting.controller;

import com.cap.datareporting.utils.ResultEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @program: blog01
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-12 10:54
 **/
@Controller
public class LoginController {

    @RequestMapping(value = "/ajaxLogin", method = RequestMethod.POST)
    @ResponseBody
    public ResultEntity submitLogin(@RequestParam("username") String username,
                                    @RequestParam("password") String password,
//                                           @RequestParam("url") String url,
                                    @RequestParam("rememberMe") Boolean rememberMe) {
        ResultEntity resultMap = new ResultEntity();
//        if (!username.equals("") && !password.equals("")) return "";
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
            SecurityUtils.getSubject().login(token);
            resultMap.setStatus(200);
            resultMap.setMsg("登录成功");
        } catch (UnknownAccountException e) {
            resultMap.setStatus(500);
            resultMap.setMsg("账号不存在！");
        } catch (IncorrectCredentialsException e1) {
            resultMap.setStatus(500);
            resultMap.setMsg("密码错误！");
        } catch (Exception e) {
            resultMap.setStatus(500);
            resultMap.setMsg("账号不存在");
        }
        return resultMap;
    }

    /**
     * 退出登录
     */
    @GetMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        // "redirect:/login";
        return "redirect:/login";
    }

}
