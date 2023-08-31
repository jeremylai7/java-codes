package singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: laizc
 * @date: created in 2023/8/31
 * @desc:
 */
public class LazySnGenerator {

    private AtomicLong id = new AtomicLong(0);

    private static LazySnGenerator instance;

    // 构造函数设置为 private，类就无法被实例化
    private LazySnGenerator() {}

    // 获取唯一实例
    public synchronized static LazySnGenerator getInstance() {
        if (instance == null) {
            instance = new LazySnGenerator();
        }
        return instance;
    }

    public long getSn() {
        return id.incrementAndGet();
    }

}
