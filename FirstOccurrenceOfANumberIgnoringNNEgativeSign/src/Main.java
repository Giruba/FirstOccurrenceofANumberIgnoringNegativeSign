import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("First occurrence of a number ignoring negative sign");
		System.out.println("----------------------------------------------------");
		
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the number of elements in the array");
			int size = scanner.nextInt();
			Integer[] array = new Integer[size];
			for(int index = 0; index < size; index++) {
				System.out.println("Enter the element "+(index+1));
				array[index] = scanner.nextInt();
			}
			PrintFirstOccurrence(array);
		}catch(Exception exception) {
			System.out.println("Thrown exception is "+exception.getMessage());
		}
	}
	
	public static void PrintFirstOccurrence(Integer[] array) {
		Arrays.sort(array, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Math.abs(o1) - Math.abs(o2);
			}
			
		});
		PrintArray(array);
		System.out.println("Enter the element to be found in the array");
		int element = new Scanner(System.in).nextInt();
		int index = IndexOfElementInArray(array, element, 0, array.length);
		if(index != -1) {
			System.out.println("Element "+element+" is present at index "+index);
		}else {
			System.out.println("No such element was found in the array");
		}
	}
	
	public static int IndexOfElementInArray(Integer []array, int element, int start, int end) {
		if(start <= end) {
			int middle = (start+end)/2;
			if(Math.abs(array[middle]) == element) {
				return middle;
			}
			if(Math.abs(array[middle]) < element) {
				return IndexOfElementInArray(array, element, middle+1, end);
			}
			return IndexOfElementInArray(array, element, 0, middle-1);
		}
		return -1;
	}
	
	public static void PrintArray(Integer[] array) {
		System.out.println();
		System.out.println("------- Printing the array -------");
		for(int index = 0; index < array.length; index++) {
			System.out.print(array[index]+" ");
		}
		System.out.println();
	}
}
