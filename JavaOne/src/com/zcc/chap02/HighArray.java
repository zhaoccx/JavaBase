package com.zcc.chap02;

//highArray.java
//demonstrates array class with high-level interface
//to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////
public class HighArray {
	private long[] a; // ref to array a
	private int nElems; // number of data items

	// -----------------------------------------------------------

	public HighArray(int max) { // constructor
		a = new long[max]; // create the array

		nElems = 0; // no items yet
	}

	// -----------------------------------------------------------
	public boolean find(long searchKey) { // find specified value
		int j;
		for (j = 0; j < nElems; j++)
			// for each element,
			if (a[j] == searchKey) // found item?
				break; // exit loop before end
		if (j == nElems) // gone to end?
			return false; // yes, can't find it
		else
			return true; // no, found it
	} // end find()
		// -----------------------------------------------------------

	public void insert(long value) {// put element into array
		a[nElems] = value; // insert it
		nElems++; // increment size
	}

	// -----------------------------------------------------------
	public boolean delete(long value) {
		int j;
		for (j = 0; j < nElems; j++)
			// look for it
			if (value == a[j])
				break;
		if (j == nElems) // can't find it
			return false;
		else // found it
		{
			for (int k = j; k < nElems; k++)
				// move higher ones down
				a[k] = a[k + 1];
			nElems--; // decrement size
			return true;
		}
	} // end delete()
		// -----------------------------------------------------------

	public void display() { // displays array contents
		for (int j = 0; j < nElems; j++)
			// for each element,
			System.out.print(a[j] + " "); // display it
		System.out.println("");
	}

	// -----------------------------------------------------------

	public long getMax() {// get Max item
		if (null == a) {
			return -1L;
		}
		long max = 0L;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}

	public long removeMax() {
		long max = getMax();
		int index = a.length;
		for (int i = 0; i < a.length; i++) {
			if (max == a[i]) {
				index = i;
			}
			if (i > index) {
				a[i - 1] = a[i];
			}
		}
		nElems--;
		return max;
	}

	public int noDup() {
		// TODO 还要改
		int doup = 0;
		for (int i = 0; i < nElems - 1; i++) {
			for (int j = i + 1; j < nElems - 1; j++) {
				if (a[i] == a[j]) {
					a[j] = a[0];
				}
			}
		}
		display();
		for (int i = nElems - 1; i >= 1; i--) {
			if (a[i] == a[0]) {
				for (int j = i; j <= nElems - 1; j++) {
					a[j] = a[j + 1];
				}
				nElems--;
				doup++;
			}
		}

		return doup;

	}

	public int getlength() {
		return nElems;
	}
} // end class HighArray
// //////////////////////////////////////////////////////////////
