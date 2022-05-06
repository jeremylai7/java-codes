package threadpool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: laizc
 * @Date: Created in  2022-05-06
 * @desc: 单线程池，阻塞队列长度为 Integer.MAX_VALUE，
 * 堆积大量请求，导致oom
 * vm args -Xms10m -Xmx10m
 */
public class NewSingleThreadPoolTest {


	@Test
	public void test() {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 100000000; i++) {
			executor.execute(new TaskThread());
			System.out.println();
		}
	}
}
