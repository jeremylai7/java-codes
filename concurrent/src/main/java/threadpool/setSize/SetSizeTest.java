package threadpool.setSize;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;

/**
 * @author: laizc
 * @date: created in 2022/6/13
 * @desc: 测试核心线程数设置
 **/
public class SetSizeTest {

    private static int coreSize = 26;

    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(coreSize,coreSize,10, TimeUnit.SECONDS,new ArrayBlockingQueue<>(1000),new ThreadPoolExecutor.DiscardOldestPolicy());

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("CPU核数：" + cores + " 线程数：" + threadPool.getCorePoolSize());
        int requestNum = 50;
        List<Future<?>> futureList = new ArrayList<>();

        Vector<Long> wholeTimeList = new Vector<>();
        Vector<Long> runTimeList = new Vector<>();

        for (int i = 0; i < requestNum; i++) {
            //Future<?> future = threadPool.submit(new CpuTypeTest(runTimeList,wholeTimeList));
            Future<?> future = threadPool.submit(new IOTypeTest(runTimeList,wholeTimeList));
            futureList.add(future);
        }

        for (Future<?> future : futureList) {
            // 获取线程执行结果
            future.get(requestNum,TimeUnit.SECONDS);
        }

        long wholeTime = 0;
        // 时间累加
        for (int i = 0; i < wholeTimeList.size(); i++) {
            wholeTime = wholeTimeList.get(i) + wholeTime;
        }

        long runTime = 0;
        for (int i = 0; i < runTimeList.size(); i++) {
            runTime = runTimeList.get(i) + runTime;
        }

        System.out.println("平均每个线程整体花费时间:" + wholeTime/wholeTimeList.size());
        System.out.println("平均每个线程执行花费时间:" + runTime/runTimeList.size());





    }

}
