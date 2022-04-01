package com.cap.datareporting.dao;

import com.cap.datareporting.entity.UReq;
import com.cap.datareporting.entity.UReqExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UReqMapper {
    long countByExample(UReqExample example);

    int deleteByExample(UReqExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UReq record);

    int insertSelective(UReq record);

    List<UReq> selectByExample(UReqExample example);

    UReq selectByPrimaryKey(Long id);

    @Select("select *,req_status as reqStatus, req_remark as reqRemark, imegs_url_arr AS imegsUrlArr, create_date as createDate,  update_date as updateDate " +
            "  from user_req where uid=#{uid} and id = #{id} and status = #{status}")
    UReq selectByIdAndUid(Long id, Long uid, Byte status);

    @Select("select *,req_status as reqStatus, req_remark as reqRemark, imegs_url_arr AS imegsUrlArr, create_date as createDate,  update_date as updateDate " +
            "  from user_req where uid=#{uid} and req_status = #{req_status} and status = #{status}")
    UReq findReqStatusByUid(Long uid, String req_status, Byte status);

    int updateByExampleSelective(@Param("record") UReq record, @Param("example") UReqExample example);

    int updateByExample(@Param("record") UReq record, @Param("example") UReqExample example);

    int updateByPrimaryKeySelective(UReq record);

    int updateByPrimaryKey(UReq record);
}