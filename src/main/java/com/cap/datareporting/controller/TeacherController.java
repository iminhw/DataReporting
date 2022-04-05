package com.cap.datareporting.controller;

import com.cap.datareporting.common.utils.PageBeen;
import com.cap.datareporting.entity.SysUser;
import com.cap.datareporting.entity.UReq;
import com.cap.datareporting.service.UserReqService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String teacherWinner(Model model) {
        SysUser loginUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", loginUser);
        return "admin/teacher/winner";
    }

    @RequestMapping(value = {"/teacher/winner"}, method = RequestMethod.POST)
    @RequiresPermissions("admin/teacher/winner")
    @ResponseBody
    public PageBeen teacherWinner(Model model, UReq uReq, SysUser user, PageBeen pageBeen) {
        uReq.setType(Byte.valueOf("2"));
        List<UReq> uReqList = userReqService.selectReQAndUser(user, uReq, pageBeen);
        pageBeen.setList(uReqList);
        pageBeen.setTotalRecords(userReqService.selectReQAndCount(user, uReq));
        return pageBeen;
    }

    @RequestMapping({"/teacher/droupOut"})
    @RequiresPermissions("admin/teacher/droupOut")
    public String teacherDroupOut(Model model) {
        SysUser loginUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", loginUser);
        return "admin/teacher/droupOut";
    }

    @RequestMapping(value = {"/teacher/droupOut"}, method = RequestMethod.POST)
    @RequiresPermissions("admin/teacher/droupOut")
    @ResponseBody
    public PageBeen teacherDroupOut(Model model, UReq uReq, SysUser user, PageBeen pageBeen) {
        uReq.setType(Byte.valueOf("1"));
        List<UReq> uReqList = userReqService.selectReQAndUser(user, uReq, pageBeen);
//        pageBeen.setPageSize(10);
//        pageBeen.setPageNo(1);
        //        无效
//        pageBeen.setCount((pageBeen.getPageNo() - 1) * pageBeen.getPageSize());
        pageBeen.setList(uReqList);
        pageBeen.setTotalRecords(userReqService.selectReQAndCount(user, uReq));
//        reqResultVo.setData((UReq) uReqList);

        return pageBeen;
    }
}
