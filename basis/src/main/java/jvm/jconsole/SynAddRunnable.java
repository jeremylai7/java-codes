package jvm.jconsole;

/**
 * @author: laizc
 * @date: created in 2023/7/19
 * @desc: 死锁检测
 *  integer.valueOf 在 -127,128 之间 直接创建缓存
 *  多次循环，一共就返回两个对象。
 *  a 线程锁住 1，b 线程锁住 2，
 *  a 线程尝试锁住 2，b 线程尝试锁住 1。就死锁了。
 */
public class SynAddRunnable implements Runnable{

    int a,b;

    public SynAddRunnable(int a,int b) {
        this.a = a;
        this.b = b;
    }


    @Override
    public void run() {
        synchronized (Integer.valueOf(a)) {
            synchronized (Integer.valueOf(b)) {
                System.out.println(a + b);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(15000);
        System.out.println("--开始--");
        for (int i = 0; i < 100; i++) {
            new Thread(new SynAddRunnable(1,2)).start();
            new Thread(new SynAddRunnable(2,1)).start();
        }
    }

}
