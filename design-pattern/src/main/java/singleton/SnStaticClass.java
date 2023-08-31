package singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: laizc
 * @date: created in 2023/8/31
 * @desc:
 */
public class SnStaticClass {
    private AtomicLong id = new AtomicLong(0);

    private static LazySnGenerator instance;

    // 构造函数设置为 private，类就无法被实例化
    private SnStaticClass() {}

    private static class SingletonHolder{
        private static final SnStaticClass instance = new SnStaticClass();
    }

    // 静态内部类获取实例
    public synchronized static SnStaticClass getInstance() {
        return SingletonHolder.instance;
    }

    public long getSn() {
        return id.incrementAndGet();
    }
}
