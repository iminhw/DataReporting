package com.cap.datareporting.service;

import com.cap.datareporting.entity.SysActionLog;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: DataReporting
 * @description:
 * @author: MinHw
 * @create: 2022-03-25 14:39
 **/
public interface SysActionLogService {

    /**
     * 获取分页列表数据
     * @param example 查询实例
     * @return 返回分页数据
     */
    Page<SysActionLog> getPageList(Example<SysActionLog> example);

    /**
     * 根据日志ID查询日志数据
     * @param id 日志ID
     * @return 日志数据
     */
    SysActionLog getById(Long id);

    /**
     * 获取数据的日志列表
     * @param model 模型（表名）
     * @param recordId 数据ID
     * @return 日志列表
     */
    List<SysActionLog> getDataLogList(String model, Long recordId);

    /**
     * 保存日志
     * @param sysActionLog 日志实体类
     * @return 日志信息
     */
    SysActionLog save(SysActionLog sysActionLog);

    /**
     * 删除指指定ID日志
     * @param id 日志ID
     */
    void deleteId(Long id);

    /**
     * 清空日志
     */
    @Transactional
    void emptyLog();
}
