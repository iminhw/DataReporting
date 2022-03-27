package com.cap.datareporting.dao;

import com.cap.datareporting.entity.Upload;
import com.cap.datareporting.entity.UploadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UploadMapper {
    long countByExample(UploadExample example);

    int deleteByExample(UploadExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Upload record);

    int insertSelective(Upload record);

    List<Upload> selectByExample(UploadExample example);

    Upload selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Upload record, @Param("example") UploadExample example);

    int updateByExample(@Param("record") Upload record, @Param("example") UploadExample example);

    int updateByPrimaryKeySelective(Upload record);

    int updateByPrimaryKey(Upload record);
}