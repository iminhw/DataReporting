package com.cap.datareporting.component.thymeleaf.utility;

import com.cap.datareporting.common.utils.EhCacheUtil;
import com.cap.datareporting.common.utils.SpringContextUtil;
import com.cap.datareporting.entity.SysParam;
import com.cap.datareporting.service.SysParamService;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: DataReporting
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-27 08:32
 **/
public class ParamUtil {

    private static Cache paramCache = EhCacheUtil.getParamCache();

    /**
     * 获取系统参数值
     *
     * @param name 系统参数名称
     */
    @SuppressWarnings("unchecked")
    public static String value(String name) {
        String value = null;
        Element dictEle = paramCache.get(name);
        if (dictEle != null) {
            value = dictEle.getObjectValue().toString();
        } else {
            SysParamService sysParamService = SpringContextUtil.getBean(SysParamService.class);
            SysParam sysParam = sysParamService.getByName(name);
            if (sysParam != null) {
                paramCache.put(new Element(sysParam.getName(), sysParam.getValue()));
                value = sysParam.getValue();
            }
//            Optional.ofNullable(param).ifPresent(param1 -> {
//                paramCache.put(new Element(param1.getName(), param1.getValue()));
//                value = param.getValue();
//
//            });

        }
        return value;
    }

    /**
     * 清除缓存中指定的数据
     *
     * @param label 字典标识
     */
    public static void clearCache(String label) {
        Element dictEle = paramCache.get(label);
        if (dictEle != null) {
            paramCache.remove(label);
        }
    }


    public static String timeDifference(Date endDate, Date startDate) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            long l = endDate.getTime() - startDate.getTime();
            long day = l / (24 * 60 * 60 * 1000);
            long hour = (l / (60 * 60 * 1000) - day * 24);
            long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            return min + "〃" + s;
        } catch (Exception e) {
            return "-";
        }


    }
}
