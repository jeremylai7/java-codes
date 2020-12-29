import org.junit.Test;
import source.ArrayListSrc;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: laizc
 * @Date: Created in  2020-12-29
 * @desc:
 */
public class TestFirst {

	@Test
	public void addSrc(){
		List<String> list = new ArrayListSrc<>();
		list.add("23");
		System.out.println(list);
	}

	@Test
	public void add() {
		List<String> list2 = new ArrayList<>();
		list2.add("23");
		System.out.println(list2);
	}

}
