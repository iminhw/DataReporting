package com.cap.datareporting.service;

import com.cap.datareporting.entity.SysParam;

/**
 * @program: DataReporting
 * @description:
 * @author: MinHw
 * @create: 2022-03-27 08:31
 **/
public interface SysParamService {

    /**
     *
     * @param name
     * @return
     */
    SysParam getByName(String name);
}
