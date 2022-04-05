package com.cap.datareporting.service.impl;

import com.cap.datareporting.common.enums.StatusConst;
import com.cap.datareporting.component.thymeleaf.utility.ParamUtil;
import com.cap.datareporting.dao.UReqMapper;
import com.cap.datareporting.entity.SysUser;
import com.cap.datareporting.entity.UReq;
import com.cap.datareporting.entity.UReqExample;
import com.cap.datareporting.service.UserReqService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: DataReporting
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-30 23:49
 **/
@Service
public class UserReqServiceImp implements UserReqService {
    @Resource
    private UReqMapper uReqMapper;

    @Override
    public Boolean findReqStatusByUid(Long uid, String req_status) {
        UReq uReq = uReqMapper.findReqStatusByUid(uid,
                req_status, StatusConst.OK);
        return uReq != null ? true : false;
    }

    @Override
    public int insertSelective(UReq uReq) {
        return uReqMapper.insertSelective(uReq);
    }

    @Override
    public List<UReq> selectByExample(Long uid) {
        UReqExample example = new UReqExample();
        UReqExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(StatusConst.OK);
        criteria.andUidEqualTo(uid);
        return uReqMapper.selectByExample(example);
    }

    @Override
    public UReq findByid(Long id, Long uid) {
        return uReqMapper.selectByIdAndUid(id,uid, StatusConst.OK);
    }

    @Override
    public List<UReq> selectReQAndUser(SysUser user, UReq uReq) {
        uReq.setStatus(StatusConst.OK);
        return uReqMapper.selectReQAndUser(user, uReq);
    }
}
