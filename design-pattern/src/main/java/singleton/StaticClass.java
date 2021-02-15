package singleton;

/**
 * @author: laizc
 * @date: created in 2021/2/12
 * @desc: 静态内部类
 **/
public class StaticClass {

    private StaticClass() {}

    private static class SingletonHolder {
        private static final SingletonHolder INSTANCE = new SingletonHolder();
    }

    public static final SingletonHolder getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
