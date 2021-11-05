package beadando.XUXEJO.console;

import java.util.Scanner;

import beadando.XUXEJO.library.StringUtil;

public class ConsoleApp {

	public static void main(String[] args) {
		// Ez a ConsoleApp fogja haszn�lni a SharedLibrary 'reverse' meth�dus�t!
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input: ");
		
		String input = scanner.nextLine();
		scanner.close();
		
		String output = StringUtil.reverse(input);
		
		System.out.println("Output: " + output);

	}

}
