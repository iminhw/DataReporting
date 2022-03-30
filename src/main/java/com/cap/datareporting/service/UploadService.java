package com.cap.datareporting.service;

import com.cap.datareporting.entity.Upload;

/**
 * @program: DataReporting
 * @description:
 * @author: MinHw
 * @create: 2022-03-27 23:27
 **/
public interface UploadService {

    /**
     * 获取文件sha1值的记录
     * @param sha1 文件sha1值
     * @return 文件信息
     */
    Upload getBySha1(String sha1, Long cid);

    /**
     * 保存文件上传
     * @param upload 文件上传实体类
     * @return 文件信息
     */
    int save(Upload upload);

    /**
     * 更新，按urlPath进行更新 tabelname and useid
     * @param urlPath
     * @return
     */
    int updateByPath(String urlPath, String tableName, Long useId);
}
