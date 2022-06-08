package synchronize;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2022-06-08
 * @desc: 非线性安全数字自增
 */
public class UnsafeSequence {

	private static int value;

	public void getNext() {
		// 累加两万次
		int idx = 0;
		while (idx++ < 40000) {
			value = value + 1;
		}
	}


	/**
	 * 多个线程之间的操作是交替进行，两个线程
	 * @throws InterruptedException
	 */

	public static void main(String[] args) throws InterruptedException {
		int value = test();
		System.out.println(value);
	}

	public static int test() throws InterruptedException {
		UnsafeSequence sequence = new UnsafeSequence();
		Thread thread1 = new Thread(() -> sequence.getNext());
		Thread thread2 = new Thread(() -> sequence.getNext());
		// 启动两个线程
		thread1.start();
		thread2.start();
		// 等待两个线程执行结束
		thread1.join();
		thread2.join();
		return value;


	}
}
