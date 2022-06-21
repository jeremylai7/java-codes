package threadpool.blockingqueue;

import java.util.concurrent.*;

/**
 * @Author: laizc
 * @Date: created in 2022-06-21
 */
public class BlockingQueueTest {

    // 核心线程数
    private static int corePoolSize = 1;

    // 最大线程数
    private static int maximumPoolSize = 1;

    // 线程存活时间
    private static long keepAliveTime = 10;

    // 线程存活时间单位
    private static TimeUnit unit = TimeUnit.SECONDS;

    // 线程工厂
    private static ThreadFactory threadFactory = Executors.defaultThreadFactory();

    public static void main(String[] args) {
        // 无界队列
        //BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(1);
        // 有界队列
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1);
        // 优先队列
        //BlockingQueue<PriorityCompare> queue = new PriorityBlockingQueue<>();


       ThreadPoolExecutor threadPool = new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                queue,
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 1; i <= 5 ; i++) {
            threadPool.execute(new TaskThread(i));

        }

    }
}
