package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: laizc
 * @Date: Created in  2021-03-03
 * @desc: 线程安全问题解决方案
 *        1、synchronized 同步锁
 *        2、
 */
public class TicketThread implements Runnable{

	private int ticket = 100;

	private Lock lock = new ReentrantLock();

	@Override
	public void run() {
		while (true){
			lock.lock();
			//synchronized同步锁
			//synchronized (TicketThread.class) {
				if (ticket > 0) {
					try {
						//线程休眠，cpu切换到别的线程
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "售票,票号是"+ ticket);
					ticket--;
				}else {
					break;
				}
			//}
			lock.unlock();

		}
	}

	public static void main(String[] args) {
		TicketThread ticketThread = new TicketThread();
		Thread thread1 = new Thread(ticketThread,"窗口1");
		thread1.start();
		Thread thread2 = new Thread(ticketThread,"窗口2");
		thread2.start();
		Thread thread3 = new Thread(ticketThread,"窗口3");
		thread3.start();
	}
}
