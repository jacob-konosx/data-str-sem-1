package datastr;

public class MyArrayList {
	private int[] list;
	private final int LIST_DEFAULT_SIZE = 10;
	private int size = LIST_DEFAULT_SIZE;
	private int counter = 0;

	
	//Constructors
	public MyArrayList() {
		list = new int[size];
	}
	public MyArrayList(int inputSize) {
		if(inputSize > 0) {
			size = inputSize;
		}
		list = new int[size];
	}
	
	//isEmpty
	public boolean isEmpty() {
		return counter == 0;
	}
	
	//isFull
	public boolean isFull() {
		return counter == size;
	}
	
	//howManyElements
	public int howManyElements() {
		return counter;
	}
		
	public void resizeArr() {
		int newSize = (size < 100) ? size*2: (int)(size * 1.5);
		int[] newList = new int[newSize];
		
		for(int i = 0; i < counter; i++) {
			newList[i] = list[i];
		}
		
		list = newList;
		System.gc();
		size = newSize;
	}
}
