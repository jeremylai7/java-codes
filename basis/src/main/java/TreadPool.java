import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的创建
 */
public class TreadPool {

    /**
     * 创建一个可缓存的线程池，
     * 若线程数超过处理所需，缓存一段时间后会回收，
     * 如果线程不够，则新建线程
     */
    @Test
    public void cache() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            int index = i;
            executorService.execute(() -> {
                //获取线程名称，默认格式：pool-1-thread-1
                System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " "+index);
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }
    }

    /**
     * 设置固定大小的线程池
     */
    @Test
    public void fied() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            int index = i;
            executorService.execute(() -> {
                //获取线程名称，默认格式:pool-1-threa-1
                System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " " +index);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     *
     */
    @Test
    public void schedule() {
        ExecutorService executorService = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 10; i++) {
            int index = i;
            executorService.execute(() -> {
                //获取线程名称，默认格式:pool-1-threa-1
                System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " " +index);

            });
        }
    }

    /**
     * 个单线程化的线程池
     */
    @Test
    public void test4() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            int index = i;
            executorService.execute(() -> {
                //获取线程名称，默认格式:pool-1-threa-1
                System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " " +index);

            });
        }
    }
}
