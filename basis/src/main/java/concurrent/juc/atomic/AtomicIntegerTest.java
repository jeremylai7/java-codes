package concurrent.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: laizc
 * @Date: Created in  2021-07-28
 * @desc: AtomicInteger 测试类
 */
public class AtomicIntegerTest {

	private static int count = 0;

	public static void increment() {
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

	public static void incrementAtomicInteger() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(10);
				sharedValue.incrementAndGet();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		int maxThread = 3;
		//普通方式
		/*for (int i = 0; i < maxThread; i++) {
			Thread thread = new Thread(() -> increment());
			thread.start();
		}
		Thread.sleep(4000);
		//返回结果小于300
		System.out.println(count);*/
		//atomicInteger方式
		for (int i = 0; i < maxThread; i++) {
			Thread thread = new Thread(() -> incrementAtomicInteger());
			thread.start();
		}
		Thread.sleep(4000);
		//结果等于300
		System.out.println(sharedValue.get());

	}
}
