package thread;

/**
 * @author: laizc
 * @date: created in 2021/7/7
 * @desc: sleep和wait的区别
 * 基本区别 1、sleep是Thread类的方法，wait是Object的方法
 *         2、sleep是在任何地方都能使用
 *         3、wait只能在synchronized方法或者synchronized代码块中使用
 *  本质区别 1、sleep只会让出cpu，不会释放锁
 *          2、wait不仅会让出cpu，还会释放已占有的锁
 *
 **/
public class SleepWait {

    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(() -> {
            System.out.println("thread A is 等待锁");
            synchronized (lock) {
                try {
                    System.out.println("thread A 获得锁");
                    Thread.sleep(20);
                    System.out.println("thread A do 等到方法");
                    lock.wait(1000);
                    System.out.println("thread A is done");
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            System.out.println("thread B is 等待锁");
            synchronized (lock) {
                try {
                    System.out.println("thread B 获得锁");
                    lock.wait(1000);
                    System.out.println("thread B do 等到方法");
                    Thread.sleep(20);
                    System.out.println("thread B is done");
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

}
