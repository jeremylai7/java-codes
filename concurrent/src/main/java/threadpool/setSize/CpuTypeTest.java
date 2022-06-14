package threadpool.setSize;

import java.util.List;

/**
 * @author: laizc
 * @date: created in 2022/6/13
 * @desc: cpu 密集计算
 **/
public class CpuTypeTest implements Runnable{

    // 整体执行时间，包括在队列中等待的时间
    List<Long> wholeTimeList;

    // 真正执行的时间
    List<Long> runTimeList;

    private long initStarTime = 0;

    public CpuTypeTest(List<Long> runTimeList,List<Long> wholeTimeList) {
        initStarTime = System.currentTimeMillis();
        this.wholeTimeList = wholeTimeList;
        this.runTimeList = runTimeList;
    }


    @Override
    public void run() {
        long start = System.currentTimeMillis();
        countPrimes(1,1000000);
        long end = System.currentTimeMillis();
        long wholeTime = end - initStarTime;
        long runTime = end - start;
        wholeTimeList.add(wholeTime);
        runTimeList.add(runTime);
        //System.out.println("单个线程花费时间：" + (end - start));

    }

    /**
     * 判断素数
     * @param number
     * @return
     */
    public boolean isPrime(final int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 计算素数
     * @param lower
     * @param upper
     * @return
     */
    public int countPrimes(final int lower,final int upper) {
        int total = 0;
        for (int i = 0; i <= upper; i++) {
            if (isPrime(i)) {
                total++;
            }
        }
        return total;
    }


}
