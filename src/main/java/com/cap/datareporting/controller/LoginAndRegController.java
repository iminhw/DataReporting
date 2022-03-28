package com.cap.datareporting.controller;

import cn.hutool.core.date.DateTime;
import com.cap.datareporting.common.Exception.ResultException;
import com.cap.datareporting.common.enums.ResultEnum;
import com.cap.datareporting.common.enums.StatusEnum;
import com.cap.datareporting.common.utils.ResultVo;
import com.cap.datareporting.common.utils.ResultVoUtil;
import com.cap.datareporting.common.utils.ShiroUtil;
import com.cap.datareporting.component.shiro.UserPassOpenIdToken;
import com.cap.datareporting.component.thymeleaf.utility.ParamUtil;
import com.cap.datareporting.entity.SysUser;
import com.cap.datareporting.entity.SysUserRole;
import com.cap.datareporting.service.SysRoleService;
import com.cap.datareporting.service.SysUserRoleService;
import com.cap.datareporting.service.SysUserService;
import com.cap.datareporting.validator.SysUserValid;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: blog01
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-12 10:54
 **/
@Controller
public class LoginAndRegController {

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    /*
     * 返回String类型的结果
     * 检查用户名的合法性,如果用户已经存在，返回false，否则返回true(返回json数据，格式为{"valid",true})
     */
    @RequestMapping(value = "/checkUN")
    @ResponseBody
    public Map<String, Boolean> checkNameValidMethod1(@RequestParam String username) {
        boolean result = false;
        if (sysUserService.findByUsername(username) == null) {
            result = true;
        }
        Map<String, Boolean> map = new HashMap<>();
        map.put("valid", result);
        return map;
    }

    @RequestMapping(value = "/regAdd", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo addURegister(@Validated SysUserValid sysUserValid,
                                 SysUser sysUser, @RequestParam String password1) {

        // 判断密码是否为空
        if (sysUser.getPassword().isEmpty() || "".equals(sysUser.getPassword().trim())) {
//            throw new ResultException(ResultEnum.USER_PWD_NULL);
            return ResultVoUtil.SAVE_ERROR;
        }

        // 判断两次密码是否一致
        if (!sysUser.getPassword().equals(password1)) {
//            throw new ResultException(ResultEnum.USER_INEQUALITY);
            return ResultVoUtil.SAVE_ERROR;
        }
        if (sysUserService.findByUsername(sysUser.getUsername()) != null) {
            return ResultVoUtil.error(ResultEnum.USER_EXIST.getStatus(),
                    ResultEnum.USER_EXIST.getMessage(), "");
        }
        // 对密码进行加密
        String salt = ShiroUtil.getRandomSalt();
        String encrypt = ShiroUtil.encrypt(sysUser.getPassword(), salt);
        sysUser.setPassword(encrypt);
        sysUser.setSalt(salt);
        sysUser.setCreateDate(new DateTime());
        sysUser.setUpdateDate(new DateTime());
        sysUser.setStatus(StatusEnum.OK.getCode());

//        System.out.println(sysUser);
        try {
            sysUserService.addUser(sysUser);
        } catch (Exception e) {
            return ResultVoUtil.success(ResultEnum.USER_REGISTER_ERROR.getStatus(),
                    ResultEnum.USER_REGISTER_ERROR.getMessage());
        }

        SysUser sysUser1 = sysUserService.findByUsername(sysUser.getUsername());

        sysUserRoleService.addUserRole(new SysUserRole(sysUser1.getId(),
                Long.valueOf(ParamUtil.value("regist_role"))));

        return ResultVoUtil.success(ResultEnum.USER_REGISTER_SUCESS.getStatus(),
                ResultEnum.USER_REGISTER_SUCESS.getMessage(), "/login");

    }

    /**
     * 装载角色默认登陆页
     */
    protected String getRepUrl() {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        String res = "/";
        // 装载角色默认登陆首页
        if (user != null) {
            try {
                List<SysUserRole> userRoleByUid = sysUserRoleService.findUserRoleByUid(user.getId());
                res = sysRoleService.selectByPrimaryKey(userRoleByUid.get(0).getRoleId()).getRemark();
            } catch (Exception e) {
//                e.printStackTrace();
                return res;
            }
        }
        return res;
    }

    @RequestMapping(value = "/ajaxLogin", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo submitLogin(@RequestParam("username") String username,
                                @RequestParam("password") String password,
//                                           @RequestParam("url") String url,
                                @RequestParam(value = "rememberMe",
                                        defaultValue = "false") Boolean rememberMe) {

        // 判断账号密码是否为空
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
//            return ResultVoUtil.error(ResultEnum.USER_NAME_PWD_NULL.getStatus(),
//                    ResultEnum.USER_NAME_PWD_NULL.getMessage());
            throw new ResultException(ResultEnum.USER_NAME_PWD_NULL);
        }
        String repURL = "";
        try {
//            UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
            // 密码登陆方式
            UserPassOpenIdToken token = new UserPassOpenIdToken(username, password, "0");
//            记住我
            token.setRememberMe(rememberMe);
//            登陆
            SecurityUtils.getSubject().login(token);

//            根据用户判断并进入不同的页面
            // 判断是否拥有后台角色
            repURL = getRepUrl();
        } catch (UnknownAccountException e) {
            throw new ResultException(ResultEnum.USER_LOGIN_UP_NULL);
        } catch (IncorrectCredentialsException e1) {
            throw new ResultException(ResultEnum.USER_LOGIN_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResultException(ResultEnum.USER_LOGIN_UP_NULL);
//            resultMap.setStatus(500);
//            resultMap.setMessage("账号不存在!");
        }
        return ResultVoUtil.success(ResultEnum.USER_LOGIN_SUCCESS.getStatus(),
                ResultEnum.USER_LOGIN_SUCCESS.getMessage(), repURL);

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
        return "redirect:login";
    }

}
