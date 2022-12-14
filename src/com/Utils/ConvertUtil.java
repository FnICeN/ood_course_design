package com.Utils;

import com.pojo.Speaks;

import java.util.List;

public class ConvertUtil {
    public static Object[][] toObjArray(List<Speaks> list) {
        int len = list.size();
        Object[][] res = new Object[len][];
        for(int i = 0; i < len; i++) {
            res[i] = list.get(i).getFields();
        }
        return res;
    }
}
