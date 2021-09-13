package forkjoin;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.RecursiveTask;

/**
 * @Author: laizc
 * @Date: Created in  2021-07-30
 * @desc: 做1+2+3+4+......+n
 */
public class CountTask extends RecursiveTask<Integer>{

	//阈值
	private static final int THRESHOLD = 2;

	private int start;

	private int end;

	public CountTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		boolean canCompute = (end - start) <= THRESHOLD;
		//如果任务足够小就计算任务
		if (canCompute) {
			for (int i = start; i <= end ; i++) {
				sum += i;
				//延迟10毫秒
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else {
			//如果任务大于阈值，就分成两个子任务计算
			int middle = (start + end)/2;
			CountTask leftTask = new CountTask(start,middle);
			CountTask rightTask = new CountTask(middle + 1,end);
			//执行子任务
			leftTask.fork();
			rightTask.fork();
			//等待子任务完，并返回结果
			int leftResult = leftTask.join();
			int rightResult = rightTask.join();
			sum = leftResult + rightResult;

		}
		return sum;
	}

	public static void main(String[] args) {
		int start = 1;
		int end = 1000;
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		CountTask countTask = new CountTask(start,end);
		int sum = countTask.compute();
		stopWatch.stop();
		//比较fork/join和不拆分耗时
		System.out.println("fork/join耗时:" + stopWatch.getTime() + ",sum:" + sum);
		stopWatch.reset();
		stopWatch.start();
		int sum2 = add(start,end);
		stopWatch.stop();
		System.out.println("普通累加耗时:" + stopWatch.getTime() + ",sum:" + sum2);

	}

	private static int add(int start,int end) {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += i;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return sum;
	}
}
