package com.cap.datareporting.service.impl;

import com.cap.datareporting.dao.SysActionLogMapper;
import com.cap.datareporting.entity.SysActionLog;
import com.cap.datareporting.service.SysActionLogService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: DataReporting
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-25 14:42
 **/
public class SysActionLogServiceImp implements SysActionLogService {

    @Resource
    private SysActionLogMapper sysActionLogMapper;

    @Override
    public Page<SysActionLog> getPageList(Example<SysActionLog> example) {
        return null;
    }

    @Override
    public SysActionLog getById(Long id) {
        return null;
    }

    @Override
    public List<SysActionLog> getDataLogList(String model, Long recordId) {
        return null;
    }

    @Override
    public SysActionLog save(SysActionLog sysActionLog) {
        return null;
    }

    @Override
    public void deleteId(Long id) {

    }

    @Override
    public void emptyLog() {

    }
}
