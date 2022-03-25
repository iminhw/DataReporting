package com.cap.datareporting.dao;

import com.cap.datareporting.entity.SysDict;
import com.cap.datareporting.entity.SysDictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysDictMapper {
    long countByExample(SysDictExample example);

    int deleteByExample(SysDictExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysDict record);

    int insertSelective(SysDict record);

    List<SysDict> selectByExampleWithBLOBs(SysDictExample example);

    List<SysDict> selectByExample(SysDictExample example);

    SysDict selectByPrimaryKey(Long id);

    @Select("SELECT * FROM sys_dict WHERE name = #{name} AND status = #{status}")
    SysDict getByNameOk(String name, byte status);

    int updateByExampleSelective(@Param("record") SysDict record, @Param("example") SysDictExample example);

    int updateByExampleWithBLOBs(@Param("record") SysDict record, @Param("example") SysDictExample example);

    int updateByExample(@Param("record") SysDict record, @Param("example") SysDictExample example);

    int updateByPrimaryKeySelective(SysDict record);

    int updateByPrimaryKeyWithBLOBs(SysDict record);

    int updateByPrimaryKey(SysDict record);
}