package threadpool.setSize;

import java.io.*;
import java.util.List;

/**
 * @author: laizc
 * @date: created in 2022/6/14
 * @desc: IO 密集型计算
 * vm args -Xms4g -Xmx4g
 **/
public class IOTypeTest implements Runnable{
    // 整体执行时间，包括在队列中等待的时间
    List<Long> wholeTimeList;

    // 真正执行的时间
    List<Long> runTimeList;

    private long initStarTime = 0;

    public IOTypeTest(List<Long> runTimeList,List<Long> wholeTimeList) {
        initStarTime = System.currentTimeMillis();
        this.wholeTimeList = wholeTimeList;
        this.runTimeList = runTimeList;
    }

    public void readAndWrite() throws IOException {
        File file = new File("/Users/opt/test.txt");
        // 创建输入流
        BufferedReader input = new BufferedReader(new FileReader(file));
        // 读取源文件，写入到新的文件
        String line = null;
        while ((line = input.readLine()) != null) {
            //System.out.println(line);
        }
        input.close();


    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        try {
            readAndWrite();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        long wholeTime = end - initStarTime;
        long runTime = end - start;
        wholeTimeList.add(wholeTime);
        runTimeList.add(runTime);
        //System.out.println("单个线程花费时间：" + (end - start ));

    }
}
