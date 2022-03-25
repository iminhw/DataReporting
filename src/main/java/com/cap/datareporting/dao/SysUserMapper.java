package com.cap.datareporting.dao;

import com.cap.datareporting.entity.SysUser;
import com.cap.datareporting.entity.SysUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysUserMapper {
    long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Long id);

    /**
     * 按用户名查询数据,考虑不让用户名重复，所以不管软状态
     * @param username
     * @return
     */
    @Select("SELECT * FROM sys_user WHERE username = #{username} ORDER BY id")
    SysUser selectByPrimaryUname(String username);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}