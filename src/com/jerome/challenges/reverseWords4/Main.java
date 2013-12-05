/**
 * Main.java
 * reverseWords4
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2013-10-21 		Jerome Song
 *
 * Copyright (c) 2013, JEROME All Rights Reserved.
 */

package com.jerome.challenges.reverseWords4;

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
			final String[] params = line.split("\\s");
			if (line != null && !"".equals(line) && params.length > 0) {
				System.out.println(getReversedString(params));
			}
		}
		reader.close();
	}

	public static String getReversedString(String[] params) {
		StringBuilder builder = new StringBuilder();
		for (int i = params.length - 1; i >= 0; i--) {
			builder.append(params[i]);
			builder.append(" ");
		}
		return builder.toString().trim();
	}
}
