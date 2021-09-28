package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in  2021-09-28
 * @desc: Java堆溢出
 * VM Args： -Xms20m -Xmx20m
 */
public class HeapOOM {

	static class OOMObject {}

	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<>();
		while (true) {
			list.add(new OOMObject());
		}
	}

}
