package threadpool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: laizc
 * @Date: Created in  2022-05-07
 * @desc: 定时线程池
 */
public class NewScheduledThreadPoolTest {

	@Test
	public void test() {
		ExecutorService executor = Executors.newScheduledThreadPool(3);
		int index = 1;
		while (true) {
			System.out.println(index++);
			executor.execute(new TaskThread());
		}

	}
}
