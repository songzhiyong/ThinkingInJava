/**
 * Main.java
 * sumofPrimes3
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2013-10-21 		Jerome Song
 *
 * Copyright (c) 2013, JEROME All Rights Reserved.
 */

package com.jerome.challenges.sumofPrimes3;

/**
 * ClassName:Main Function: TODO ADD FUNCTION 1000个素数之和
 * 
 * @author Jerome Song
 * @version
 * @Date 2013-10-21 下午9:32:48
 * 
 * @see
 */
public class Main {

	public static void main(String[] args) {
		final int total = 1000;
		int count = 0;
		int sum = 0;
		int number = 2;
		while (count < total) {
			if (isPrime(number)) {
				sum += number;
				count++;
			}
			number++;
		}
		System.out.println(sum);

	}

	public static boolean isPrime(int num) {
		if (num == 2)
			return true;
		for (int divisor = 2; divisor <= num / 2; divisor++) {
			if (num % divisor == 0)
				return false;
		}
		return true;
	}
}
