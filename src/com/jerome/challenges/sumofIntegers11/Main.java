package com.jerome.challenges.sumofIntegers11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		if (args.length < 1) {
			throw new RuntimeException("Must specify input file path.");
		} else if (args.length > 1) {
			throw new RuntimeException("Illegal input arguments specified.");
		}
		final BufferedReader reader = new BufferedReader(new FileReader(
				new File(args[0])));
		String line;
		int sum = 0;
		while ((line = reader.readLine()) != null) {
			sum += Integer.valueOf(line.trim());
		}
		System.out.println(sum);
		reader.close();
	}

}
