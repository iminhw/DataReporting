package com.cap.datareporting.service.impl;

import com.cap.datareporting.common.enums.StatusConst;
import com.cap.datareporting.dao.SysParamMapper;
import com.cap.datareporting.entity.SysParam;
import com.cap.datareporting.service.SysParamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: DataReporting
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-27 08:29
 **/
@Service
public class SysParamServiceImp implements SysParamService {

    @Resource
    private SysParamMapper sysParamMapper;

    @Override
    public SysParam getByName(String name) {
        return sysParamMapper.selectByName(name, StatusConst.OK);
    }
}
