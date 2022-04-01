package com.cap.datareporting.controller;


import com.alibaba.fastjson.JSONObject;
import com.cap.datareporting.common.enums.ResultEnum;
import com.cap.datareporting.common.enums.StatusConst;
import com.cap.datareporting.common.utils.ResultVo;
import com.cap.datareporting.common.utils.ResultVoUtil;
import com.cap.datareporting.common.utils.ToolUtil;
import com.cap.datareporting.component.thymeleaf.utility.ParamUtil;
import com.cap.datareporting.entity.SysUser;
import com.cap.datareporting.entity.UReq;
import com.cap.datareporting.service.UploadService;
import com.cap.datareporting.service.UserReqService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    private UserReqService userReqService;

    @RequestMapping({"/examinee"})
    @RequiresPermissions("admin/examinee")
    public String examineeIndex(Model model) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        List<UReq> uReqList = userReqService.selectByExample(user.getId());
        model.addAttribute("reqlist", uReqList);
        return "admin/examinee/index";
    }

    @RequestMapping("/examinee/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        System.out.println(userReqService.findByid(id, user.getId()).toString());
        model.addAttribute("reqdet", userReqService.findByid(id, user.getId()));
        return "admin/examinee/details";
    }

    @RequestMapping({"/examinee/droupOut"})
    @RequiresPermissions("admin/examinee/droupOut")
    public String examineeDroupOut(Model model) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("disabled", ToolUtil.specifiedTime(ParamUtil.value("droup_out_start"),
                ParamUtil.value("droup_out_end")));
        model.addAttribute("user", user);
        if (userReqService.findReqStatusByUid(user.getId(),ParamUtil.value("req_status_false"))){
            model.addAttribute("disabled", true);
            model.addAttribute("error", "存在待审核的申请");
        }
        return "admin/examinee/droupOut";
    }

    @RequestMapping({"/examinee/winner"})
    @RequiresPermissions("admin/examinee/winner")
    public String examineeWinner(Model model) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("disabled", ToolUtil.specifiedTime(ParamUtil.value("winner_start"),
                ParamUtil.value("winner_end")));
        model.addAttribute("user", user);
        if (userReqService.findReqStatusByUid(user.getId(),ParamUtil.value("req_status_false"))){
            model.addAttribute("disabled", true);
            model.addAttribute("error", "存在待审核的申请");
        }
        return "admin/examinee/winner";
    }


    @PostMapping("/examinee/droupout")
    @ResponseBody
    public ResultVo saveDroupOut(UReq uReq) {
        if (ToolUtil.specifiedTime(ParamUtil.value("droup_out_start"),
                ParamUtil.value("droup_out_end"))) {
            return ResultVoUtil.success(ResultEnum.STATUS_ERROR.getStatus(), ResultEnum.STATUS_ERROR.getMessage());
        }
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        String req_status = ParamUtil.value("req_status_false");
        if (userReqService.findReqStatusByUid(user.getId(), req_status)){
            return ResultVoUtil.SAVE_ERROR;
        }
//        System.out.println(lqzy);
//        Object ob = JSONArray.parse(fileArr);
//        UReq uReq = new UReq();
        uReq.setType(Byte.valueOf("1"));
        uReq.setUid(user.getId());
        uReq.setReqStatus(Byte.valueOf(req_status));
        Date date = new Date();
        uReq.setCreateDate(date);
        uReq.setUpdateDate(date);
        uReq.setStatus(StatusConst.OK);

        userReqService.insertSelective(uReq);
        return ResultVoUtil.SAVE_SUCCESS;
    }

    @PostMapping("/examinee/winner")
    @ResponseBody
    public ResultVo saveWinner(UReq uReq) {
        if (ToolUtil.specifiedTime(ParamUtil.value("winner_start"),
                ParamUtil.value("winner_end"))) {
            return ResultVoUtil.success(ResultEnum.STATUS_ERROR.getStatus(), ResultEnum.STATUS_ERROR.getMessage());
        }
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        String req_status = ParamUtil.value("req_status_false");
        if (userReqService.findReqStatusByUid(user.getId(),req_status)){
            return ResultVoUtil.SAVE_ERROR;
        }
        uReq.setType(Byte.valueOf("2"));
        uReq.setUid(user.getId());
        uReq.setReqStatus(Byte.valueOf(req_status));

        Date date = new Date();
        uReq.setCreateDate(date);
        uReq.setUpdateDate(date);
        uReq.setStatus(StatusConst.OK);
        userReqService.insertSelective(uReq);
        return ResultVoUtil.SAVE_SUCCESS;
    }


}
