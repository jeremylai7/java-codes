package threadpool.setSize.rejectpolicy;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @Author: laizc
 * @Date: created in 2022-06-21
 */
public class RejectPolicyTest {

    // 核心线程数
    private static int corePoolSize = 1;

    // 最大线程数
    private static int maximumPoolSize = 2;

    // 线程存活时间
    private static long keepAliveTime = 10;

    // 线程存活时间单位
    private static TimeUnit unit = TimeUnit.SECONDS;

    // 有界队列 遵循 FIFO 原则
    private static BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(1);

    // 线程工厂
    private static ThreadFactory threadFactory = Executors.defaultThreadFactory();


    public static void main(String[] args) {
        // 默认拒绝策略，拒绝任务并抛出异常：
        //RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
        // 拒绝任务，不会抛出错误
        //RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();
        // 调用线程运行多余任务
        //RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
        // 丢弃阻塞队列的最老的任务，并将新的任务加入到阻塞队列中
        RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardOldestPolicy();
        MyRejected myRejected = new MyRejected();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                threadFactory,
                myRejected);
        for (int i = 1; i <= 5 ; i++) {
            try {
                threadPool.execute(new TaskThread(i));
            } catch (Exception e) {
                System.out.println("【任务" + i + "】报错:" + e.getMessage());
            }

        }
    }



}
