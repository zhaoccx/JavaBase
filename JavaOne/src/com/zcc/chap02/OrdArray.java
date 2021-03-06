package com.zcc.chap02;

//orderedArray.java
//demonstrates ordered array class
//to run this program: C>java OrderedApp
////////////////////////////////////////////////////////////////
public class OrdArray {

	private long[] a; // ref to array a
	private int nElems; // number of data items

	// -----------------------------------------------------------

	public OrdArray(int max) {// constructor
		a = new long[max]; // create array
		nElems = 0;
	}

	public int size() {// array length
		return nElems;
	}

	// -----------------------------------------------------------
	public int find(long searchKey) {
		int lowerBound = 0;
		int upperBound = nElems - 1;
		int curIn;

		while (true) {
			curIn = (lowerBound + upperBound) / 2;
			if (a[curIn] == searchKey)

				return curIn; // found it

			else if (lowerBound > upperBound)
				return nElems; // can't find it
			else // divide range
			{
				if (a[curIn] < searchKey)
					lowerBound = curIn + 1; // it's in upper half
				else
					upperBound = curIn - 1; // it's in lower half
			} // end else divide range
		} // end while
	} // end find()
		// -----------------------------------------------------------

	public void insert(long value) {// put element into array
		int j;
		for (j = 0; j < nElems; j++)
			// find where it goes
			if (a[j] > value) // (linear search)
				break;
		for (int k = nElems; k > j; k--)
			// move bigger ones up
			a[k] = a[k - 1];
		a[j] = value; // insert it
		nElems++; // increment size
	} // end insert()
		// -----------------------------------------------------------

	public void insert2(long value) {// put element into array in method
		// TODO 还没有写好。二分查找插入
		int lower = 0;
		int upper = nElems - 1;
		int middle;
		while (true) {

			middle = (lower + upper) / 2;
			if (a[middle] == value) {
				break; // found it
			} else if (lower >= upper) {
				middle++;
				break; // can't find it
			} else // divide range
			{
				if (a[middle] < value)
					lower = middle + 1; // it's in upper half
				else
					upper = middle - 1; // it's in lower half
			} // end else divide range

		}
		if (lower == 0 && upper != nElems - 1) {
			if (!(middle == (nElems - 1) / 2)) {
				middle = 0;
			}
		}
		for (int i = nElems; i > middle; i--) {
			a[i] = a[i - 1];
		}
		a[middle] = value;
		nElems++;
	}

	public boolean delete(long value) {
		int j = find(value);
		if (j == nElems) // can't find it
			return false;
		else // found it
		{
			for (int k = j; k < nElems; k++)
				// move bigger ones down
				a[k] = a[k + 1];
			nElems--; // decrement size
			return true;
		}
	} // end delete()
		// -----------------------------------------------------------

	public long getIndex(int i) {
		return a[i];

	}

	public long[] marge(OrdArray insetarray) {

		for (int i = 0; i < insetarray.size(); i++) {
			this.insert2(insetarray.getIndex(i));
		}
		return a;

	}

	public void display() {// displays array contents
		for (int j = 0; j < nElems; j++)
			// for each element,
			System.out.print(a[j] + " "); // display it
		System.out.println("");
	}
	// -----------------------------------------------------------
} // end class OrdArray
