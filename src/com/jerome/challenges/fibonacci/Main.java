package com.jerome.challenges.fibonacci;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(final String[] args) throws IOException {
		if (args.length < 1) {
			throw new RuntimeException("Must specify input file path.");
		} else if (args.length > 1) {
			throw new RuntimeException("Illegal input arguments specified.");
		}
		final BufferedReader reader = new BufferedReader(new FileReader(
				new File(args[0])));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(fibonacci(Integer.valueOf(line)));
		}
		reader.close();
	}

	public static int fibonacci(int num) {
		return num > 1 ? fibonacci(num - 1) + fibonacci(num - 2) : num;
	}
}
