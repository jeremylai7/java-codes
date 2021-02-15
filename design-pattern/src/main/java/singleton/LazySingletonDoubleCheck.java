package singleton;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * @author: laizc
 * @date: created in 2021/2/12
 * @desc: 懒汉单例 双重检验
 **/
public class LazySingletonDoubleCheck {

    private static LazySingletonDoubleCheck lazySingletonDoubleCheck;

    private LazySingletonDoubleCheck() {}

    public static LazySingletonDoubleCheck getInstance() {
        if (lazySingletonDoubleCheck == null) {
            synchronized (LazySingletonDoubleCheck.class) {
                if (lazySingletonDoubleCheck == null) {
                    lazySingletonDoubleCheck = new LazySingletonDoubleCheck();
                }
            }
        }
        return lazySingletonDoubleCheck;
    }

}
