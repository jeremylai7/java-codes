package factory;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author: laizc
 * @date: created in 2023/6/28
 * @desc: 工厂模式应用
 */
public class FactoryDemo {

    @Test
    public void test() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        System.out.println(date);
    }

}
