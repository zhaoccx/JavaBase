package com.utils.sort;

/**
 * @author zhaocc 直接插入排序
 */
public class InsertSort {

	/**
	 * 在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排 好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数
	 * 也是排好顺序的。如此反复循环，直到全部排好顺序。
	 */
	public InsertSort() {
		int arrays[] = { 93, 49, 56, 17, 18, 23 };
		int temp = 0;
		for (int i = 1; i < arrays.length; i++) {
			int j = i - 1;
			temp = arrays[i];
			for (; j >= 0 && temp < arrays[j]; j--) {
				arrays[j + 1] = arrays[j]; // 将大于temp的值整体后移一个单位
			}
			arrays[j + 1] = temp;

			for (int index = 0; index < i; index++) {
				System.out.print(arrays[index] + "\t");
			}
			System.out.println();
		}
		for (int index = 0; index < arrays.length; index++) {
			System.out.print(arrays[index] + "\t");
		}

	}

	public static void main(String[] args) {
		new InsertSort();
	}

}
