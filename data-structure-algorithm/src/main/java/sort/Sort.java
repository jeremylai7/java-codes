package sort;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2020-11-30
 * @desc: 排序
 */
public class Sort {
	
	private static int[] array = {1,3,5,6,8,2,7,4};

	/** desc 冒泡排序
	 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
	 *
	 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     *
	 * 针对所有的元素重复以上的步骤，除了最后一个。
     *
	 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
	 *
	 * 时间复杂度 O(n2)
	 */
	@Test
	public void bubbleSort(){
		int length = array.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length - i -1 ; j++) {
				if (array[j] > array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		System.out.println(array);
	}

	/**
	 * desc 选择排序
	 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
     *
	 * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     *
	 * 重复第二步，直到所有元素均排序完毕。
	 * 时间复杂度 O(n2)
	 */
	@Test
	public void selectionSort(){
		int length = array.length;
		for (int i = 0; i < length ; i++) {
			int minIndex = i;
			for (int j = i; j < length; j++) {
				if (array[j] < array[minIndex]){
					minIndex = j;
				}
			}
			int temp = array[minIndex];
            array[minIndex] = array[i];
			array[i] = temp;
		}
		System.out.println(array);

	}

}
