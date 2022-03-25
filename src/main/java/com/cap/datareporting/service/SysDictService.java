package com.cap.datareporting.service;

import com.cap.datareporting.common.enums.StatusEnum;
import com.cap.datareporting.entity.SysDict;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: DataReporting
 * @description:
 * @author: MinHw
 * @create: 2022-03-25 14:38
 **/
public interface SysDictService {
    /**
     * 根据字典标识获取字典数据
     *
     * @param name 字典标识
     * @return 字典信息
     */
    SysDict getByNameOk(String name);

    /**
     * 获取分页列表数据
     *
     * @param example 查询实例
     * @return 返回分页数据
     */
    Page<SysDict> getPageList(Example<SysDict> example);

    /**
     * 根据字典ID查询字典数据
     *
     * @param id 字典ID
     * @return 字典信息
     */
    SysDict getById(Long id);

    /**
     * 字典标识是否重复
     *
     * @param sysDict 字典实体类
     * @return 是否重复
     */
    boolean repeatByName(SysDict sysDict);

    /**
     * 保存字典
     *
     * @param dict 字典实体类
     * @return 字典信息
     */
    SysDict save(SysDict dict);

    /**
     * 状态(启用，冻结，删除)/批量状态处理
     *
     * @param statusEnum 数据状态
     * @param idList     数据ID列表
     * @return 操作结果
     */
    @Transactional
    Boolean updateStatus(StatusEnum statusEnum, List<Long> idList);
}
