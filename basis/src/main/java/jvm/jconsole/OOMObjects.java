package jvm.jconsole;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in  2022-03-28
 * @desc: 内存监控 -Xms100m -Xmx100m -XX:+UseSerialGC
 *    堆 100m yong区占 1/3，大概 33m,eden 区占 yong 区 8/10 大概 27m
 *    开始往 eden 区填充数据，达到最大值 27，就发生 yong gc 数据保存到老年代中
 *    最后执行 gc 也是 full gc，eden 区和 survive 区都清空。老年代还有数据、因为 list 引用对象还存活
 *    System.gc() 放在最外面，old 也会清空
 *
 *
 */
public class OOMObjects {

	static class OOMObject{
		public byte[] place = new byte[64 * 1024];
	}

	public static void fillHeap(int num) throws InterruptedException {
		List<OOMObject> list = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			Thread.sleep(50);
			list.add(new OOMObject());
		}
		//System.gc();
	}

	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("---开始--");
		fillHeap(1000);
		System.gc();
		System.out.println("---结束--");
		// 程序结束，jsoncole 监控会断开，无法监控，为了方便监控，再添加延迟
		Thread.sleep(15000);
	}
}
