package com.cap.datareporting.controller;

import com.cap.datareporting.entity.SysUser;
import com.cap.datareporting.entity.UReq;
import com.cap.datareporting.service.UserReqService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program: DataReporting
 * @description:
 * @author: MinHw or mz
 * @create: 2022-04-01 14:58
 **/
@Controller
@RequestMapping("/admin")
public class TeacherController {

    @Autowired
    private UserReqService userReqService;


    @RequestMapping({"/teacher/winner"})
    @RequiresPermissions("admin/teacher/winner")
    public String teacherWinner(Model model, UReq uReq, SysUser user) {
        SysUser loginUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", loginUser);
        uReq.setType(Byte.valueOf("2"));
        List<UReq> uReqList = userReqService.selectReQAndUser(user, uReq);
//        System.out.println(uReqList.size());
        model.addAttribute("list", uReqList);
//        for (UReq u: uReqList) {
//            System.out.println(u.getId());
//            System.out.println(u.getSysUser().getUsername());
//        }
        return "admin/teacher/winner";
    }

    @RequestMapping({"/teacher/droupOut"})
    @RequiresPermissions("admin/teacher/droupOut")
    public String teacherDroupOut(Model model, UReq uReq, SysUser user) {
        SysUser loginUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", loginUser);
        uReq.setType(Byte.valueOf("1"));
        List<UReq> uReqList = userReqService.selectReQAndUser(user, uReq);
//        System.out.println(uReqList.size());
        model.addAttribute("list", uReqList);
//        for (UReq u: uReqList) {
//            System.out.println(u.getId());
//            System.out.println(u.getSysUser().getUsername());
//        }
        return "admin/teacher/droupOut";
    }

}
