package com.cap.datareporting.controller;

import cn.hutool.core.map.MapUtil;
import com.cap.datareporting.common.utils.ResultVo;
import com.cap.datareporting.common.utils.ResultVoUtil;
import com.cap.datareporting.common.utils.ToolUtil;
import com.cap.datareporting.component.fileUpload.FileUpload;
import com.cap.datareporting.component.fileUpload.util.WaterMarkUtil;
import com.cap.datareporting.component.thymeleaf.utility.ParamUtil;
import com.cap.datareporting.entity.SysUser;
import com.cap.datareporting.entity.Upload;
import com.cap.datareporting.service.UploadService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: DataReporting
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-28 00:41
 **/
@Controller
@RequestMapping("/admin")
public class UploadController {

    @Autowired
    private UploadService uploadService;


    /**
     * 上传文件
     */
    @PostMapping("/upload")
    @ResponseBody
    public Object uploadFile(@RequestParam("file") MultipartFile multipartFile, @RequestParam("reqType") String reqType) {
        // 创建Upload实体对象
        try {
            if ("nk".equals(reqType)) {
                Upload upload = FileUpload.getFile(multipartFile, "/" + reqType);
                upload.setName(multipartFile.getOriginalFilename());
                saveFile(multipartFile, upload);
//                --
                Map map = new HashMap();
                map.put("code", "000");
                map.put("url", ToolUtil.getUrl(upload));
                return map;
//            } else if ("sendmail".equals(reqType)){
//                Upload upload = FileUpload.getFile(multipartFile, "/"+reqType);
//                upload.setName(multipartFile.getOriginalFilename());
//                saveFile(multipartFile, upload);
//                MailAttachmentVo vo = new MailAttachmentVo();
//                vo.setName(multipartFile.getOriginalFilename());
//                vo.setSize(upload.getSize());
//                vo.setUrl(upload.getPath());
//                return  ResultVoUtil.success(vo);
            } else {
                Upload upload = FileUpload.getFile(multipartFile, "/" + reqType);
                upload.setName(multipartFile.getOriginalFilename());
                ResultVo resultVo = saveFile(multipartFile, upload);
                return resultVo;
            }
        } catch (IOException | NoSuchAlgorithmException e) {
            return ResultVoUtil.error("上传图片失败");
        }
    }

    /**
     * 上传文件 https://blog.csdn.net/jrn1012/article/details/60963714
     */
    @PostMapping("/upload/user")
    @ResponseBody
    public Object uploadFileUser(@RequestParam("file") MultipartFile multipartFile) {
        // 创建Upload实体对象
        try {
            SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
            Upload upload = FileUpload.getFile(multipartFile, "/" + user.getUsername());
            upload.setName(multipartFile.getOriginalFilename());
            ResultVo resultVo = saveFile(multipartFile, upload);
            return resultVo;

        } catch (IOException | NoSuchAlgorithmException e) {
            return ResultVoUtil.error("上传图片失败");
        }
    }

    /**
     * 上传文件
     */
    @PostMapping("/uploadFile")
    @ResponseBody
    public Object uploadFiles(@RequestParam("file") MultipartFile multipartFile, @RequestParam("path") String path) {
        if (path == null || path.equals("")) {
            path = FileUpload.getUploadPath();
        }
        // 创建Upload实体对象
        Upload upload = FileUpload.getFile(multipartFile, "", path);
        try {
            ResultVo resultVo = saveFile(multipartFile, upload);
            return resultVo;
        } catch (IOException | NoSuchAlgorithmException e) {
            return ResultVoUtil.error("上传图片失败");
        }
    }

    /**
     * 上传web格式图片  加水印
     */
    @PostMapping("/upload/image")
    @ResponseBody
    public ResultVo uploadImage(@RequestParam("image") MultipartFile multipartFile) {

        // 创建Upload实体对象
        Upload upload = FileUpload.getFile(multipartFile, "/images");
        upload.setName(multipartFile.getOriginalFilename());
        try {
            return saveImage(multipartFile, upload, true);
        } catch (IOException | NoSuchAlgorithmException e) {
            return ResultVoUtil.error("上传图片失败");
        }
    }

    /**
     * 上传web格式头像
     */
    @PostMapping("/upload/picture")
    @ResponseBody
    public ResultVo uploadPicture(@RequestParam("picture") MultipartFile multipartFile) {

        // 创建Upload实体对象
        Upload upload = FileUpload.getFile(multipartFile, "/picture");
        try {
            return saveImage(multipartFile, upload, false);
        } catch (IOException | NoSuchAlgorithmException e) {
            return ResultVoUtil.error("上传头像失败");
        }
    }

//    /**
//     * 上传jar包
//     */
//    @PostMapping("/upload/jar")
//    @ResponseBody
//    public ResultVo uploadJar(@RequestParam("jar") MultipartFile multipartFile) {
//
//        // 创建Upload实体对象
//        Upload upload = FileUpload.getFile(multipartFile, "", "true");
//        try {
//            FileUpload.transferToJar(multipartFile, upload);
//            return ResultVoUtil.success(upload);
//        } catch (IOException | NoSuchAlgorithmException e) {
//            return ResultVoUtil.error(e.getMessage());
//        }
//    }

    /**
     * 保存上传的web格式图片
     *
     * @param multipartFile
     * @param upload
     * @param WaterMark     水印 开关
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    private ResultVo saveImage(MultipartFile multipartFile, Upload upload, boolean WaterMark) throws IOException, NoSuchAlgorithmException {
        // 判断是否为支持的图片格式
        String[] types = {
                "image/gif",
                "image/jpg",
                "image/jpeg",
                "image/png"
        };
        if (!FileUpload.isContentType(multipartFile, types)) {
            return ResultVoUtil.error("上传图片失败");
        }
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        // 判断图片是否存在
        Upload uploadSha1 = uploadService.getBySha1(FileUpload.getFileSha1(multipartFile), user.getId());
        if (uploadSha1 != null) {
            return ResultVoUtil.success(uploadSha1);
        }

        upload.setCreateBy(user.getId());
//        水印
        if (WaterMark) {
            WaterMarkUtil.markImageMultipartFile(
                    ParamUtil.value("water_mark_text"), multipartFile, upload, null);
        } else {
            FileUpload.transferTo(multipartFile, upload);
        }
        // 将文件信息保存到数据库中
        uploadService.save(upload);
        return ResultVoUtil.success(upload);
    }

    /**
     * 保存上传所有文件
     *
     * @param multipartFile
     * @param upload
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    private ResultVo saveFile(MultipartFile multipartFile, Upload upload) throws IOException, NoSuchAlgorithmException {
        String path = upload.getPath().replace("\\", "/");
        upload.setPath(path);
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        upload.setCreateBy(user.getId());
        upload.setCreateDate(new Date());
        // 判断图片是否存在
        Upload uploadSha1 = uploadService.getBySha1(FileUpload.getFileSha1(multipartFile), user.getId());
        if (uploadSha1 != null) {
            return ResultVoUtil.success(uploadSha1);
        }
        FileUpload.transferTo(multipartFile, upload);

        // 将文件信息保存到数据库中
        uploadService.save(upload);
        return ResultVoUtil.success(upload);
    }

    /**
     * 编辑器使用
     *
     * @param multipartFile
     * @return
     */
    @RequestMapping(value = "/upload/editorMD", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadEditorMD(@RequestParam(value = "editormd-image-file") MultipartFile multipartFile) {
        try {
            // 创建Upload实体对象
            Upload upload = FileUpload.getFile(multipartFile, "/images");
            saveImage(multipartFile, upload, false);
            String visitUrl = upload.getPath();
            return MapUtil.of(new Object[][]{
                    {"success", 1}, {"message", "上传成功！"}, {"url", visitUrl}
            });
        } catch (IOException | NoSuchAlgorithmException e) {
            return MapUtil.of("success", 0);
        }
    }

    @ResponseBody
    @RequestMapping("/usetable")
    public ResultVo updataUSEtabel(String tablename,
                                    String path, String useid) {
        uploadService.updateByPath(path, tablename, Long.valueOf(useid));

        return ResultVoUtil.SAVE_SUCCESS;
    }
}
