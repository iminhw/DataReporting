package com.cap.datareporting.service;

import com.cap.datareporting.entity.SysUser;
import com.cap.datareporting.entity.UReq;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * @program: DataReporting
 * @description:
 * @author: MinHw
 * @create: 2022-03-30 23:48
 **/
public interface UserReqService {

    /**
     * 根据用户ID查询是否存在未审核的申请 存在true （并且数据未被删除,
     *
     * @param uid
     * @return
     */
    Boolean findReqStatusByUid(Long uid, String req_status);

    int insertSelective(UReq  uReq);

    /**
     *  按照用户id查询所有申请
     * @param uid
     * @return
     */
    List<UReq> selectByExample(Long uid);

    UReq findByid(Long id, Long uid);

    List<UReq> selectReQAndUser(SysUser user, UReq uReq);
}
