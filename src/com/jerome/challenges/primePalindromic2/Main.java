/**
 * Main.java
 * primePalindromic
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2013-10-21 		Jerome Song
 *
 * Copyright (c) 2013, JEROME All Rights Reserved.
 */

package com.jerome.challenges.primePalindromic2;

/**
 * ClassName:Main Function: TODO ADD FUNCTION
 * 
 * @author Jerome Song
 * @version
 * @Date 2013-10-21 下午9:22:09
 * 
 * @see
 */
public class Main {

	public static void main(String[] args) {
		final int MAX = 1000;
		for (int i = MAX; i >= 1; i--) {
			if (isPrime(i) && isPalindrome(i)) {
				System.out.print(i);
				break;
			}
		}
	}

	/**
	 * if isPrime:
	 */
	public static boolean isPrime(int num) {
		if (num == 2)
			return true;
		for (int divisor = 2; divisor <= num / 2; divisor++) {
			if (num % divisor == 0)
				return false;
		}
		return true;
	}

	/** if isPalindrome */
	public static boolean isPalindrome(int num) {
		return num == reverse(num);
	}

	public static int reverse(int num) {
		int reverse = 0;
		while (num != 0) {
			int lastdigit = num % 10;
			reverse = reverse * 10 + lastdigit;
			num = num / 10;
		}
		return reverse;
	}

}
