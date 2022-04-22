package jmm;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2022-04-22
 * @desc: 可见性测试
 */
public class VisibilityTest {

	private static int count = 0;

	private void add10k() {
		int index = 0;
		while (index++ < 10000) {
			count += 1;
		}
	}

	@Test
	public void calc() throws InterruptedException {
		VisibilityTest test = new VisibilityTest();
		Thread thread1 = new Thread(() -> test.add10k());
		Thread thread2 = new Thread(() -> test.add10k());
		// 启动两个线程
		thread1.start();
		thread2.start();
		// 等待两个线程执行结束
		thread1.join();
		thread2.join();
		System.out.println(count);



	}
}
