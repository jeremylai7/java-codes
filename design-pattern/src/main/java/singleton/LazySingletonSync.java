package singleton;

/**
 * @author: laizc
 * @date: created in 2021/2/11
 * @desc: 懒汉单例，添加sync同步锁
 **/
public class LazySingletonSync {

    private static LazySingletonSync lazySingletonSync;

    private LazySingletonSync() {}

    public static synchronized LazySingletonSync getInstance() {
        if (lazySingletonSync == null) {
            lazySingletonSync =new LazySingletonSync();
        }
        return lazySingletonSync;
    }

}
