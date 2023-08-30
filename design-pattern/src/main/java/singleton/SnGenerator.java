package singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: laizc
 * @date: created in 2021/2/8
 **/
public class SnGenerator {

    private AtomicLong id = new AtomicLong(0);
    // 创建一个 Singleton 对象
    private static SnGenerator instance = new SnGenerator();

    // 构造函数设置为 private，类就无法被实例化
    private SnGenerator() {}

    // 获取唯一实例
    public static SnGenerator getInstance() {
        return instance;
    }

    public long getSn() {
        return id.incrementAndGet();
    }
}
