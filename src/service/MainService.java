package service;

import datastr.MyArrayList;

public class MainService {

	public static void main(String[] args) {
		MyArrayList myList = new MyArrayList(3);
		myList.add(100);
		myList.add(200);
		myList.add(-100);
		try {
			myList.print();
			myList.addAt(1, 500);
			myList.print();
			myList.deleteAt(0);
			myList.print();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
