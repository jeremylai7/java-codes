package jvm.gc;

/**
 * @author: laizc
 * @date: created in 2023/7/17
 * @desc: 长期存活的对象进入老年代
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 *  -XX:MaxTenuringThreshold 设置1时，allocation1 第二次 GC 就进入老年代
 *  -XX:MaxTenuringThreshold 设置15时，allocation1 第二次 GC 还在新生代
 **/
public class TestTenuringThreshold {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }

}
