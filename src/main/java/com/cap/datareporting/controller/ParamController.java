package com.cap.datareporting.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: DataReporting
 * @description:
 * @author: MinHw or mz
 * @create: 2022-04-03 03:19
 **/
@Controller
@RequestMapping("/admin/param")
public class ParamController {

    @GetMapping("")
    @RequiresPermissions("admin/param/index")
    public String index(Model model) {
//        model.addAttribute("page", list);
        return "admin/param/index";
    }
}
