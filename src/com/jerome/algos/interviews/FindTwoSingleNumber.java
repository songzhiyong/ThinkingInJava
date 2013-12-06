package com.jerome.algos.interviews;

//在一个数组中除两个数字只出现1次外，其它数字都出现了2次， 要求尽快找出这两个数字。
public class FindTwoSingleNumber {

	public static void find(int[] data) {
		int tmp = data[0];
		for (int i = 1; i < data.length; ++i)
			tmp ^= data[i];

		int step = 0;
		while ((tmp & 1) == 0) {
			tmp >>= 1;
			step++;
		}

		int num1 = 0, num2 = 0;
		for (int i = 0; i < data.length; ++i) {
			if (((data[i] >> step) & 1) > 0)
				num1 ^= data[i];
			else
				num2 ^= data[i];
		}

		System.out.println(String.format("result:%d, %d", num1, num2));
	}

	public static void main(String[] args) {
		find(new int[] { 4, 3, 2, 1, 0, 2, 3, 1 });
		find(new int[] { 7, 9, 102, 12, 32, 12, 9, 7 });
		find(new int[] { 1, 2, 3, 4, 1, 2, 3, 4, 0, 5 });
		find(new int[] { 1, 2, 7, 5, 100, 100, 6, 1, 2, 5 });
	}
}
