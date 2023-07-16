package jvm.gc;

/**
 * @author: laizc
 * @date: created in 2023/7/16
 * @desc: 新生代 minor GC
 * -verbose:gc -Xms20 -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *   堆20m   新生代10m 老年代10m   eden区 8m  from space：1m   to space:1m
 *
 **/
public class TestAllocation {

    private static final int _1MB = 1024 * 1024;

    // 最开始分配到 eden 区，等到分配到 allocation4 时，eden 以及占了6m，剩下2m，不够分配给 allocation4 所需内存 4m
    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        //内存不够，此时发生 Minor GC
        allocation4 = new byte[4 * _1MB];

    }

}
