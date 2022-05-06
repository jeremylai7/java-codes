package threadpool;

import java.util.concurrent.TimeUnit;

/**
 * @Author: laizc
 * @Date: Created in  2022-05-06
 * @desc:
 */
public class TaskThread implements Runnable{
	@Override
	public void run() {
		try {
			TimeUnit.HOURS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
