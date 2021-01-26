import sun.text.resources.cldr.ia.FormatData_ia;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: laizc
 * @Date: Created in  2021-01-26
 * @desc: 判断hashmap,ConcurrentHashMap是否是线程安全，先put，再remove数据。
 */
public class HashMapTest {

	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		//Map<String,String> map = new ConcurrentHashMap<>();
		for (int i = 0; i < 100; i++) {
			TestThread testThread = new TestThread(map,"线程名称" + i);
			testThread.start();
		}
	}

}

class TestThread extends Thread{

	public Map<String,String> map;

	private String name;

	private Random random = new Random();;

	public TestThread(Map<String,String> map,String name){
		this.map = map;
		this.name = name;
	}


	@Override
	public void run() {
		int index = random.nextInt();
		map.put("键" + index,"值" + index);
		map.remove("键" + index);
		System.out.println(name + "位置index索引" + index +  " size = " + map.size());
	}
}
