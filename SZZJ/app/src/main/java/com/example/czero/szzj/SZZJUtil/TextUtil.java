package com.example.czero.szzj.SZZJUtil;

import java.util.Collection;
import java.util.Map;


/**
 * 数据检查和数据转换的辅助类
 */
public class TextUtil {

    public static boolean isValidate(String content) {
        return content != null && !"".equals(content.trim());
    }

    public static boolean isValidate(Collection<?> list) {
        return list != null && list.size() > 0;
    }

    public static boolean isValidate(Map<?, ?> map) {
        return map != null && map.size() > 0;

    }

    /**
     * 判断一个字符串是不是数字
     */
    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    /**
     * 获取列表的总页数
     *
     * @param count        List集合的size
     * @param countPerPage 每一页的数目
     * @return 页数
     */
    public static int getTotalPage(int count, int countPerPage) {
        int pageNum = count / countPerPage;
        int module = count % countPerPage;
        if (module > 0)
            pageNum += 1;

        return pageNum;
    }
}
