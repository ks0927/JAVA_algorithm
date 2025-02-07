import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int index = -1;
		int value = -1;
		for (int i = 0; i < 3; i++) {
			String next = sc.next();
			if (Character.isDigit(next.charAt(0))) {
				index = i + 1;
				value = Integer.parseInt(next);
			}
		}

		value += 4 - index;

		if (value % 3 == 0 && value % 5 == 0) {
			System.out.println("FizzBuzz");
		}
		if (value % 3 == 0 && value % 5 != 0) {
			System.out.println("Fizz");
		}
		if (value % 3 != 0 && value % 5 == 0) {
			System.out.println("Buzz");
		}
		if (value % 3 != 0 && value % 5 != 0) {
			System.out.println(value);
		}
	}

}
