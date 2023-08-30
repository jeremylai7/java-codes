package singleton;

/**
 * @author: laizc
 * @date: created in 2023/8/30
 * @desc:
 */
public class SingletonTest {

    public static void main(String[] args) {
        // 编译报错，因为 Singleton 构造函数是私有的
        //Singleton singleton = new Singleton();

        SnGenerator snGenerator = SnGenerator.getInstance();
        long sn = snGenerator.getSn();
        System.out.println(sn);
    }
}
