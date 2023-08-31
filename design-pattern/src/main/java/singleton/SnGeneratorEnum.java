package singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: laizc
 * @date: created in 2023/8/31
 * @desc:
 */
public enum SnGeneratorEnum {

    instance;

    private AtomicLong id = new AtomicLong(0);

    public long getSn() {
        return id.incrementAndGet();
    }

}
