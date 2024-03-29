package threadpool;

import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author: laizc
 * @Date: Created in  2021-08-05
 * @desc: newFixedThreadPool 导致 OOM测试
 * newFixedThreadPool 创建固定线程数，但是队列数量是Integer.MAX_VALUES 会导致内存溢出
 *    vm args -Xms10m -Xmx10m
 */
public class NewFixedThreadPoolTest {

	@Test
	public void test() {
		ExecutorService threadPool = Executors.newFixedThreadPool(1);
		//核心线程和最大线程都是1，核心线程没有处理完，线程会大量在堆积在队列上，而队列又是Integer.MAX_VALUES
		for (int i = 0; i < 100000000; i++) {
			threadPool.execute(new TaskThread());
			System.out.println("index" + i);
		}
	}



}

