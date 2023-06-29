package strategy.demo;

import java.math.BigDecimal;

/**
 * @author: laizc
 * @date: created in 2023/6/21
 * @desc:
 */
// 打八折
public class EightDiscountStrategy  implements Strategy{
    @Override
    public BigDecimal discount(BigDecimal amount) {
        return amount = amount.multiply(BigDecimal.valueOf(0.8));
    }
}
