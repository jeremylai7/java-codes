package thread;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: laizc
 * @Date: Created in  2021-07-02
 * @desc: 下单多线程
 */
public class OrderThread implements Runnable{

	private Map<String,Integer> stork = new HashMap<>();

	private Map<String,Integer> orders = new HashMap<>();

	{
		stork.put("123",10000);
		orders.put("123",10000);
	}

	@Override
	public void run() {
		while (true) {
			if (orders.get("123") > 0) {

			} else {
				break;
			}


		}

	}
}
