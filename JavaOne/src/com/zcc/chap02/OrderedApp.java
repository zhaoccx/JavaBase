package com.zcc.chap02;

public class OrderedApp {
	public static void main(String[] args) {
		int maxSize = 100; // array size
		OrdArray arr; // reference to array
		arr = new OrdArray(maxSize); // create the array

		arr.insert(77); // insert 10 items
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(67);
		arr.insert(33);

		OrdArray arr2 = new OrdArray(20);

		arr2.insert(88);
		arr2.insert(11);
		arr2.insert(00);
		arr2.insert(66);

		arr2.insert(67);
		arr2.insert(33);

		int searchKey = 55; // search for item
		if (arr.find(searchKey) != arr.size())
			System.out.println("Found " + searchKey);
		else
			System.out.println("Can't find " + searchKey);

		arr.display(); // display items

		arr.delete(00); // delete 3 items
		arr.delete(55);

		arr.delete(99);

		arr.display(); // display items again
		System.out.println("********************");
		arr.insert2(88);
		arr.insert2(88);
		arr.insert2(89);
		arr.insert2(88);
		arr.insert2(8);
		arr.insert2(45);
		arr.display();

		arr.display();
	} // end main()
} // end class OrderedApp