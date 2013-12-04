package com.jerome.challenges.fizzbuzz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(final String[] args) throws IOException {
		// Verify input argument length.
		if (args.length < 1) {
			throw new RuntimeException("Must specify input file path.");
		} else if (args.length > 1) {
			throw new RuntimeException("Illegal input arguments specified.");
		}

		// Read file from specified path.
		final BufferedReader reader = new BufferedReader(new FileReader(
				new File(args[0])));
		String line;
		while ((line = reader.readLine()) != null) {
			final String[] params = line.split("\\s");
			System.out.println(getFizzBuzz(Integer.valueOf(params[0]),
					Integer.valueOf(params[1]), Integer.valueOf(params[2])));
		}
		reader.close();
	}

	private static String getFizzBuzz(int a, int b, int n) {
		StringBuilder result = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			result.append(i % (a * b) == 0 ? "FB" : i % a == 0 ? "F"
					: i % b == 0 ? "B" : i);
			result.append(" ");
		}
		return result.toString();
	}
}
