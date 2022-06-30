import org.junit.Test;

import java.util.*;
import java.util.ArrayList;

/**
 * @Author: laizc
 * @Date: created in 2022-06-30
 * @desc: 模拟 hash 冲突
 */
public class SimulateHashConflict {

    @Test
    public void test() {
        Map<Integer, List<String>> param = new HashMap<>();
        for (int i = 33; i < 100; i++) {
            char ch = (char) i;
            String str = String.valueOf(ch);
            int index = 15 & hash(str);
            List<String> list = param.get(index);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(str);
            param.put(index,list);
        }
        param.forEach((k,v) -> System.out.println(k + " " + Arrays.toString(v.toArray())));
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }



}
