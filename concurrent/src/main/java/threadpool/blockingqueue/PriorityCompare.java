package threadpool.blockingqueue;

/**
 * @Author: laizc
 * @Date: created in 2022-06-21
 */
public class PriorityCompare implements Comparable<Integer>{

    private Integer index;

    public PriorityCompare(int index) {
        this.index = index;
    }

    @Override
    public int compareTo(Integer o) {
        return Integer.compare(index,o);
    }
}
