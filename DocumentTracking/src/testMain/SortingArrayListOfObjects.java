package testMain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

//inner class
class Student {
	public String name;
	public int age;
	
	public Student (String name, int iage){
		this.name = name;
		this.age = iage;
	}
}

public class SortingArrayListOfObjects {

	public static void main(String[] args) {
		ArrayList<Student > alStudent = new ArrayList<Student>();
		Scanner osScan = new Scanner(System.in);
		Scanner oiScan = new Scanner(System.in);
		
		String sName;
		int iAge;
		int icount;                                                                                                                                                                                                                                                       		
		for(icount = 0; icount <3; icount++) {
			System.out.println("Enter a student name: ");
			sName = osScan.nextLine();
			System.out.println("Enter a student age: ");
			iAge = oiScan.nextInt();
			
			alStudent.add(new Student(sName, iAge));
		}
		
		System.out.println("\n\n");
		
		Collections.sort(alStudent, new Comparator<Student>() {

			@Override
			public int compare(Student arg0, Student arg1) {
				// reverse the arg0 and arg1 to convert it to descending order and ascending order
				return Integer.valueOf(arg0.age).compareTo(arg1.age);
			}
		});
		for(icount = 0; icount<alStudent.size(); icount++){
			System.out.println("name: " + alStudent.get(icount).name + " / "  +"age: "+  alStudent.get(icount).age);
		}
	}
	
}
