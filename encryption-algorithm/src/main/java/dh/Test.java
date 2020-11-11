package dh;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: laizc
 * @Date: Created in  2020-07-21
 * @desc:
 */
public class Test implements Runnable{

	private int time = 1000;

	private String orderKey = "12";

	static Map<String,Integer> products;
	static Map<String,Integer> stock;
	static Map<String,Integer> orders;

	static {
		stock = new HashMap<String, Integer>();
		orders = new HashMap<String, Integer>();
		products = new HashMap<String, Integer>();
		products.put("123456", 100000);
		stock.put("123456", 100000);
	}

	public void run(){
		for (int i = 0; i < time; i++) {
			//模拟多个用户下单
			System.out.println(i + Thread.currentThread().getName());
			int stockNum = stock.get("123456");
			if (stockNum == 0){
				int aa = 1/0;
			}
			//减库存
			stock.put("123456",--stockNum);
			//添加订单
			Integer orderNum = orders.get(orderKey);
			if (orderNum == null){
				orderNum = 0;
			}
			orders.put("12",++orderNum);

		}

	}

	private int factorial(int n){
		if (n <= 1){
			return 1;
		}else {
			int subSolution = factorial(n - 1);
			return subSolution * n;
		}
	}

	public static void main(String[] args) {
		/*Test test = new Test();
		new Thread(test,"thread name first").start();
		new Thread(test,"thread name second").start();
		System.out.println(orders.get("12"));
		System.out.println(stock.get("123456"));*/
		Test test = new Test();
		int result = test.factorial(3);
		System.out.println(result);

	}
}
