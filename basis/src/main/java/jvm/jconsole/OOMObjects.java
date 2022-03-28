package jvm.jconsole;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in  2022-03-28
 * @desc: 内存监控 -Xms100m -Xmx100m -XX:+UseSerialGC
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
		System.gc();
	}

	public static void main(String[] args) throws InterruptedException {
		fillHeap(1000);
	}
}
