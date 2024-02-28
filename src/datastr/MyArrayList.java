package datastr;

import java.util.ArrayList;
import java.util.List;

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
	public void add(int newElement) {
		if(isFull()) resizeArr();
		list[counter] = newElement;
		counter++;
	}
	
	public void addAt(int index, int newElement)throws Exception {
		if(isFull()) resizeArr();
		if(index < 0 || index >= size) throw new Exception("Invalid index");
		if(index == counter) {
			add(newElement);
			return;
		}
		
		for(int i = counter; i > index; i--) {
			list[i] = list[i-1];		
		}
		list[index] = newElement;
		counter++;
	}
	public void deleteAt(int index) throws Exception{
		if(index < 0 || index >= counter) throw new Exception("Invalid index");
		if(isEmpty()) throw new Exception("Array is empty");
		
		for(int i = index; i < counter; i++) {
			list[i] = list[i+1]; 
		}
		counter--;
	}
	
	public int getAt(int index) throws Exception{
		if(index < 0 || index >= counter) throw new Exception("Invalid index");
		if(isEmpty()) throw new Exception("Array is empty");
		
		return list[index];
	}
	public int getElementAtIndex(int index) throws Exception{
		if(index < 0 || index >= counter) throw new Exception("Invalid index");
		if(isEmpty()) throw new Exception("Array is empty");
		
		return list[index];
	}
	public ArrayList getElementIndexes(int element) throws Exception{
		if(isEmpty()) throw new Exception("Array is empty");
		ArrayList indexes = new ArrayList();

		for(int i = 0; i < counter; i++) {
			if(list[i] == element) {
				indexes.add(i);
			}
		}
		if(indexes.size() == 0) throw new Exception("Element is not found in the array!");
		return indexes;
	}
	public int[] getNeighbours(int element) throws Exception {
		ArrayList indexes = getElementIndexes(element);
		int neighboursSize = indexes.size();
		
		if((Integer)indexes.get(indexes.size()-1) == counter -1) {
			neighboursSize--;
		}
		
		int[] neighbours = new int[neighboursSize];
		for(int i = 0; i < neighboursSize; i++) {
			int indexFromSearchTemp = (int)indexes.get(i);
			int indexNeighbourTemp = indexFromSearchTemp+1;
			neighbours[i] = list[indexNeighbourTemp];
		}
		return neighbours;
	}
	public void makeEmpty() {
		size = LIST_DEFAULT_SIZE;
		list = new int[size];
		counter = 0;
		System.gc();
	}
	public void print()throws Exception {
		if(isEmpty()) throw new Exception("Array is empty");
		for(int i = 0; i < counter; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}
	 public void sort() throws Exception{
		if(isEmpty()) throw new Exception("Array is empty");
        int N = size;
        
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N-i-1; j++) {
                if (list[j+1] < list[j]){
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
	 }
}
