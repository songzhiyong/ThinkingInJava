/**
 * Main.java
 * multiplication10
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2013-10-22 		Jerome Song
 *
 * Copyright (c) 2013, JEROME All Rights Reserved.
 */

package com.jerome.challenges.multiplication10;

/**
 * ClassName:Main Function: TODO ADD FUNCTION
 * 
 * @author Jerome Song
 * @version
 * @Date 2013-10-22 下午8:36:45
 * 
 * @see
 */
public class Main {
	public static void main(String[] args) {
		for (int i = 0; i < 12; i++) {
			System.out.println(getLineAt(i + 1));
		}
	}

	public static String getLineAt(int num) {
		StringBuilder sBuilder = new StringBuilder();
		for (int i = num; i <= 12 * num; i += num) {
			if (i < 10) {
				sBuilder.append("   ");
			} else if (i >= 10 && i < 100) {
				sBuilder.append("  ");
			}else if (i>=100) {
				sBuilder.append(" ");
			}
			sBuilder.append(i);
		}
		return sBuilder.toString().trim();
	}
}
