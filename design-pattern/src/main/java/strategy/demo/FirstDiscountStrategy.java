package strategy.demo;

import java.math.BigDecimal;

/**
 * @author: laizc
 * @date: created in 2023/6/21
 * @desc:
 */
// 满100减20，满200减50
public class FirstDiscountStrategy implements Strategy{
    @Override
    public BigDecimal discount(BigDecimal amount) {
        // 满100减20，满200减50
        // 省略具体算法
        return amount;
    }
}
