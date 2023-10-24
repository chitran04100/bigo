package bigO;

import java.util.Scanner;

public class RomanNumber {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Please input your ROMAN NUMBER: ");
		String romanString = scanner.next();

		int romanNumberResult = romanConvertToInt(romanString);
		System.out.println("Integer number: " + romanNumberResult);
		
		scanner.close();
	}

	public static int romanConversion(char romanCharacter) {
		switch (romanCharacter) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return -1;
		}
	}

	public static int romanConvertToInt(String romanString) {
		int result = 0;

		for (int i = 0; i < romanString.length(); i++) {
			int romanChar = romanConversion(romanString.charAt(i));

			if (i + 1 < romanString.length()) {
				int romanNextChar = romanConversion(romanString.charAt(i + 1));
				if (romanChar >= romanNextChar) {
					result += romanChar;
				} else {
					result -= romanChar;
				}
			} else
				result += romanChar;
		}
		return result;
	}
}