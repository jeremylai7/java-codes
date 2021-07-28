package concurrent.juc.atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: laizc
 * @Date: Created in  2021-07-28
 * @desc: AtomicInteger 测试类
 */
public class AtomicIntegerTest {

	private static int count = 0;

	private static void increment() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(10);
				count++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	private static AtomicInteger sharedValue = new AtomicInteger();

	/**
	 * AtomicInteger 主要应用在多线程下，对int执行原子操作。
	 */
	private static void incrementAtomicInteger() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(10);
				sharedValue.incrementAndGet();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private int maxThread = 3;

	/**
	 * 普通方式累加
	 */
	@Test
	public void simple() throws InterruptedException{
		for (int i = 0; i < maxThread; i++) {
			Thread thread = new Thread(AtomicIntegerTest::increment);
			thread.start();
		}
		Thread.sleep(4000);
		//返回结果小于300
		System.out.println(count);
	}

	/**
	 * atomicInteger方式
	 */
	@Test
	public void atomicInteger() throws InterruptedException{
		for (int i = 0; i < maxThread; i++) {
			Thread thread = new Thread(AtomicIntegerTest::incrementAtomicInteger);
			thread.start();
		}
		Thread.sleep(4000);
		//结果等于300
		System.out.println(sharedValue.get());
	}

}
