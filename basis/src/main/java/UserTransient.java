import java.io.Serializable;

/**
 * @Author: laizc
 * @Date: Created in  2021-05-21
 * @desc:
 */
public class UserTransient implements Serializable{

	private String name;

	private transient String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
