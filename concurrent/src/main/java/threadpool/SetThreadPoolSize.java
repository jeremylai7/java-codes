package threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * desc 设置线程池大小
 */
public class SetThreadPoolSize {

    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(8,8,10, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(1000),new ThreadPoolExecutor.DiscardOldestPolicy());

    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("CPU 核数:" +cores);
        int requestNum = 100;
        List<Future<?>> futureList = new ArrayList<>();

        Vector<Long> wholeTimeList = new Vector<>();
        Vector<Long> runTimeList = new Vector<>();

        for (int i = 0; i < requestNum; i++) {
            //threadPool.submit();
        }

    }


}
