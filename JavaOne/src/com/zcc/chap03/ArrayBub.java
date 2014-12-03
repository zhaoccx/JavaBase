package com.zcc.chap03;

//bubbleSort.java
//demonstrates bubble sort
//to run this program: C>java BubbleSortApp
////////////////////////////////////////////////////////////////
public class ArrayBub {
	private long[] a; // ref to array a
	private int nElems; // number of data items

	// --------------------------------------------------------------

	public ArrayBub(int max) {// constructor
		a = new long[max]; // create the array
		nElems = 0; // no items yet
	}

	// --------------------------------------------------------------
	public void insert(long value) {// put element into array
		a[nElems] = value; // insert it
		nElems++; // increment size
	}

	// --------------------------------------------------------------
	public void display() {// displays array contents
		for (int j = 0; j < nElems; j++)
			// for each element,
			System.out.print(a[j] + " "); // display it
		System.out.println("");
		System.out.println("******************" + nElems);
	}

	// --------------------------------------------------------------
	public void bubbleSort() {
		int out, in;

		for (out = nElems - 1; out > 1; out--)
			// outer loop (backward)
			for (in = 0; in < out; in++)
				// inner loop (forward)
				if (a[in] > a[in + 1]) // out of order?
					swap(in, in + 1); // swap them
	} // end bubbleSort()
		// --------------------------------------------------------------

	public void bubbleSort2() {
		// TODO 还没有写好，两个东西，同时走。
		int out, in, end;

		for (out = nElems - 1; out > 1; out--) {
			end = out;
			for (in = 0; in < out; in++) {
				if (a[in] > a[in + 1]) {
					swap(in, in + 1);
				}
			}
			for (;;) {
				// TODO
			}
		}

	}

	private void swap(int one, int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
	// --------------------------------------------------------------
} // end class ArrayBub
// //////////////////////////////////////////////////////////////