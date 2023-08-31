package jvm;

/**
 * @author: laizc
 * @date: created in 2023/7/20
 * @desc: 测试堆使用占比，-Xms300m -Xmx300m
 */
public class HeapTest {

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Thread.sleep(1000);
            System.out.println("hello");
        }
    }


}
