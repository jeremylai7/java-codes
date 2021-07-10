package algorithm;

import org.junit.Test;

/**
 * @author: laizc
 * @date: created in 2021/7/11
 * @desc: 一个收集的算法
 **/
public class OtherTest {

    /**
     * 给两个数（1，4）如何递归实现1+2+3+4
     */
    @Test
    public void test1(){
        int a = 1,b = 5;
        int sum = recursive(a,b);
        System.out.println(sum);
    }

    private int recursive(int a,int b) {
        if (a == b -1) {
            return a + b;
        }else {
            return recursive(a,b-1) + b;
        }
    }
}
