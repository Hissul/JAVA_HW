package GitTest;

import java.util.Random;
import LoggerLib.MyLogger;


public class StudentMark {
	

	public static int[][]  CreateMarks (String[] students) {
		
		Random random = new Random();
		
		int[][] marks = new int[3][5];
		
		for(int i = 0 ; i < students.length; ++i) {
			
			System.out.print(students[i] + " : ");
			
			for(int j = 0 ; j < 5 ; ++j) {
				
				marks[i][j] = 1 + random.nextInt(5);
				System.out.print(marks[i][j]);
				
			}
			
			System.out.println();
		}
		
		return marks;
	}
	
	
	public static void BestStudent (String[] students, int[][] arr) {
		
		int stud = 0;
		float tmp = 0;
		
		for(int i = 0 ; i < students.length ; ++i) {
			
			float average = 0 ;
			
			for(int j = 0 ; j < arr[i].length; ++j) {
				average += arr[i][j];
			}
			
			average = average/arr[i].length;
			
			// используем библиотеку
			new MyLogger().AddMessage(average , students[i]);
			
			if(tmp < average) {
				tmp = average;
				stud = i;
			}
		}
		
		System.out.println(students[stud] + " is the best student");		
	}
	
	
	public static void CatchUpBestStudent(String[] students, int[][] arr) {
		
		float bestStud = 0;		
		
		float worstStud = 0;	
		int worst = 0;
		
		
		for(int i = 0 ; i < students.length ; ++i) {
			
			float average = 0 ;
			
			for(int j = 0 ; j < arr[i].length; ++j) {
				average += arr[i][j];
			}
			
			average = average/arr[i].length;
			
			if(worstStud == 0 && bestStud == 0) {
				bestStud = average;				
				worstStud = average;
				worst = i;
			}
			
			if(average > bestStud) {
				bestStud = average;				
			}
			
			if(average < worstStud) {
				worstStud = average;
				worst = i;
			}
			
		}
		
		System.out.println(students[worst] + " is the worst student");
		
		int counter = 0;
		
		while(worstStud < bestStud) {
			
			++counter;
			float average = 0 ;
			
			for(int i = 0 ; i < arr[worst].length ; ++i) {
				average += arr[worst][i];
			}
			
			for(int i = 0 ; i < counter; ++i) {
				average += 5;
			}
			
			average = average / (arr[worst].length + counter);
			worstStud = average;
		}
		
		
		System.out.println("Worst student must get " + counter + " higth grade mark");
	}
}
