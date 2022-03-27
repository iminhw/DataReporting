package com.cap.datareporting.controller;

import com.cap.datareporting.common.utils.ResultVo;
import com.cap.datareporting.common.utils.ResultVoUtil;
import com.cap.datareporting.component.fileUpload.FileUpload;
import com.cap.datareporting.component.fileUpload.util.WaterMarkUtil;
import com.cap.datareporting.component.thymeleaf.utility.ParamUtil;
import com.cap.datareporting.entity.SysUser;
import com.cap.datareporting.entity.Upload;
import com.cap.datareporting.service.UploadService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

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
    public String examineeIndex() {
        return "admin/examinee/index";
    }

    @RequestMapping({"/examinee/droupOut"})
    @RequiresPermissions("admin/examinee/droupOut")
    public String examineeDroupOut() {
        return "admin/examinee/droupOut";
    }

    @RequestMapping({"/examinee/winner"})
    @RequiresPermissions("admin/examinee/winner")
    public String examineeWinner() {
        return "admin/examinee/winner";
    }


    @PostMapping("/droupOut")
    @ResponseBody
    public ResultVo saveDroupOut(@RequestParam(value = "files") MultipartFile[] files) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        String userPath = "/" + user.getNickname() + "_" + user.getUsername();
        System.out.println(files.length);
        for (MultipartFile file : files) {
            // 创建Upload实体对象
            Upload upload = FileUpload.getFile(file, userPath, "");
            try {
                saveImage(file, upload, user);
            } catch (IOException | NoSuchAlgorithmException e) {
                return ResultVoUtil.error("上传图片失败");
            }
        }
        return ResultVoUtil.SAVE_SUCCESS;
    }

    private static Object uploadFiles() {

        return null;
    }

    /**
     * 保存上传的web格式图片
     */
    private ResultVo saveImage(MultipartFile multipartFile,
                               Upload upload, SysUser sysUser
                               ) throws IOException, NoSuchAlgorithmException {
        // 判断是否为支持的图片格式
        String[] types = {
                "image/gif",
                "image/jpg",
                "image/jpeg",
                "image/png"
        };
        if (!FileUpload.isContentType(multipartFile, types)) {
            return ResultVoUtil.error("图片格式错误");
        }
        // 判断图片是否存在
        Upload uploadSha1 = uploadService.getBySha1(FileUpload.getFileSha1(multipartFile));
        if (uploadSha1 != null) {
            return ResultVoUtil.success(uploadSha1);
        }
       boolean WaterMark = ParamUtil.value("water_mark_off") == "1";
        if (WaterMark) {
            WaterMarkUtil.markImageMultipartFile(
                    ParamUtil.value("water_mark_text"), multipartFile, upload, null);
        } else {
            FileUpload.transferTo(multipartFile, upload);
        }
        upload.setCreateBy(sysUser.getId());
        upload.setCreateDate(new Date());
        // 将文件信息保存到数据库中
        uploadService.save(upload);
        return ResultVoUtil.success(upload);
    }

    /**
     * 保存上传所有文件
     */
    private ResultVo saveFile(MultipartFile multipartFile, Upload upload, SysUser sysUser) throws IOException, NoSuchAlgorithmException {
        String path = upload.getPath().replace("\\", "/");
        upload.setPath(path);
        // 判断是否存在
//        Upload uploadSha1 = uploadService.getBySha1(FileUpload.getFileSha1(multipartFile),path);
//          if (uploadSha1 != null) {
//               return ResultVoUtil.success(uploadSha1);
//           }
        FileUpload.transferTo(multipartFile, upload);

        // 将文件信息保存到数据库中
        uploadService.save(upload);
        return ResultVoUtil.success(upload);
    }
}
