package GitTest;



public class Main {

	public static void main(String[] args) {
		
		String[] students = {"Ivanov", "Pupkin", "Neivanov"};
		
		int[][] arr = StudentMark.CreateMarks (students);
		
		StudentMark.BestStudent ( students, arr);
		StudentMark.CatchUpBestStudent(students, arr);		

	}
}