package factory.model;

/**
 * @author: laizc
 * @date: created in 2023/6/29
 * @desc:
 */
// 微信支付
public class WechatPay implements Pay{

    @Override
    public void pay() {
        System.out.println("微信支付 .....");
    }
}
