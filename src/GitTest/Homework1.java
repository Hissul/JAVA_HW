package GitTest;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;


public class Homework1 {
	
	Scanner scanner = new Scanner(System.in);
	Random random = new Random();
	
	
	//	Программа запрашивает шестизначное число, после
	//	ввода определяет будет ли являтся счастливым билет
	//	с таким номером (сумма первых трех цифр совпадает
	//	с сумой трех последних).
	public void IsHappyTicket () {
		
		System.out.println("Введи шестизначное число");
		int userNumber = scanner.nextInt();
		
		int left = 0, right = 0;
		int counter = 0;
		
		while(userNumber > 0) {
			
			if(counter < 3) {
				right += userNumber % 10;
			}else {
				left += userNumber % 10;
			}		
			
			userNumber = userNumber / 10;			
			++counter;	
		}
		
		if(left == right) {
			System.out.println("Yes");	
			return;
		}
		
		System.out.println( "No");	
	}
	
	
	//	Необходимо нарисовать ёлочку символом звёздочки.
	//	Каждый новый ярус должен быть шире предыдущего.	
	//	С клавиатуры вводится количество ярусов, и высота
	//	первого (верхнего) яруса ёлочки. Ёлочка должна быть
	//	симметричная. 
	public void MakeTree() {
		
		System.out.println("Введи число ярусов и высоту через пробел");
		int row = scanner.nextInt();
		int higth = scanner.nextInt();
		
		int treeHigth = higth;
		
		for(int i = 0 ; i < row ; ++i) {
			for(int j = 0 ; j < treeHigth ; ++j) {
				
				int dots = j * 2 + 1;
				int spases = ((higth + row * higth) - dots) / 2;
				
				for(int t = 0 ; t < spases ; ++t) {
					System.out.print(" ");
				}
				
				for(int t = 0 ; t < dots ; ++t) {
					System.out.print("*");
				}
				
				for(int t = 0 ; t < spases ; ++t) {
					System.out.print(" ");
				}
				
				System.out.println();		
			}
			
			++treeHigth;
		}		
	}
	
	
	//	Сформируйте массив из 10 элементов, заполнив его
	//	целыми случайными числами от –10 до 10. Определите
	//	среднее арифметическое элементов массива. Сформируйте новый массив, переписав в него элементы
	//	исходного массива, меньшие среднего.
	//	Выполните сортировку исходного массива по возрастанию элементов.
	public void ChangingArray() {
		
		int[] array = new int[10];
		
		int min = -10;
		int max = 10;
		
		float average = 0;
		
		System.out.println("Исходный массив");
		
		for(int i = 0 ; i < array.length ; ++i) {
			array[i] = random.nextInt(max - min + 1) + min;	
			average += array[i];
			System.out.print(array[i] + " ");
		}
		System.out.println();
		
		average = average / array.length;
	
		System.out.println("Среднее арифметическое = " + average);
		
		Arrays.sort(array);	
		
		ArrayList<Integer> newArray = new ArrayList<Integer>();
		
		System.out.println("Новый массив");
		
		for(int i = 0 ; i < array.length ; ++i) {
			if(array[i] < average) {
				newArray.add(array[i]);	
				System.out.print(array[i] + " ");
			}
		}
		System.out.println();	
	}
	
	
	//	Сформируйте двумерный целочисленный массив.
	//	Число строк и столбцов нужно запросить у пользователя. Заполните массив случайными числами от 0
	//	до 10 и выведите его на консоль. Удалите из массива
	//	одну строку (номер строки запросите у пользователя).
	//	Распечатайте полученный массив. Используйте статические методы для реализации каждого действия
	//	(инициализация массива, вывод на консоль, удаление
	//	строки).
	public void WorkWhisArray() {
		
		System.out.println("Введи число строк и столбцов через пробел");
		int row = scanner.nextInt();
		int column = scanner.nextInt();
		
		int[][] array = CreateArray(row, column);
		
		System.out.println("Массив :");
		PrintArray(array);
		
		int[][] newArray = DeleteRowFromArray(array, row, column);
		
		System.out.println("Новый массив :");
		PrintArray(newArray);
		
	}
	
	private int[][] CreateArray(int row, int column){
		
		int[][] array = new int[row][column];
		
		for(int i = 0 ; i < row ; ++i) {
			for(int j = 0 ; j < column ; ++j) {
				array[i][j] = random.nextInt(11) ;
			}
		}
		
		return array;
	}
	
	private void PrintArray(int[][] array) {
		
		for(int i = 0 ; i < array.length ; ++i) {
			for(int j = 0 ; j < array[i].length ; ++j) {
				System.out.print(array[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	private int[][] DeleteRowFromArray(int[][] array, int row, int column){
		
		System.out.println("Введи номер строки для удаления (от 1 до " + row + ")");
		int rowForDelete = scanner.nextInt();	
		
		int[][] newArray = new int[row -1][column];
		
		for(int i = 0 ; i < row ; ++i) {			
			for(int j = 0 ; j < column ; ++j) {		
					
				if(i < rowForDelete - 1) {
					newArray[i][j] = array[i][j];					
				}else if(i > rowForDelete - 1) {
					newArray[i-1][j] = array[i][j];
				}
			}
		}
		
		return newArray;
	}
	
	
			
		
	
}
