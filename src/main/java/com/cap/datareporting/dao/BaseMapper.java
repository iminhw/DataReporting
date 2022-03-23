package com.cap.datareporting.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: blog01
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-14 19:16
 **/
@Mapper
public interface BaseMapper {

    /**
     * index top 10
     * @return
     */
//    @Select("SELECT * FROM article WHERE is_top > 0  ORDER BY is_top DESC LIMIT 0,10")
//    List<Article> findTop10();
}
