package strategy.demo;

import java.math.BigDecimal;

/**
 * 创建一个接口
 */
public interface Strategy {

    BigDecimal discount(BigDecimal amount);

}
