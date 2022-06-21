package threadpool.setSize.rejectpolicy;

import java.util.concurrent.TimeUnit;

/**
 * @Author: laizc
 * @Date: created in 2022-06-21
 */
public class TaskThread implements Runnable{

    private int i;

    public TaskThread(int i) {
        this.i = i;
    }


    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("执行任务：" + i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
