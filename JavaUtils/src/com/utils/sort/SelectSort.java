package com.utils.sort;

/**
 * @author zhaocc 简单选择排序
 */
public class SelectSort {
	/**
	 * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
	 * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
	 */
	public SelectSort() {
		int arrays[] = { 93, 49, 56, 17, 18, 23 };
		int position = 0;
		for (int i = 0; i < arrays.length; i++) {
			int j = i + 1;
			position = i;
			int temp = arrays[i];
			for (; j < arrays.length; j++) {
				if (arrays[j] < temp) {
					temp = arrays[j];
					position = j;
				}
			}
			arrays[position] = arrays[i];
			arrays[i] = temp;

			for (int index = 0; index < arrays.length; index++)
				System.out.print(arrays[index] + "\t");
			System.out.println();
		}
		System.out.println("*****************************************");
		for (int index = 0; index < arrays.length; index++)
			System.out.print(arrays[index] + "\t");
	}

	public static void main(String[] args) {
		new SelectSort();
	}
}
