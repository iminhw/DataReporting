package com.cap.datareporting.controller;

import com.alibaba.fastjson.JSONArray;
import com.cap.datareporting.common.enums.ResultEnum;
import com.cap.datareporting.common.utils.ResultVo;
import com.cap.datareporting.common.utils.ResultVoUtil;
import com.cap.datareporting.common.utils.ToolUtil;
import com.cap.datareporting.component.thymeleaf.utility.ParamUtil;
import com.cap.datareporting.entity.SysUser;
import com.cap.datareporting.service.UploadService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: DataReporting
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-28 03:13
 **/
@Controller
@RequestMapping("/admin")
public class ExamineeController {

    @Autowired
    private UploadService uploadService;

    @RequestMapping({"/examinee"})
    @RequiresPermissions("admin/examinee")
    public String examineeIndex(Model model) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "admin/examinee/index";
    }

    @RequestMapping({"/examinee/droupOut"})
    @RequiresPermissions("admin/examinee/droupOut")
    public String examineeDroupOut(Model model) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("disabled", ToolUtil.specifiedTime(ParamUtil.value("droup_out_start"),
                ParamUtil.value("droup_out_end")));
        model.addAttribute("user", user);
        return "admin/examinee/droupOut";
    }

    @RequestMapping({"/examinee/winner"})
    @RequiresPermissions("admin/examinee/winner")
    public String examineeWinner(Model model) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("disabled", ToolUtil.specifiedTime(ParamUtil.value("winner_start"),
                ParamUtil.value("winner_end")));
        model.addAttribute("user", user);
        return "admin/examinee/winner";
    }


    @PostMapping("/droupOut")
    @ResponseBody
    public ResultVo saveDroupOut(@RequestParam("lqzy") String lqzy, @RequestParam("fileArr") String fileArr) {
        if (ToolUtil.specifiedTime(ParamUtil.value("droup_out_start"),
                ParamUtil.value("droup_out_end"))) {
            return ResultVoUtil.success(ResultEnum.STATUS_ERROR.getStatus(), ResultEnum.STATUS_ERROR.getMessage());
        }
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        System.out.println(lqzy);
        Object ob = JSONArray.parse(fileArr);
        System.out.println(ob);
        return ResultVoUtil.SAVE_SUCCESS;
    }

    @PostMapping("/winner")
    @ResponseBody
    public ResultVo saveWinner(@RequestParam("fileArr") String fileArr) {
        if (ToolUtil.specifiedTime(ParamUtil.value("winner_start"),
                ParamUtil.value("winner_end"))) {
            return ResultVoUtil.success(ResultEnum.STATUS_ERROR.getStatus(), ResultEnum.STATUS_ERROR.getMessage());
        }
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();

        return ResultVoUtil.SAVE_SUCCESS;
    }


}
