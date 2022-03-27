package com.cap.datareporting.service.impl;

import com.cap.datareporting.dao.UploadMapper;
import com.cap.datareporting.entity.Upload;
import com.cap.datareporting.service.UploadService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: DataReporting
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-27 23:28
 **/
@Service
public class UploadServiceImp implements UploadService {

    @Resource
    private UploadMapper uploadMapper;

    @Override
    public Upload getBySha1(String sha1) {
        return uploadMapper.selectBySha1(sha1);
    }

    @Override
    public int save(Upload upload) {
        return uploadMapper.insert(upload);
    }
}
