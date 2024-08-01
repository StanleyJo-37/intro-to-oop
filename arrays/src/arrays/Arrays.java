package arrays;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Vector;

public class Arrays {
	final static long SIZE = 1000000;
	final static long iter = 100;
	private static long arr() {
		LocalTime start = LocalTime.now();
		int[] arr = new int[(int)SIZE];
		
		for (int i = 0; i < SIZE; ++i) {
			arr[i] = i + 1;
		}
		
//		arr[SIZE] = SIZE; // This will result in an OutOfBound Exception.
		
		return Duration.between(start, LocalTime.now()).toMillis();
	}
	
	private static long arrList() {
		LocalTime start = LocalTime.now();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for (int i = 0; i < SIZE; ++i) {
			arr.add(i + 1);
		}
		
//		arr.add(SIZE); // This will not cause any exceptions.
		
		return Duration.between(start, LocalTime.now()).toMillis();
	}
	
	private static long vec() {
		LocalTime start = LocalTime.now();
		Vector<Integer> vec = new Vector<Integer>();
		
		for (int i = 0; i < SIZE; ++i) {
			vec.add(i + 1);
		}
		
//		vec.add(SIZE); // This will not cause any exceptions.
		
		return Duration.between(start, LocalTime.now()).toMillis();
	}
	
	public static void main(String[] args) {
		long totalArr = 0, totalArrList = 0, totalVec = 0;
		for (int i = 0; i < iter; ++i) {
			long tmpArr = arr();
			long tmpArrList = arrList();
			long tmpVec = vec();
				
//			Uncomment for individuals iter elapsed item.
//			System.out.printf("Iter-%d\n", i+1);
//			System.out.printf("Array: %d\n", tmpArr);
//			System.out.printf("ArrayList: %d\n", tmpArrList);
//			System.out.printf("Vector: %d\n\n\n", tmpVec);
			
			totalArr += tmpArr;
			totalArrList += tmpArrList;
			totalVec += tmpVec;
		}
		
		System.out.printf("Average %d addition(s) elapsed time in %d iterations\n", SIZE, iter);
		System.out.printf("Array: %f\n", ((float)totalArr / (float)iter));
		System.out.printf("ArrayList: %f\n", ((float)totalArrList / (float)iter));
		System.out.printf("Vector: %f\n\n\n", ((float)totalVec / (float)iter));
	}

}
