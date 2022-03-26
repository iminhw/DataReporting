package com.cap.datareporting.service.impl;

import com.cap.datareporting.common.enums.StatusConst;
import com.cap.datareporting.common.enums.StatusEnum;
import com.cap.datareporting.common.utils.SpringContextUtil;
import com.cap.datareporting.dao.SysDictMapper;
import com.cap.datareporting.entity.SysDict;
import com.cap.datareporting.service.SysDictService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: DataReporting
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-25 14:42
 **/
@Service
public class SysDictServiceImp implements SysDictService {

    @Resource
    private SysDictMapper sysDictMapper;

    @Override
//    @Cacheable(value="dictionary",key="0")
    public SysDict getByNameOk(String name) {
//        SysDictExample example = new SysDictExample();
//        SysDictExample.Criteria criteria = example.createCriteria();
//        criteria.andNameEqualTo(name);
//        criteria.andStatusEqualTo(StatusEnum.OK.getCode());
//        List<SysDict> sysDictList = sysDictMapper.selectByExample(example);
////        SysDict sysDict = new SysDict();
//        if (sysDictList != null) {
//            return  sysDictList.get(0);
//        }
        //        return new SysDict();
        return sysDictMapper.getByNameOk(name, StatusConst.OK);
    }

    @Override
    @Cacheable(key = "#label", value = "getString")
    public Map<String, String> gitDictValue(String label) {
        System.err.println("没走缓存");
        Map<String, String> value = null;
        SysDictService dictService = SpringContextUtil.getBean(SysDictService.class);
        SysDict dict = dictService.getByNameOk(label);
        if (dict != null) {
            String dictValue = dict.getValue();
            String[] outerSplit = dictValue.split(",");
            value = new LinkedHashMap<>();
            for (String osp : outerSplit) {
                String[] split = osp.split(":");
                if (split.length > 1) {
                    value.put(split[0], split[1]);
                }
            }
        }
        return value;
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
