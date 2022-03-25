package com.cap.datareporting.dao;

import com.cap.datareporting.entity.SysActionLog;
import com.cap.datareporting.entity.SysActionLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysActionLogMapper {
    long countByExample(SysActionLogExample example);

    int deleteByExample(SysActionLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysActionLog record);

    int insertSelective(SysActionLog record);

    List<SysActionLog> selectByExampleWithBLOBs(SysActionLogExample example);

    List<SysActionLog> selectByExample(SysActionLogExample example);

    SysActionLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysActionLog record, @Param("example") SysActionLogExample example);

    int updateByExampleWithBLOBs(@Param("record") SysActionLog record, @Param("example") SysActionLogExample example);

    int updateByExample(@Param("record") SysActionLog record, @Param("example") SysActionLogExample example);

    int updateByPrimaryKeySelective(SysActionLog record);

    int updateByPrimaryKeyWithBLOBs(SysActionLog record);

    int updateByPrimaryKey(SysActionLog record);
}