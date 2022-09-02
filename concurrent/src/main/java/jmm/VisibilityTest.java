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
        // 结果小于 20000
        System.out.println(count);
    }

    private static volatile boolean flag = true;
    //private static boolean flag = true;

    @Test
    public void test2() {
        new Thread1().start();
        try {
            // 暂停一秒，保证线程1 启动并运行
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread2().start();

    }

    class Thread1 extends Thread {
        @Override
        public void run() {
            while (flag) {
                // flag 为 true，一直读取flag字段，flag 为 false 时跳出来。
                //System.out.println("一直在读------" + flag);
            }
            System.out.println("thread - 1 跳出来了");
        }
    }

    class Thread2 extends Thread {

        @Override
        public void run() {
            /*try {
                // 休眠两秒
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            System.out.println("thread-2 run");
            flag = false;
            System.out.println("flag 改成 false");
        }
    }

}
