package singleton;

/**
 * @author: laizc
 * @date: created in 2021/2/8
 **/
public class Singleton {

    // 创建一个 Singleton 对象
    private static Singleton instance = new Singleton();

    // 构造函数设置为 private，类就无法被实例化
    private Singleton() {}

    // 获取唯一实例
    public static Singleton getInstance() {
        return instance;
    }

    public void print() {
        System.out.println("Hello");
    }



}
