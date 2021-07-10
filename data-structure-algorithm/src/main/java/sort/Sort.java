package sort;

import org.junit.Test;

/**
 * @Author: laizc
 * @Date: Created in  2020-11-30
 * @desc: 排序
 */
public class Sort {
	
	//private static int[] array = {1,3,5,6,8,2,7,4,3};

	private static int[] array = {5,4,2,3,8};

	private void print(){
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

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
		print();
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
		print();
	}

	/**
	 * desc 插入排序
	 * 将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
     *
	 * 从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面）
	 * 时间复杂度 O(n2)
	 */
	@Test
	public void insertSort(){
		int length = array.length;
		for (int i = 1; i < length; i++) {
			int temp = array[i];
			int j = i -1;
			for (;j >= 0; --j){
				if (array[j] > temp){
					array[j+1] = array[j];
				}else {
					break;
				}
			}
			array[j+1] = temp;
		}
		print();

	}

	/**
	 * desc 快速排序 思想：分治法
	 * 1、从数组中选取一个数为基准数，通常是选择数组的第一个数
	 * 2、比基准数大的放在基准数的左边，比基础数大的放在基准数的右边
	 * 3、对左右分区重复第二步，直到分区只有一个数
	 *
	 *  时间复杂度 O(nlogn)
	 *
	 *  具体实现步骤
	 *  1、取出基准值，为了方面后面的赋值
	 *  2、从右边往左遍历，找到比基准值小的将改值赋值给基准值的位置
	 *  3、从左往右遍历，找到比基准值大的放在第2步在的位置
	 *  4、基准值放在第3步的的位置
	 */
	@Test
	public void quickSort(){
		sort(array,0,array.length -1);
		print();
	}

	private void sort(int a[],int left,int right){
		int i,j,index;
		if (left > right) {
			return;
		}
		i = left;
		j = right;
		//选取数组的第一个数为基准值
		index = array[i];
		while (i < j) {
			//右边小于基准值停止遍历
			while (i < j && a[j] > index) {
				j--;
			}
			if (i < j) {
				a[i] = a[j];
				i++;
			}
			//左边大于基准值停止遍历
			while (i < j && a[i] < index) {
				i++;
			}
			if (i < j) {
				a[j] = a[i];
				j--;
			}
		}
		a[i] = index;
		sort(a,left,i-1);
		sort(a,i+1,right);
	}

}
