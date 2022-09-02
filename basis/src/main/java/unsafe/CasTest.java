package unsafe;

import org.junit.Test;
import sun.misc.Unsafe;

/**
 * @Author: laizc
 * @Date: created in 2022-08-03
 */
public class CasTest {

    private static Unsafe u;

    static {
        u = Unsafe.getUnsafe();
    }

    @Test
    public void test() {
        User user = new User();
        user.setAge(10);

        u.compareAndSwapInt(user,0l,10,20);



    }
}
