package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in  2021-09-29
 * @desc: 方法区和运行时常量池内存溢出
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * jdk 1.8 -Xmx6m
 */
public class RuntimeConstantPoolOOM {

	public static void main(String[] args) {
		//使用list保持常量池引用，避免Full GC回收常量池
		//1
		/*List<String> list = new ArrayList<>();
		int i = 0;
		while (true) {
			list.add(String.valueOf(i++).intern());
		}*/
		//2
		String str1 = new StringBuilder("computer").append("software").toString();
		System.out.println(str1.intern() == str1);
		String str2 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str2.intern() == str2);



	}
}
