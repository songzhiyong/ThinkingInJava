/**
 * SortAlgo.java
 * com.jerome.algos.sort
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2013-12-6 		Administrator
 *
 * Copyright (c) 2013, JEROME All Rights Reserved.
 */

package com.jerome.algos.sort;

import java.util.Arrays;
import java.util.Random;

import com.jerome.algos.beans.SortInt;

/**
 * ClassName:SortAlgo Function: TODO ADD FUNCTION
 * 
 * @author Administrator
 * @version
 * @Date 2013-12-6 下午2:04:54
 * 
 * @see
 */
public class SortAlgo {
	private static SortInt[] unsortedArr = new SortInt[10];

	public static void main(String[] args) {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			unsortedArr[i] = new SortInt(random.nextInt(10));
		}
		System.out.println(Arrays.toString(unsortedArr));
		insertionSort(unsortedArr, 0, unsortedArr.length - 1);
		System.out.println(Arrays.toString(unsortedArr));
	}

	private SortAlgo findRepeatElement() {
		return new SortAlgo();
	}

	/**
	 * 
	 * insertionSort:插入排序
	 * 
	 * @param @param a
	 * @param @param left
	 * @param @param right
	 * @return void
	 * @throws
	 * @since 下午2:16:07
	 */
	@SuppressWarnings("unchecked")
	private static <T> void insertionSort(Comparable<T>[] a, int left, int right) {
		for (int p = left + 1; p <= right; p++) {
			Comparable<T> tmp = a[p];
			int j;
			for (j = p; j > left && tmp.compareTo((T) a[j - 1]) < 0; j--)
				a[j] = a[j - 1];
			a[j] = tmp;
		}
	}
}
