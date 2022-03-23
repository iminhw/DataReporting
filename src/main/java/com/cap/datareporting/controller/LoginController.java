package com.cap.datareporting.controller;

import com.cap.datareporting.common.shiro.UserPassOpenIdToken;
import com.cap.datareporting.entity.SysUser;
import com.cap.datareporting.enums.ResultEnum;
import com.cap.datareporting.utils.ResultEntity;
import com.cap.datareporting.utils.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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

        // 判断账号密码是否为空
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            resultMap.setStatus(ResultEnum.USER_NAME_PWD_NULL.getCode());
            resultMap.setMessage(ResultEnum.USER_NAME_PWD_NULL.getMessage());
            return resultMap;
//            throw new ResultException(ResultEnum.USER_NAME_PWD_NULL);
        }
        try {
//            UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
            // 密码登陆方式
            UserPassOpenIdToken token = new UserPassOpenIdToken(username, password, "0");
//            记住我
            System.err.printf("rememberMe="+rememberMe);
            if (rememberMe != null) {
                token.setRememberMe(true);
            } else {
                token.setRememberMe(false);
            }
//            登陆
            SecurityUtils.getSubject().login(token);

//            根据用户判断并进入不同的页面
            // 判断是否拥有后台角色
            SysUser user = ShiroUtil.getSubject();
            resultMap.setOther("/index");
            resultMap.setStatus(200);
            resultMap.setMessage("登录成功");
        } catch (UnknownAccountException e) {
            resultMap.setStatus(500);
            resultMap.setMessage("该账号已被冻结或账号不存在");
        } catch (IncorrectCredentialsException e1) {
            resultMap.setStatus(500);
            resultMap.setMessage("账号或密码错误");
        } catch (Exception e) {
            resultMap.setStatus(500);
            resultMap.setMessage("账号不存在!");
        }
        return resultMap;
    }

    /**
     * 验证码图片
     */
//    @GetMapping("/captcha")
//    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
//    }

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
