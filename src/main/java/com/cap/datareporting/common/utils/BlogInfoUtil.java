package com.cap.datareporting.common.utils;//package com.min.utils;
//
//import com.min.entity.BlogInfo;
//import com.min.service.BlogInfoService;
//import net.sf.ehcache.Cache;
//import net.sf.ehcache.Element;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class BlogInfoUtil {
//
//    private static Cache blogCache = EhCacheUtil.getCache("");
//
//    /**
//     *
//     * @param uid
//     * @return
//     */
//    public static String getBlogUserName(Integer uid){
//       String value = null;
//        Element element = blogCache.get(uid);
//        if(element != null){
//            value = element.getObjectValue().toString();
//        }else {
//            BlogInfoService blogInfoService = SpringContextUtil.getBean(BlogInfoService.class);
//            BlogInfo param = blogInfoService.getByName(name);
//           if (param != null){
//               blogCache.put(new Element(param.getName(), param.getValue()));
//               value = param.getValue();
//           }
//        }
//        return value;
//    }
//
//    /**
//     * 清除缓存中指定的数据
//     * @param label 字典标识
//     */
//    public static void clearCache(String label){
//        Element dictEle = blogCache.get(label);
//        if (dictEle != null){
//            blogCache.remove(label);
//        }
//    }
//
//
//    public static String timeDifference(Date endDate,Date startDate)throws Exception{
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        try {
//            long l=endDate.getTime()-startDate.getTime();
//            long day=l/(24*60*60*1000);
//            long hour=(l/(60*60*1000)-day*24);
//            long min=((l/(60*1000))-day*24*60-hour*60);
//            long s=(l/1000-day*24*60*60-hour*60*60-min*60);
//            return min+"〃"+s;
//        }catch (Exception e){
//            return "-";
//        }
//    }
//}
