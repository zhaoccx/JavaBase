package com.utils.sort;

/**
 * @author zhaocc 希尔排序（最小增量排序）
 */
public class ShellSort {
	/**
	 * 算法先将要排序的一组数按某个增量d（n/2,n为要排序数的个数）分成若干组，每组中记录的下标相差d.
	 * 对每组中全部元素进行直接插入排序，然后再用一个较小的增量（d/2）对它进行分组，
	 * 在每组中再进行直接插入排序。当增量减到1时，进行直接插入排序后，排序完成。
	 */
	public ShellSort() {
		int arrays[] = { 93, 49, 56, 17, 18, 23 };
		double arraysize = arrays.length;
		int temp = 0;

		while (true) {
			arraysize = Math.ceil(arraysize / 2);
			int middle = (int) arraysize;
			for (int x = 0; x < middle; x++) {

				for (int i = x + middle; i < arrays.length; i += middle) {
					int j = i - middle;
					temp = arrays[i];
					for (; j >= 0 && temp < arrays[j]; j -= middle) {
						arrays[j + middle] = arrays[j];
					}
					arrays[j + middle] = temp;
				}
			}

			if (middle == 1) {
				break;
			}

			for (int i = 0; i < arrays.length; i++) {
				System.out.print(arrays[i] + "\t");
			}
			System.out.println();
		}
		System.out.println("******************************************");
		for (int index = 0; index < arrays.length; index++) {
			System.out.print(arrays[index] + "\t");
		}
	}

	public static void main(String[] args) {
		new ShellSort();
	}
}
