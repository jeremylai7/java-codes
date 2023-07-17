package jvm.gc;

/**
 * @author: laizc
 * @date: created in 2023/7/17
 * @desc: 大对象直接进入老年代  3145728 = 3M 不能直接写成3M
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 *
 * jdk1.8 默认收集器是 ParallelGC 并行GC,PretenureSizeThreshold 参数只对 Serial 和 ParNew 两款新生收集器有效
 * 在参数后添加 -XX:+UseParNewGC 或者 -XX:+UseSerialGC
 **/
public class TestPretenureSizeThreshold {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation;
        // 直接分配在老年代中
        allocation = new byte[4 * _1MB];
    }

}
