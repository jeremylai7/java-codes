package factory.model;

/**
 * @author: laizc
 * @date: created in 2023/6/29
 * @desc:
 */
// 支付宝支付
public class AliPay implements Pay{
    @Override
    public void pay() {
        System.out.println("支付宝支付 .....");
    }
}
