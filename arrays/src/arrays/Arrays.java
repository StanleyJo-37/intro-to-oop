package arrays;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Vector;

public class Arrays {
	final static int SIZE = 1000000;
	private static long arr() {
		LocalTime start = LocalTime.now();
		int[] arr = new int[SIZE];
		
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
		System.out.println("Array: " + arr());
		System.out.println("ArrayList : " + arrList());
		System.out.println("Vector: " + vec());
	}

}
