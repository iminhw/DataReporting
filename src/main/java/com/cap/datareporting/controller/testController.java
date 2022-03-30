package com.cap.datareporting.controller;

import com.cap.datareporting.common.utils.FilesUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @program: DataReporting
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-29 22:09
 **/
@Controller
@RequestMapping("/test")
public class testController {

// https://blog.csdn.net/weixin_43790879/article/details/103155429

    /**
     * 将文件打包成zip并存放在特定位置
     */
    @PostMapping("/package")
    public void packageFileToZip() throws IOException {
        // 为了方便我直接将文件地址写好了，各位可以根据自己的情况修改
        String[] filePath = new String[]{"/Users/mz/Downloads/qtp/qtp/sn.txt", "/Users/mz/Downloads/qtp/12/41/31/part-00316-3504.jpg",
                "/Users/mz/Downloads/qtp/12/31/Unknown.jpeg"};
        // 将需要打包的文件都放在一个集合中
        List<File> fileList = new ArrayList<>();
        for (String s : filePath) {
            File file = new File(s);
            fileList.add(file);
        }
        // 先在D盘创建一个压缩包
        File zipFile = new File("/Users/mz/Downloads/qtp/12/package.zip");
        if (!zipFile.exists())
            zipFile.createNewFile();
        // 将package.zip的File对象传到toZip对象中
        FilesUtils.toZip(fileList, zipFile);
    }


    public static void main(String[] args) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//创建日期转换对象：年月日 时分秒
//        String date = "2022/11/11 11:11:11"; //假设 设定日期是 2018-11-11 11:11:11
//        Date today = new Date();         //今天
//        try {
//            Date dateD = sdf.parse(date);    //转换为 date 类型 Debug：Sun Nov 11 11:11:11 CST 2018
//            boolean flag = dateD.getTime() >= today.getTime();
//            System.err.println("flag = " + flag);  // flag = false
//        } catch (ParseException e1) {
//            e1.printStackTrace();
//        }
        System.out.println(UUID.randomUUID().toString().replace("-", ""));

    }


}
