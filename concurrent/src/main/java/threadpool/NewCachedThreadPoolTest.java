package threadpool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: laizc
 * @Date: Created in  2022-05-07
 * @desc: 可缓存的线程池
 * vm args -Xms10m -Xmx10m
 */
public class NewCachedThreadPoolTest {

	@Test
	public void test() {
		ExecutorService executor = Executors.newCachedThreadPool();
		// maxThread 为 Integer.MAX_VALUES
		for (int i = 0; i < 100000000; i++) {
			executor.execute(new TaskThread());
			System.out.println(i);
		}



	}
}
