import org.junit.Test;

import java.io.*;

/**
 * @Author: laizc
 * @Date: Created in  2021-01-08
 * @desc: 序列化测试
 */
public class SerializationTest implements Serializable{

	/**
	 * 对象序列化，将对象保存在磁盘中，或者在网络直接传输对象
	 */
	@Test
	public void test2() {
		User user = new User();
		user.setName("aa");
		user.setPassword("bb");
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("/aa.txt");
			ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
			outputStream.writeObject(user);
			outputStream.close();
			fileOutputStream.close();
		}catch (IOException e) {
			e.printStackTrace();


		}
	}

	/**
	 * 对象反序列化：从文件读取序列化对象，
	 */
	@Test
	public void test3() {
		User user = null;
		try {
			FileInputStream fileInputStream = new FileInputStream("/aa.txt");
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			user = (User) inputStream.readObject();
			inputStream.close();
			fileInputStream.close();
		}catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(user.getName() + " " + user.getPassword());
	}
}
