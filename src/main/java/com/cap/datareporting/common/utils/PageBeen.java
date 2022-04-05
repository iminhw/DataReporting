package com.cap.datareporting.common.utils;

import lombok.Data;

import java.util.List;

/**
 * @program: DataReporting
 * @description:
 * @author: MinHw or mz
 * @create: 2022-04-05 11:52
 **/
@Data
public class PageBeen<T> {
    //结果集
    private List<T> list;
    //每页多少条数据
    private int pageSize;
    //第几页
    private int pageNo;
    //查询总记录数
    private int totalRecords;
    private int count;

    /**
     * 计算总的页面数
     *
     * @return
     */
    public int getTotalPages() {
        if (totalRecords % pageSize == 0) {
            return totalRecords / pageSize;
        } else {
            return totalRecords / pageSize + 1;
        }
    }

    /**
     * 取得首页
     *
     * @return
     */
    public int getTopPageNo() {
        return 1;
    }

    /**
     * 上一页
     *
     * @return
     */
    public int getPreviousPageNo() {
        if (pageNo <= 1) {
            return 1;
        }
        return pageNo - 1;
    }

    /**
     * 取得尾页
     *
     * @return
     */
    public int getBottomPageNo() {
        return getTotalPages();
    }

    /**
     * 下一页
     *
     * @return
     */
    public int getNextPageNo() {
        if (pageNo >= getBottomPageNo())
            return getBottomPageNo();
        return pageNo + 1;
    }
}
