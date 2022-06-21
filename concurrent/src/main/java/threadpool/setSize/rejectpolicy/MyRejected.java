package threadpool.setSize.rejectpolicy;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: laizc
 * @Date: created in 2022-06-21
 * @desc: 重写拒绝策略
 */
public class MyRejected implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
        TaskThread taskThread = (TaskThread) runnable;
        int i = taskThread.getI();
        System.out.println("当前拒绝任务：" + i);

        /*if (!executor.isShutdown()) {
            runnable.run();
        }*/

    }
}
