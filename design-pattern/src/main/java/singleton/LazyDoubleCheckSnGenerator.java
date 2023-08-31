package singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: laizc
 * @date: created in 2023/8/31
 * @desc:
 */
public class LazyDoubleCheckSnGenerator {

    private AtomicLong id = new AtomicLong(0);

    private static LazyDoubleCheckSnGenerator instance;

    // 构造函数设置为 private，类就无法被实例化
    private LazyDoubleCheckSnGenerator() {}

    // 双重检测
    public static LazyDoubleCheckSnGenerator getInstance() {
        if (instance == null) {
            // 类级别锁
            synchronized (LazyDoubleCheckSnGenerator.class) {
                if (instance == null) {
                    instance = new LazyDoubleCheckSnGenerator();
                }
            }
        }
        return instance;
    }

    public long getSn() {
        return id.incrementAndGet();
    }
}
