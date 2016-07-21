package com.utils.sort;

/**
 * @author zhaocc 冒泡排序
 */
public class BubbleSort {
	/**
	 * 在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，
	 * 让较大的数往下沉，较小的往上冒。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
	 */
	public BubbleSort() {
		int arrays[] = { 93, 49, 56, 17, 18, 23 };
		int temp = 0;
		for (int i = 0; i < arrays.length - 1; i++) {
			for (int j = 0; j < arrays.length - 1 - i; j++) {
				if (arrays[j] > arrays[j + 1]) {
					temp = arrays[j];
					arrays[j] = arrays[j + 1];
					arrays[j + 1] = temp;
				}
			}

			for (int tep = 0; tep < arrays.length; tep++) {
				System.out.print(arrays[tep] + "\t");
			}
			System.out.println();
		}
		System.out.println("**************************");

		for (int i = 0; i < arrays.length; i++) {
			System.out.print(arrays[i] + "\t");
		}
	}

	public static void main(String[] args) {
		new BubbleSort();
	}
}
