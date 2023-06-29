package strategy.demo;

import java.math.BigDecimal;

/**
 * @author: laizc
 * @date: created in 2023/6/21
 * @desc:
 */
// 打六折
public class SixDiscountStrategy implements Strategy{
    @Override
    public BigDecimal discount(BigDecimal amount) {
        return amount = amount.multiply(BigDecimal.valueOf(0.6));
    }
}
