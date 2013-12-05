/**
 * Snippet.java
 * uniqueelement13
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2013-10-22 		Jerome Song
 *
 * Copyright (c) 2013, JEROME All Rights Reserved.
 */

package com.jerome.challenges.uniqueelement13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
			final String[] params = line.split(",");
			System.out.println(getUniqueElement(params));
		}
		reader.close();
	}

	private static String getUniqueElement(String[] params) {
		ArrayList<Integer> list = new ArrayList<>();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < params.length; i++) {
			int element = Integer.valueOf(params[i]);
			if (!list.contains(element)) {
				list.add(element);
				builder.append(element);
				builder.append(",");
			}
		}
		return builder.toString().substring(0, builder.toString().length()-1);
	}
}
