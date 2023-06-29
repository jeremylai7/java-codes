package factory;

import factory.model.AliPay;
import factory.model.Pay;
import factory.model.WechatPay;

/**
 * @author: laizc
 * @date: created in 2023/6/29
 * @desc:
 */
public class PayFactoryDemo {

    public void order(int payType) {
        // 创建订单
        // 省略代码......
        // 根据type 调用不同的支付
        Pay pay;
        if (payType == 1) {
            pay = new AliPay();
        } else {
            pay = new WechatPay();
        }
        // 调用支付
        pay.pay();
        // 更新状态 代码省略.....


    }

    public void order2(int payType) {
        // 创建订单
        // 省略代码......
        // 根据type 调用不同的支付
        Pay pay  = PayFactory.getPay(payType);
        // 调用支付
        pay.pay();
        // 更新状态 代码省略.....

    }



}
