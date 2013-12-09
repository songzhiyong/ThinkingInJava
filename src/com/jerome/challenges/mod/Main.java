package com.jerome.challenges.mod;

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
			String[] arrays = line.split(",");
			int n = Integer.valueOf(arrays[0]);
			int m = Integer.valueOf(arrays[1]);
			System.out.println(n-(n/m)*m);
		}
		reader.close();
	}
}
