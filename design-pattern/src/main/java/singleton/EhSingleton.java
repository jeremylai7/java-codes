package singleton;

/**
 * @author: laizc
 * @date: created in 2021/2/11
 * @desc: 饿汉单例 很饿，直接创建一个对象
 * 缺点：类加载就初始化，浪费内存。
 * 优点：没有加锁，执行效率比较高。
 * 线程安全
 *
 **/
public class EhSingleton {

    private static EhSingleton ehSingleton = new EhSingleton();

    private EhSingleton() {}

    public static EhSingleton getInstance(){
        return ehSingleton;
    }

}
