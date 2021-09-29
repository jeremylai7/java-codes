package jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author: laizc
 * @Date: Created in  2021-09-29
 * @desc: 使用 unsafe 直接内存溢出
 * @VM Args: -Xmx20M -XX:MaxDirectMemorySize=10m
 */
public class DirectMemoryOOM {

	private static final int ONE_MB = 1024 * 1024;

	public static void main(String[] args) throws IllegalAccessException {
		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe) unsafeField.get(null);
		while (true) {
			unsafe.allocateMemory(ONE_MB);
		}

	}
}
