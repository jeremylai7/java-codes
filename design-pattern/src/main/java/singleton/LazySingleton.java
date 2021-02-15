package singleton;

/**
 * @author: laizc
 * @date: created in 2021/2/8
 * @desc: 懒汉单例 线程不安全 比较懒，获取实例的时候才会创建实例
 **/
public class LazySingleton {

    private static LazySingleton ehSingleton;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (ehSingleton == null) {
            ehSingleton = new LazySingleton();
        }
        return ehSingleton;

    }

}
