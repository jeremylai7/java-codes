package synchronize;

/**
 * @Author: laizc
 * @Date: Created in  2022-06-07
 * @desc: synchronized 测试
 * 编译 javac SynchronizedTest.java
 * 反编译 java p SynchronizedTest.class
 */
public class SynchronizedTest {

	public static void main(String[] args) {
		synchronized (SynchronizedTest.class) {
			System.out.println("SynchronizedTest");
		}
	}

}
