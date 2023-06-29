package factory;

import factory.model.AliPay;
import factory.model.Pay;
import factory.model.WechatPay;

/**
 * @author: laizc
 * @date: created in 2023/6/29
 * @desc:
 */
// 支付工厂类
public class PayFactory {

    public static Pay getPay(int payType) {
        Pay pay;
        if (payType == 1) {
            pay = new AliPay();
        } else {
            pay = new WechatPay();
        }
        return pay;
    }

}
