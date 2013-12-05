/**
 * Main.java
 * bitPositions6
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2013-10-21 		Jerome Song
 *
 * Copyright (c) 2013, JEROME All Rights Reserved.
 */

package com.jerome.challenges.bitPositions6;

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
			final String[] params = line.split(",");
			int num = Integer.valueOf(params[0]);
			int p1 = Integer.valueOf(params[1]);
			int p2 = Integer.valueOf(params[2]);
			System.out.println(isSameBit(num, p1, p2));
		}
		reader.close();
	}

	public static boolean isSameBit(int n, int p1, int p2) {
		return (((n >> (p1 - 1)) & 1) == ((n >> (p2 - 1)) & 1));
	}
}
