package com.cap.datareporting.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static org.springframework.util.FileCopyUtils.BUFFER_SIZE;

/**
 * @program: DataReporting
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-29 22:02
 **/
public class FilesUtils {
    /**
     * 把文件集合打成zip压缩包
     *
     * @param srcFiles 压缩文件集合
     * @param zipFile  zip文件名
     * @throws RuntimeException 异常
     */
    public static void toZip(List<File> srcFiles, File zipFile) throws IOException {
        if (zipFile == null) {
            return;
        }
        if (!zipFile.getName().endsWith(".zip")) {
            return;
        }
        ZipOutputStream zos = null;
        FileOutputStream out = new FileOutputStream(zipFile);
        try {
            zos = new ZipOutputStream(out);
            for (File srcFile : srcFiles) {
                byte[] buf = new byte[BUFFER_SIZE];
                zos.putNextEntry(new ZipEntry(srcFile.getName()));
                int len;
                // 读取文件并写入到zip中
                FileInputStream in = new FileInputStream(srcFile);
                while ((len = in.read(buf)) != -1) {
                    zos.write(buf, 0, len);
                    zos.flush();
                }
                in.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (zos != null) {
                zos.close();
            }
        }
//        e
    }


}
