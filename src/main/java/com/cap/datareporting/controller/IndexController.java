package com.cap.datareporting.controller;

import com.cap.datareporting.common.utils.ToolUtil;
import com.cap.datareporting.component.thymeleaf.utility.ParamUtil;
import com.cap.datareporting.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: blog01
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-12 02:34
 **/
@Controller
public class IndexController {
//    @Autowired
//    private ArticleService articleService;
//    @Autowired
//    private SysCategoryService sysCategoryService;

    @RequestMapping({"", "/index"})
    public String index(Model model) {

//        List<Article> articleList = articleService.selectArticleList();
//
//        model.addAttribute("articleList", articleList);
//        model.addAttribute("syscateList", sysCategoryService.findSysCategory());
//        model.addAttribute("top10List", articleService.findTop10());

        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

//    @RequestMapping(value = "/login1", method = RequestMethod.GET)

//    @RequiresPermissions("user:del")//权限管理;
//    public String login1() {
//        return "/login1";
//    }

    @RequestMapping({"/register"})
    public String register() {
        return "register";
    }

    @RequestMapping({"/admin"})
    @RequiresPermissions("admin/index")//权限管理;
    public String adminIndx(Model model) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "admin/index";
    }

    @RequestMapping({"/admin/teacher/winner"})
    @RequiresPermissions("admin/teacher/winner")
    public String teacherWinner(Model model) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "admin/teacher/winner";
    }

    @RequestMapping({"/admin/teacher/droupOut"})
    @RequiresPermissions("admin/teacher/droupOut")
    public String teacherDroupOut(Model model) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "admin/teacher/droupOut";
    }

}
