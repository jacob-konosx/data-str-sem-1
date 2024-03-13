package service;

import java.io.File;
import java.util.Scanner;

import datastr.MyArrayList;
import model.Student;


public class MainService {
	public static MyArrayList<Integer> readFromFile(String path) throws Exception{
		if(path == null || path.length() < 3) throw new Exception("Problem with file path");

		
		MyArrayList<Integer> listFromNumbers = new MyArrayList<Integer>();
		File file = new File(path);
		Scanner scanner = new Scanner(file);
		
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			Integer tempNumber = Integer.parseInt(line);
			listFromNumbers.add(tempNumber);
		}
		scanner.close();
		return listFromNumbers;
	}
	public static void main(String[] args) {
//		MyArrayList<Integer> myList = new MyArrayList<Integer>(3);
//		myList.add(100);
//		myList.add(200);
//		myList.add(-100);
//		try {
//			myList.print();
//			
//			myList.add(1, 500);
//			myList.print();
//			
//			myList.deleteAt(0);
//			myList.print();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		Student s1 = new Student("Jekabs", "Konosonoks");
//		Student s2 = new Student("Daniels", "Arumskans");
//		Student s3 = new Student("Rebeka", "Ziltina");
//		
//		MyArrayList<Student> allStudents = new MyArrayList<Student>();
//		allStudents.add(s1);
//		allStudents.add(s2);
//		
//		try {
//			allStudents.print();
//
//			allStudents.add(0, s3);
//			allStudents.print();
//			
//			allStudents.sort();
//			allStudents.print();
//
//			
//		} catch (Exception e) {
//			System.out.println(e);		
//		}
		
		try {
			MyArrayList<Integer> integerList = readFromFile("resources//numbers.txt");
			integerList.print();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
