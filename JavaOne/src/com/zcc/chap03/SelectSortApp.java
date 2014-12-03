package com.zcc.chap03;

public class SelectSortApp {
	public static void main(String[] args) {
		int maxSize = 100000; // array size
		ArraySel arr; // reference to array
		arr = new ArraySel(maxSize); // create the array
		// for (int i = 0; i < maxSize; i++) {
		// long m = (long) (Math.random() * (maxSize - 1));
		// arr.insert(m);
		// }

		// for (int i = maxSize - 1; i >= 0; i--) {
		// arr.insert(i);
		// }

		for (int i = 0; i < maxSize; i++) {
			arr.insert(i);
		}

		// arr.insert(77); // insert 10 items
		// arr.insert(99);
		// arr.insert(44);
		// arr.insert(55);
		// arr.insert(22);
		// arr.insert(88);
		// arr.insert(11);
		// arr.insert(00);
		// arr.insert(66);
		// arr.insert(33);

		long start = System.currentTimeMillis();
		arr.selectionSort(); // selection-sort them
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		// arr.display(); // display items
		//
		//
		// arr.display(); // display them again
	} // end main()
}
