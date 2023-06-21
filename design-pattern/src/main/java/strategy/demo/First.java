package strategy.demo;

import java.math.BigDecimal;

/**
 * @author: laizc
 * @date: created in 2023/6/21
 * @desc:
 */
public class First {

    // 打六折
    public BigDecimal sixDiscount(BigDecimal amount) {
        BigDecimal discount = BigDecimal.valueOf(0.6);
        return amount.multiply(discount);
    }

    // 打八折
    public BigDecimal eightDiscount(BigDecimal amount) {
        BigDecimal discount = BigDecimal.valueOf(0.8);
        return amount.multiply(discount);
    }

    // 根据不同的type，选择不同的打折方案
    public BigDecimal simpleDiscount(int type,BigDecimal amount) {
        if (type == 1) {
            amount = amount.multiply(BigDecimal.valueOf(0.6));
        } else if (type == 2) {
            amount = amount.multiply(BigDecimal.valueOf(0.8));
        }
        return amount;
    }

    // 根据不同的type，选择不同的打折方案
    public BigDecimal discount(int type,BigDecimal amount) {
        if (type == 1) {
            amount = amount.multiply(BigDecimal.valueOf(0.6));
        } else if (type == 2) {
            amount = amount.multiply(BigDecimal.valueOf(0.8));
        } else if (type == 3) {
            // 满100减20，满200减50
        } else if (type == 4) {
            // 满500减70
        } else if (type == 5) {
            // 满1000减两百
        }
        // 更多的方案 .....
        return amount;
    }



}
