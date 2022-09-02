package jmm;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: created in 2022-09-02
 * @desc: 可见性测试
 */
public class VisibilityTest {

    private static long count = 0;

    private void add10K() {
        int idx = 0;
        while(idx++ < 10000) {
            count += 1;
        }
    }

    @Test
    public void test() throws InterruptedException {
        VisibilityTest test = new VisibilityTest();
        // 创建两个线程，执行 add 累加操作
        Thread th1 = new Thread(() -> {test.add10K();});
        Thread th2 = new Thread(() -> {test.add10K();});
        // 启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束
        th1.join();
        th2.join();
        System.out.println(count);
    }


}
