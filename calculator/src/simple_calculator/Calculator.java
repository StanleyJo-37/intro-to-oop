package simple_calculator;

public class Calculator {
	
	private static Boolean isMethod(char c) {
		return (c == '+' || c == '-' || c == '*' || c == '/');
	}
	
	public static int calculate(String eq) throws Exception {
		int[] arr = new int[2];
		char method = ' ';
		int j = 0;
		
		eq = eq.replaceAll(" ", "");
		
		for (int i = 0, last = 0; i < eq.length(); ++i) {
			char c = eq.charAt(i);
			
			if (Calculator.isMethod(c)) {
				method = c;
				arr[j] = Integer.parseInt(eq.substring(last, i));
				last = i + 1;
				++j;
			} else if (i == eq.length() - 1) {
				arr[j] = Integer.parseInt(eq.substring(last, i+1));
				++j;
			} else if (!Character.isDigit(c)) throw new Exception("Found unexpected token.");
		}
		
		if (method == ' ' || j < 2) throw new Exception("Wrong format.");
		
		switch (method) {
		case '+':
			return Calculator.addition(arr[0], arr[1]);
		case '-':
			return Calculator.subtraction(arr[0], arr[1]);
		case '*':
			return Calculator.multiplication(arr[0], arr[1]);
		case '/':
			return Calculator.division(arr[0], arr[1]);
		default:
			throw new Exception("No method found.");
		}
	}
	
	public static int addition(int a, int b) {
		return a + b;
	}
	
	public static int subtraction(int a, int b) {
		return a - b;
	}
	
	public static int multiplication(int a, int b) {
		return a * b;
	}
	
	public static int division(int a, int b) {
		return a / b;
	}
}
