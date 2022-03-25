package com.cap.datareporting.service.impl;

import com.cap.datareporting.common.enums.StatusEnum;
import com.cap.datareporting.dao.SysDictMapper;
import com.cap.datareporting.entity.SysDict;
import com.cap.datareporting.entity.SysDictExample;
import com.cap.datareporting.service.SysDictService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: DataReporting
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-25 14:42
 **/
public class SysDictServiceImp implements SysDictService {

    @Resource
    private SysDictMapper sysDictMapper;

    @Override
    public SysDict getByNameOk(String name) {
        SysDictExample example = new SysDictExample();
        SysDictExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andStatusEqualTo(StatusEnum.OK.getCode());
        List<SysDict> sysDictList = sysDictMapper.selectByExample(example);
        SysDict sysDict = new SysDict();
        if (sysDictList != null) {
            sysDict = sysDictList.get(0);
        }
        return sysDict;
//        return new SysDict();
    }

    @Override
    public Page<SysDict> getPageList(Example<SysDict> example) {
        return null;
    }

    @Override
    @Transactional
    public SysDict getById(Long id) {
        return sysDictMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean repeatByName(SysDict sysDict) {
        return false;
    }

    @Override
    public SysDict save(SysDict dict) {
        return null;
    }

    @Override
    public Boolean updateStatus(StatusEnum statusEnum, List<Long> idList) {
        return null;
    }
}
