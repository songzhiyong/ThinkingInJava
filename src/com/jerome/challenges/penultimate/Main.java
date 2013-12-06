/**
 * Main.java
 * multiplesofNumber5
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2013-10-21 		Jerome Song
 *
 * Copyright (c) 2013, JEROME All Rights Reserved.
 */

package com.jerome.challenges.penultimate;

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
		while ((line = reader.readLine()) != null) {
			final String[] params = line.split(" ");
			System.out.println(getNextLastWord(params));
		}
		reader.close();
	}

	public static String getNextLastWord(String[] params) {
		return params[params.length - 2];
	}
}
