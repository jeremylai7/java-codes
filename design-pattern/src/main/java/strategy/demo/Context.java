package strategy.demo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: laizc
 * @date: created in 2023/6/21
 * @desc:
 */
// 策略工具类
public class Context {

    /*public static Strategy operation(int type) {
        if (type == 1) {
            return new SixDiscountStrategy();
        } else if (type == 2) {
            return new EightDiscountStrategy();
        } else if (type == 3) {
            return new FirstDiscountStrategy();
        }
        throw new IllegalArgumentException("not fond strategy");
    }*/


    private static Map<Integer,Strategy> map = new HashMap<>();

    static {
        map.put(1,new SixDiscountStrategy());
        map.put(2,new EightDiscountStrategy());
        map.put(3,new FirstDiscountStrategy());
    }

    public static Strategy operation(int type) {
        Strategy strategy = map.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException("not fond strategy");
        }
        return strategy;
    }



    public static void main(String[] args) {
        // 六折优惠
        int type = 1;
        Strategy strategy = Context.operation(type);
        BigDecimal sixDiscount = strategy.discount(BigDecimal.valueOf(100));
        System.out.println("六折优惠价格:" + sixDiscount);
    }
}
