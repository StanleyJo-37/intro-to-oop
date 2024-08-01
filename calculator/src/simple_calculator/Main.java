package simple_calculator;

import java.util.Scanner;

// This is a simple calculator which only takes two operands and one
// operator. As we work on our way to learn Java, we will use improvise
// this calculator with new concepts and useful objects to create more
// functionalities.

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String input;
		do {
			input = scanner.nextLine();
			try {
				System.out.println(Calculator.calculate(input));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (input.charAt(0) != 'e');
		
		scanner.close();
	}

}
