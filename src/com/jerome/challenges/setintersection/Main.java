package com.jerome.challenges.setintersection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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
			final String[] params = line.split(";");
			String resultStr = getIntersectionSet(params);
			if (resultStr!=null) {
				System.out.println(resultStr.substring(1, resultStr.length()-1));
			}
		}
		reader.close();
	}
	private static String getIntersectionSet(String[] params){
		Set<String> items1 = new HashSet<String>(Arrays.asList(params[0].split(",")));
		Set<String> items2 = new HashSet<String>(Arrays.asList(params[1].split(",")));
		Set<String> result = new TreeSet<String>(items1);
		result.retainAll(items2);
		if (result.size()!=0) {
			return result.toString();
		}
		return null;
	}

}
