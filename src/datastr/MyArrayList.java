package datastr;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList<Ttype> {
	private Ttype[] list;
	private final int LIST_DEFAULT_SIZE = 10;
	private int size = LIST_DEFAULT_SIZE;
	private int counter = 0;

	
	//Constructors
	public MyArrayList() {
		list = (Ttype[]) new Object[size];
	}
	public MyArrayList(int inputSize) {
		if(inputSize > 0) {
			size = inputSize;
		}
		list = (Ttype[]) new Object[size];
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
		Ttype[] newList = (Ttype[]) new Object[newSize];
		
		for(int i = 0; i < size; i++) {
			newList[i] = list[i];
		}
		
		list = newList;
		System.gc();
		size = newSize;
	}
	public void add(Ttype newElement) {
		if(isFull()) resizeArr();
		list[counter] = newElement;
		counter++;
	}
	
	public void add(int index, Ttype newElement)throws Exception {
		if(index < 0 || index > counter) throw new Exception("Incorrect index");		
		
		if(isFull()) resizeArr();
		if(index == counter) {
			add(newElement);
		}else {
			for(int i = counter; i > index; i--) {
				list[i] = list[i-1];		
			}
			list[index] = newElement;
			counter++;
		}
		
	}
	public void deleteAt(int index) throws Exception{
		if(index < 0 || index >= counter) throw new Exception("Invalid index");
		if(isEmpty()) throw new Exception("Array is empty");
		
		for(int i = index; i < counter-2; i++) {
			list[i] = list[i+1]; 
		}
		counter--;
	}
	
	public Ttype getAt(int index) throws Exception{
		if(index < 0 || index >= counter) throw new Exception("Invalid index");
		if(isEmpty()) throw new Exception("Array is empty");
		
		return list[index];
	}
	
	public Ttype getElementAtIndex(int index) throws Exception{
		if(index < 0 || index >= counter) throw new Exception("Invalid index");
		if(isEmpty()) throw new Exception("Array is empty");
		
		return list[index];
	}
	
	public ArrayList getElementIndexes(Ttype element) throws Exception{
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
	
	public Ttype[] getNeighbours(Ttype element) throws Exception {
		ArrayList indexes = getElementIndexes(element);
		int neighboursSize = indexes.size();
		
		if((Integer)indexes.get(indexes.size()-1) == counter -1) {
			neighboursSize--;
		}
		
		Ttype[] neighbours = (Ttype[]) new Object[neighboursSize];
		for(int i = 0; i < neighboursSize; i++) {
			int indexFromSearchTemp = (int)indexes.get(i);
			int indexNeighbourTemp = indexFromSearchTemp+1;
			neighbours[i] = list[indexNeighbourTemp];
		}
		return neighbours;
	}
	
	public void makeEmpty() {
		size = LIST_DEFAULT_SIZE;
		list = (Ttype[]) new Object[size];
		counter = 0;
		System.gc();
	}
	
	public void print()throws Exception {
		if(isEmpty()) throw new Exception("Array is empty");
		// System.out.println(counter);
		for(int i = 0; i < counter; i++) {
			System.out.println(list[i] + " ");
		}
		System.out.println();
	}
	
	public void sort() throws Exception{
		if(isEmpty()) throw new Exception("Array is empty");
        
        for (int i = 0; i < counter; i++) {
            for (int j = 0; j < counter; j++) {
                if (((Comparable)(list[i])).compareTo(list[j]) == -1 ){
                    Ttype temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
	 }
}
