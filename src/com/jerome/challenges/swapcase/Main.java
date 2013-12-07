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

package com.jerome.challenges.swapcase;

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
			System.out.println(reverseCase(line));
		}
		reader.close();
	}

	public static String swapCase(String param) {
		char[] cs = param.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] >= 65 && cs[i] <= 90) {
				cs[i] += 32;
			} else if (cs[i] >= 97 && cs[i] <= 122) {
				cs[i] -= 32;
			}
		}
		return new String(cs);
	}
	public static String reverseCase(String text)
	{
	    char[] chars = text.toCharArray();
	    for (int i = 0; i < chars.length; i++)
	    {
	        char c = chars[i];
	        if (Character.isUpperCase(c))
	        {
	            chars[i] = Character.toLowerCase(c);
	        }
	        else if (Character.isLowerCase(c))
	        {
	            chars[i] = Character.toUpperCase(c);
	        }
	    }
	    return new String(chars);
	}
}
