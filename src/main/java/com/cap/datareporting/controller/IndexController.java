package com.cap.datareporting.controller;

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

        return "/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/login";
    }

//    @RequestMapping(value = "/login1", method = RequestMethod.GET)

//    @RequiresPermissions("user:del")//权限管理;
//    public String login1() {
//        return "/login1";
//    }

    @RequestMapping({"/register"})
    public String register() {
        return "/register";
    }

    @RequestMapping({"/admin"})
    @RequiresPermissions("admin/index")//权限管理;
    public String admin() {
        return "/admin/index";
    }

    @RequestMapping({"/admin/ks/tuitang"})
    @RequiresPermissions("admin/ks/tuitang")
    public String tuiDang() {
        return "/admin/ks/tuitang";
    }

    @RequestMapping({"/admin/ks/wode"})
    @RequiresPermissions("admin/ks/wode")
    public String ksWodetj() {
        return "/admin/ks/wode";
    }

    @RequestMapping({"/admin/ks/huoj"})
    @RequiresPermissions("admin/ks/huoj")
    public String kshouj() {
        return "/admin/ks/huoj";
    }

    @RequestMapping({"/admin/th/hj"})
    @RequiresPermissions("admin/th/hj")
    public String thhj() {
        return "/admin/th/hj";
    }

    @RequestMapping({"/admin/th/td"})
    @RequiresPermissions("admin/th/td")
    public String thtd() {
        return "/admin/th/td";
    }

}
