package com.cap.datareporting.common.utils;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * EhCache缓存操作工具
 *
 * @author minhw
 */
public class EhCacheUtil {

    public static void main(String[] args) {
        Cache cache =  getCacheManager().getCache("dictionary");
        cache.put(new Element("key", "123"));
        Cache cache1 =  getCacheManager().getCache("param");


    }

    /**
     * 获取EhCacheManager管理对象
     */
    public static CacheManager getCacheManager() {
//        return SpringContextUtil.getBean(CacheManager.class);
        return CacheManager.getInstance();
//        return CacheManager.create(EhCacheUtil.class.getResourceAsStream("/ehcache.xml"));
    }


    /**
     * 获取EhCache缓存对象
     */
    public static Cache getCache(String cacheName) {
        Cache cache = getCacheManager().getCache(cacheName);
//        ！！！！！ 感觉原因是无法加载 ehcahe.xml中的配置，原因未知，
        if (cache == null){
            getCacheManager().addCache(cacheName);
            cache = getCacheManager().getCache(cacheName);
        }
        return cache;
//        return getCacheManager().getCache(cacheName);
    }

    /**
     * 清除相关联的缓存
     *
     * @param cacheName 缓存所在namespace的名称
     * @param keys      缓存所在namespace下key的名称，为空则默认清空所有key
     */
    public void clearRelatedCache(String cacheName, String[] keys) {
        Cache cache = getCache(cacheName);
        if (cache == null) {
            return;
        }
        //若缓存不为空
        if (keys == null || keys.length == 0) {
            cache.removeAll();
        } else {
            for (String key : keys) {
                cache.remove(key);
            }
        }
    }


    /**
     * 获取字典缓存对象 = getCache
     */
    public static Cache getDictCache() {
        return getCache("dictionary");
    }

    /**
     * 获取系统参数 = getCache
     */
    public static Cache getParamCache() {
        return getCache("param");
    }



}
