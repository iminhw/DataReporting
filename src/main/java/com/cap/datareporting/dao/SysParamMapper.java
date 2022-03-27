package com.cap.datareporting.dao;

import com.cap.datareporting.entity.SysParam;
import com.cap.datareporting.entity.SysParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysParamMapper {
    long countByExample(SysParamExample example);

    int deleteByExample(SysParamExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysParam record);

    int insertSelective(SysParam record);

    List<SysParam> selectByExampleWithBLOBs(SysParamExample example);

    List<SysParam> selectByExample(SysParamExample example);

    @Select("SELECT * FROM sys_param WHERE name = #{name} and status = #{status} ORDER BY id")
    SysParam selectByName(String name, Byte status);

    SysParam selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysParam record, @Param("example") SysParamExample example);

    int updateByExampleWithBLOBs(@Param("record") SysParam record, @Param("example") SysParamExample example);

    int updateByExample(@Param("record") SysParam record, @Param("example") SysParamExample example);

    int updateByPrimaryKeySelective(SysParam record);

    int updateByPrimaryKeyWithBLOBs(SysParam record);

    int updateByPrimaryKey(SysParam record);
}